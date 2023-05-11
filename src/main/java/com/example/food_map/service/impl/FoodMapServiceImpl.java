package com.example.food_map.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.util.StringUtils;

import com.example.food_map.constants.RtnCode;
import com.example.food_map.entity.FoodMap1;
import com.example.food_map.entity.FoodMap2;
import com.example.food_map.entity.FoodMap2Id;
import com.example.food_map.respository.FoodMap1DAO;
import com.example.food_map.respository.FoodMap2DAO;
import com.example.food_map.service.ifs.FoodMapService;
import com.example.food_map.test.vo.FoodMap2Response;
import com.example.food_map.test.vo.FoodMapResponse;

@Service
public class FoodMapServiceImpl implements FoodMapService {
	
	@Autowired
	private FoodMap1DAO foodMap1Dao;
	@Autowired
	private FoodMap2DAO foodMap2Dao;
	

	@Override
	public FoodMapResponse f1AddInfo(FoodMap1 foodMap1) {
		//�d�ߩ��W�O�_��J���T(���ର��,null,�ťզr��)
		if(!StringUtils.hasText(foodMap1.getShopName()) || foodMap1.getShopName()==null) {
			return new FoodMapResponse(RtnCode.CANNOT_EMPTY.getMessage());			
		}
		//�d�߫����W�O�_��J���T(���ର��,null,�ťզr��)
		if(!StringUtils.hasText(foodMap1.getCity()) || foodMap1.getCity()==null) {
			return new FoodMapResponse(RtnCode.CANNOT_EMPTY.getMessage());			
		}
		//�d�ߩ��W�O�_�w�s�b���L����(�u���@�a���|������)
		Optional<FoodMap1> op = foodMap1Dao.findById(foodMap1.getShopName());
		if(op.isPresent()) {
			return new FoodMapResponse(RtnCode.ALREADY_EXIST.getMessage());	
		}
		//�T�{���a�������O�t��(�������a�����O0,�\�I�s�W�X�Ӥ���A�⩱�a�����[�i�h)
		if(foodMap1.getShopStar()<0) {
			return new FoodMapResponse(RtnCode.DATA_ERROR.getMessage());			
		}

		//�T�w��ƵL�~����s�ئ��\,�O�s���Ʈw
		foodMap1Dao.save(foodMap1);
		return new FoodMapResponse(foodMap1,RtnCode.SUCCESSFUL.getMessage());	
	}
	
	@Override
	public FoodMap2Response f2AddInfo(FoodMap2 foodMap2) {
		//�d�ߩ��W�O�_��J���T(���ର��,null,�ťզr��)
		if(!StringUtils.hasText(foodMap2.getStoreName()) || foodMap2.getStoreName()==null) {
			return new FoodMap2Response(RtnCode.CANNOT_EMPTY.getMessage());			
		}
		//�d�ߩ��W�O�_�s�b���1
		Optional<FoodMap1> op = foodMap1Dao.findById(foodMap2.getStoreName());
		if(!op.isPresent()) {
			return new FoodMap2Response(RtnCode.NOT_FOUND.getMessage());
		}
		//�d���\�I�W�O�_��J���T(���ର��,null,�ťզr��)
		if(!StringUtils.hasText(foodMap2.getMenu()) || foodMap2.getMenu()==null) {
			return new FoodMap2Response(RtnCode.CANNOT_EMPTY.getMessage());			
		}
		//�P�@�a�����\�I�W�٤��୫��
		FoodMap2Id  f2Id = new FoodMap2Id(foodMap2.getStoreName(),foodMap2.getMenu());
		Optional<FoodMap2> opp = foodMap2Dao.findById(f2Id);
		if(opp.isPresent()) {
			return new FoodMap2Response(RtnCode.ALREADY_EXIST.getMessage());
		}	
		//�C�a�\�U���\�I�ƶq����W�L�T�D��
		List<FoodMap2>temp1 = foodMap2Dao.findByStoreNameContaining(foodMap2.getStoreName());
		if(temp1.size()+1>3) {
			return new FoodMap2Response(RtnCode.EXCEED.getMessage());
		}
		//�d�߻���O�_��J���T(���ର�t�Ʃ�0)
		if(foodMap2.getPrice()<=0) {
			return new  FoodMap2Response(RtnCode.DATA_ERROR.getMessage());
		}
		//�d���\�I����(���ର�t�ƩΤp��1�Τj��5)
		if(foodMap2.getMenuStar()<1||foodMap2.getMenuStar()>5) {
			return new  FoodMap2Response(RtnCode.DATA_ERROR.getMessage());
		}		
		//�T�w��ƵL�~����s�ئ��\,�O�s���Ʈw
		foodMap2Dao.save(foodMap2);	
		double review = foodMap2Dao.avgMenu(foodMap2.getStoreName());
		FoodMap1 temp = op.get();
		temp.setShopStar(review);
		foodMap1Dao.save(temp);
		return new FoodMap2Response(foodMap2,RtnCode.SUCCESSFUL.getMessage());	
	}

		//�j�M�S�w������X�Ҧ������a�A�i������ܵ���(0�ΨS�������ܥ���)��ܩ��W�B���a�����B�\�I�B�\�I����B�\�I����
	
		@Override	
		public FoodMap2Response findAllByLimit(String cityName, int count){
			List<FoodMap1> op = foodMap1Dao.findByCity(cityName);
			if(op.size()<=0) {
				return new FoodMap2Response(RtnCode.NOT_FOUND.getMessage());
			}
			
			List<FoodMap1>findCity = foodMap1Dao.findAllByLimit(cityName);
			List<String>findShopNameByLimit = new ArrayList<>();			

			if(count >= findCity.size() || count == 0 ) {				
				for(int i =0; i<findCity.size(); i++) {
					findShopNameByLimit.add(findCity.get(i).getShopName());

				}
			}else {
				for(int i =0 ; i<count; i ++) {
					findShopNameByLimit.add(findCity.get(i).getShopName());

				}
			}
			List<FoodMap2> res = foodMap2Dao.findAllByName(findShopNameByLimit);

			return new FoodMap2Response(findCity,res , RtnCode.SUCCESSFUL.getMessage());	
		}

		
		//�j�M���a�����X���H�W(�t)
//		@Override
//		public FoodMap2Response findByShopStarGreaterThanEqualOrderByShopStarAsc(double findStar) {
//			List<FoodMap1> findFM2 =  foodMap1Dao.findByShopStarGreaterThanEqualOrderByShopStarAsc(findStar) ;
//
//			if(findFM2.size()<=0 ) {
//				return new FoodMap2Response(RtnCode.NOT_FOUND.getMessage());
//			}
//			List<String>findMenu = new ArrayList<>();
//			for(int i =0;i<findFM2.size();i++) {
//				findMenu.add(findFM2.get(i).getShopName());
//			}			
//			List<FoodMap2>res1 = foodMap2Dao.findAllByName(findMenu);			
//			return new FoodMap2Response(findFM2, res1 ,RtnCode.SUCCESSFUL.getMessage());
//		}
		
		//�j�M���a�����X���H�W(�t)�̩��a�����Ƨ�
		@Override
		public FoodMapResponse findByShopStar(double shopStar) {
			List<Object[]>shopStarList= foodMap1Dao.findByShopStar(shopStar);
			List<String> shopStars = new ArrayList<>();
					
			for(Object[] shopStar1 : shopStarList) {
				String shopStarStr =shopStar1[0]+" "+ shopStar1[1]+" "+shopStar1[2]+" "+shopStar1[3]+" "+shopStar1[4]+" "+shopStar1[5]+" "+shopStar1[6];
				shopStars.add(shopStarStr);
		    }
		    return new FoodMapResponse(shopStars, RtnCode.SUCCESSFUL.getMessage());

		}

		//�j�M���a�����X���H�W(�t) + �\�I�����X���H�W(�t) �̩��a���� + �\�I�����Ƨ�
		@Override
		public FoodMapResponse findByShopStarAndMenuStar(double shopStar, double menuStar) {
			List<Object[]>shopStarList= foodMap1Dao.findByShopStarAndMenuStar(shopStar, menuStar);
			List<String> shopStars = new ArrayList<>();
			for(Object[] shopStar1 : shopStarList) {
				String shopStarStr =shopStar1[0]+" "+ shopStar1[1]+" "+shopStar1[2]+" "+shopStar1[3]+" "+shopStar1[4]+" "+shopStar1[5];
				shopStars.add(shopStarStr);
		    }

			return new FoodMapResponse(shopStars, RtnCode.SUCCESSFUL.getMessage());
		}

		//�R�����a�A�n���ˬd�t�@�i��O�_���ө��a���\�I�s�b�F�Y���A�R��
		@Override
		public FoodMapResponse deleteByName(String shopName) {
			int deleteName = foodMap1Dao.deleteByName(shopName);
			List<FoodMap2> op = foodMap2Dao.findByStoreNameContaining(shopName);
			if(op.size()>0) {
				foodMap2Dao.deleteAll(op);
			}

			return new FoodMapResponse(deleteName,op, "�H�W��Ƥw���\�Q�R��");
		}


}

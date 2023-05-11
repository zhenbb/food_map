package com.example.food_map.service.ifs;

import java.util.List;

import javax.transaction.Transactional;

import com.example.food_map.entity.FoodMap1;
import com.example.food_map.entity.FoodMap2;
import com.example.food_map.test.vo.FoodMap2Response;
import com.example.food_map.test.vo.FoodMapResponse;

public interface FoodMapService {
	
	public FoodMapResponse f1AddInfo(FoodMap1 foodMap1);
	public FoodMap2Response f2AddInfo(FoodMap2 foodMap2);
	public FoodMap2Response findAllByLimit(String cityName, int count);
//	public FoodMap2Response findByShopStarGreaterThanEqualOrderByShopStarAsc(double findStar);
	public FoodMapResponse findByShopStar(double shopStar);
	public FoodMapResponse findByShopStarAndMenuStar(double shopStar , double menuStar);
	@Transactional
	public FoodMapResponse deleteByName(String shopName);
}

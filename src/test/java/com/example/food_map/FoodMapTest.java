package com.example.food_map;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.food_map.entity.FoodMap1;
import com.example.food_map.entity.FoodMap2;
import com.example.food_map.respository.FoodMap1DAO;
import com.example.food_map.respository.FoodMap2DAO;
import com.example.food_map.test.vo.FoodMap2Response;


@SpringBootTest
public class FoodMapTest {

	@Autowired
	private FoodMap1DAO foodMap1Dao;
	
	@Autowired
	private FoodMap2DAO foodMap2Dao;
	
	@Test
	public void f1AddInfo() {
		FoodMap1 foodMap1= new FoodMap1("¹©¤ý" ,"¥xªF¥«" , 4.2);
		foodMap1Dao.save(foodMap1);
	}
	
	@Test
	public void f2AddInfo() {
		FoodMap2 foodMap2 = new FoodMap2("¹©¤ý","ÀpÀmÁç",700,4.7);
		foodMap2Dao.save(foodMap2);

	}
	

}

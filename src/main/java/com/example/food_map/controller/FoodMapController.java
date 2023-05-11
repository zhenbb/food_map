package com.example.food_map.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.example.food_map.service.ifs.FoodMapService;
import com.example.food_map.test.vo.FoodMap2Response;
import com.example.food_map.test.vo.FoodMapRequest;
import com.example.food_map.test.vo.FoodMapResponse;

@RestController
public class FoodMapController {

	
	@Autowired
	public FoodMapService foodMapService;
	
	@PostMapping(value ="f1_add_info")
	public FoodMapResponse f1AddInfo(@RequestBody FoodMapRequest request) {
		return foodMapService.f1AddInfo(request.getFoodMap1());
	}
	
	@PostMapping(value = "f2_add_info")
	public FoodMap2Response f2AddInfo(@RequestBody FoodMapRequest request1) {
		return foodMapService.f2AddInfo(request1.getFoodMap2());
	}
	
	@PostMapping(value = "findAllByLimit")
	public FoodMap2Response findAllByLimit(@RequestBody FoodMapRequest request2) {
		return foodMapService.findAllByLimit(request2.getCityName(),request2.getCount());
	}
	
//	@PostMapping(value = "findStar")
//	public FoodMap2Response findByShopStarGreaterThanEqualOrderByShopStarAsc(@RequestBody FoodMapRequest request) {
//		return foodMapService.findByShopStarGreaterThanEqualOrderByShopStarAsc(request.getFindStar());
//	}
	
	@PostMapping(value = "findByShopStar")
	public FoodMapResponse findByShopStar(@RequestBody FoodMapRequest request) {
		return foodMapService.findByShopStar(request.getShopStar());
	}
	
	
	@PostMapping(value = "findByStar")
	public FoodMapResponse findByShopStarAndMenuStar(@RequestBody FoodMapRequest request) {
		return foodMapService.findByShopStarAndMenuStar(request.getShopStar() , request.getMenuStar());
	}
	
	@PostMapping(value = "deleteByName")
	public FoodMapResponse deleteByName(@RequestBody FoodMapRequest request) {
		return foodMapService.deleteByName(request.getShopName());
	}

}

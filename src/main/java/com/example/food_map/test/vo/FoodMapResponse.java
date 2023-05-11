package com.example.food_map.test.vo;

import java.util.List;

import com.example.food_map.entity.FoodMap1;
import com.example.food_map.entity.FoodMap2;

public class FoodMapResponse {
	
	private FoodMap1 foodMap1;
	private int result;
	
	
	public int getResult() {
		return result;
	}

	public void setResult(int result) {
		this.result = result;
	}

	private List<String>foodMap;
	private List<FoodMap2>foodMap2;


	public List<FoodMap2> getFoodMap2() {
		return foodMap2;
	}

	public void setFoodMap2(List<FoodMap2> foodMap2) {
		this.foodMap2 = foodMap2;
	}

	public FoodMapResponse(List<String> foodMap, String message) {
		super();
		this.foodMap = foodMap;
		this.message = message;
	}

	public List<String> getFoodMap() {
		return foodMap;
	}

	public void setFoodMap(List<String> foodMap) {
		this.foodMap = foodMap;
	}

	private String message;

	public FoodMapResponse() {
		super();
	}
	
	public FoodMapResponse(String message) {
		super();
		this.message = message;
	}

	public FoodMapResponse(int result, List<FoodMap2> foodMap2,String message) {
		super();
		this.result = result;
		this.foodMap2 = foodMap2;
		this.message = message;
	}
	
	public FoodMapResponse(FoodMap1 foodMap1, String message) {
		super();
		this.foodMap1 = foodMap1;
		this.message = message;
	}

	public FoodMap1 getFoodMap1() {
		return foodMap1;
	}

	public void setFoodMap1(FoodMap1 foodMap1) {
		this.foodMap1 = foodMap1;
	}
	


	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}	

}

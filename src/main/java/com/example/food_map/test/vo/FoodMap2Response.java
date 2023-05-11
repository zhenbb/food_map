package com.example.food_map.test.vo;

import java.util.List;

import com.example.food_map.entity.FoodMap1;
import com.example.food_map.entity.FoodMap2;

public class FoodMap2Response {
	
	private FoodMap2 foodMap2;
	
	private List<FoodMap2> foodMap22;
	private List<FoodMap1> foodMap1;
	
	private String message;
	
//	private  List<Double> star;
//
//	public List<Double> getStar() {
//		return star;
//	}
//
//	public void setStar(List<Double> star) {
//		this.star = star;
//	}

	public FoodMap2Response() {
		super();
	}

	public FoodMap2Response(String message) {
		super();
		this.message = message;
	}

	public FoodMap2Response(List<FoodMap1> foodMap1,List<FoodMap2> foodMap22,  String message) {
		super();
		this.foodMap22 = foodMap22;
		this.foodMap1 = foodMap1;
		this.message = message;
	}

	public List<FoodMap1> getFoodMap1() {
		return foodMap1;
	}

	public void setFoodMap1(List<FoodMap1> foodMap1) {
		this.foodMap1 = foodMap1;
	}

//	public FoodMap2Response(List<FoodMap2> foodMap22, String message, List<Double> star) {
//		super();
//		this.foodMap22 = foodMap22;
//		this.message = message;
//		this.star = star;
//	}

	public FoodMap2Response(FoodMap2 foodMap2, String message) {
		super();
		this.foodMap2 = foodMap2;
		this.message = message;
	}
	
	public FoodMap2Response(List<FoodMap2> foodMap22, String message) {
		super();
		this.foodMap22 = foodMap22;
		this.message = message;
	}
	
	
	
	public List<FoodMap2> getFoodMap22() {
		return foodMap22;
	}

	public void setFoodMap22(List<FoodMap2> foodMap22) {
		this.foodMap22 = foodMap22;
	}



	public FoodMap2 getFoodMap2() {
		return foodMap2;
	}

	public void setFoodMap2(FoodMap2 foodMap2) {
		this.foodMap2 = foodMap2;
	}


	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	

}

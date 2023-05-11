package com.example.food_map.test.vo;

import com.example.food_map.entity.FoodMap1;
import com.example.food_map.entity.FoodMap2;
import com.fasterxml.jackson.annotation.JsonProperty;

public class FoodMapRequest {
	
	@JsonProperty("f1AddInfo")
	FoodMap1 foodMap1;

	public FoodMap1 getFoodMap1() {
		return foodMap1;
	}

	public void setFoodMap1(FoodMap1 foodMap1) {
		this.foodMap1 = foodMap1;
	}

	@JsonProperty("f2AddInfo")
	FoodMap2 foodMap2;

	public FoodMap2 getFoodMap2() {
		return foodMap2;
	}

	public void setFoodMap2(FoodMap2 foodMap2) {
		this.foodMap2 = foodMap2;
	}
	
	//@JsonProperty("findAllByLimit")
	private String cityName;
	private String shopName;
	private double shopStar;
	private int count;

	private double menuStar;
	
	public double getMenuStar() {
		return menuStar;
	}

	public void setMenuStar(double menuStar) {
		this.menuStar = menuStar;
	}

	public FoodMapRequest() {
		super();

	}
	
	
	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	
	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
	
	public String getShopName() {
		return shopName;
	}

	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

	public double getShopStar() {
		return shopStar;
	}

	public void setShopStar(double shopStar) {
		this.shopStar = shopStar;
	}

	public FoodMapRequest(String cityName, String shopName, double shopStar, int count) {
		super();
		this.cityName = cityName;
		this.shopName = shopName;
		this.shopStar = shopStar;
		this.count = count;
	}

	private double findStar;

	public double getFindStar() {
		return findStar;
	}

	public void setFindStar(double findStar) {
		this.findStar = findStar;
	}
	
	
}

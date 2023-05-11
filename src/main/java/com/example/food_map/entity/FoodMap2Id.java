package com.example.food_map.entity;

import java.io.Serializable;

public class FoodMap2Id implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private String storeName;
	
	private String menu;
	
	

	public FoodMap2Id() {
		super();

	}

	public FoodMap2Id(String storeName, String menu) {
		super();
		this.storeName = storeName;
		this.menu = menu;
	}

	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	public String getMenu() {
		return menu;
	}

	public void setMenu(String menu) {
		this.menu = menu;
	}

	
	
}

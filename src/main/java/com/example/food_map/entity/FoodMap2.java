package com.example.food_map.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;


@Entity
@Table(name="food_map2")
@IdClass(value =FoodMap2Id.class)
public class FoodMap2 {
	
	@Id
	@Column(name = "store_name")
	private String storeName;
	
	@Id
	@Column(name = "menu")
	private String menu;

	@Column(name = "price")
	private int price;
	
	@Column(name = "menu_star")
	private Double menuStar;

	public FoodMap2() {
		super();

	}

	public FoodMap2(String storeName, String menu, int price, Double menuStar) {
		super();
		this.storeName = storeName;
		this.menu = menu;
		this.price = price;
		this.menuStar = menuStar;
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

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public Double getMenuStar() {
		return menuStar;
	}

	public void setMenuStar(Double menuStar) {
		this.menuStar = menuStar;
	}
	
	

}

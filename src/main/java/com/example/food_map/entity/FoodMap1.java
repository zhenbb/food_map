package com.example.food_map.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="food_map1")
public class FoodMap1 {
	
	@Id
	@Column(name="shop_name")
	private String shopName;
	@Column(name="city")
	private String city;
	@Column(name="shop_star")
	private Double shopStar;
	
	
	
	public FoodMap1() {
		super();

	}
	public FoodMap1(String shopName, String city, Double shopStar) {
		super();
		this.shopName = shopName;
		this.city = city;
		this.shopStar = shopStar;
	}
	public String getShopName() {
		return shopName;
	}
	public void setShopName(String shopName) {
		this.shopName = shopName;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public Double getShopStar() {
		return shopStar;
	}
	public void setShopStar(Double shopStar) {
		this.shopStar = shopStar;
	}

	
	
	
	
	
}

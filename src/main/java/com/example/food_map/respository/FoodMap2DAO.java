package com.example.food_map.respository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.food_map.entity.FoodMap1;
import com.example.food_map.entity.FoodMap2;
import com.example.food_map.entity.FoodMap2Id;




@Repository
public interface FoodMap2DAO extends JpaRepository<FoodMap2,FoodMap2Id>{
	
	public List<FoodMap2> findByStoreNameContaining(String str);
			
	@Query("select round(avg(menuStar),1) from FoodMap2 fm2 where fm2.storeName= :sName ")
	public double avgMenu(
			@Param("sName")String storeName
	);
	
	@Query("select fm2  from FoodMap2 fm2 "
			+ "where storeName IN (:shopNames)")
	public List<FoodMap2>findAllByName(
			@Param("shopNames")List<String> shopNames);

	
}

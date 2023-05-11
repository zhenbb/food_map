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

@Repository
public interface FoodMap1DAO extends JpaRepository<FoodMap1,String>{
	public List<FoodMap1> findByCity(String str);
	
	//select * from «ØÄ³¼gÄæ¦ì
		@Query("select f  from FoodMap1 f "
				+ "where city = (:city) ")
		public List<FoodMap1> findAllByLimit(
				@Param("city")String cityName);
	
	//public List<FoodMap1> findByShopStarGreaterThanEqualOrderByShopStarAsc(double findStar);

		@Query(value = "select * from food_map1  f1  join food_map2  f2 on f1.shop_name = f2.store_name"
				+ " where f1.shop_star >= :shopStar " ,nativeQuery = true)
		public List<Object[]>findByShopStar(
				@Param("shopStar")double shopStar);
		
		@Query(value = "select food_map1.city , food_map1.shop_name , food_map1.shop_star ,food_map2.menu , food_map2.price , food_map2.menu_star"
				+ " from food_map1 join food_map2  on food_map1.shop_name = food_map2.store_name"
				+ " where food_map1.shop_star>= :shopStar and food_map2.menu_star >= :menuStar order by food_map1.shop_star " , nativeQuery = true)
		public List<Object[]>findByShopStarAndMenuStar(
				@Param("shopStar")double shopStar , 
				@Param("menuStar")double menuStar);
		
		@Transactional
		@Modifying
		@Query("delete from FoodMap1 where shopName = :shopName")
		public int deleteByName(
				@Param("shopName")String shopName);
		
		
}

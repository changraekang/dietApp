package com.cos.dietApp.domain.diary;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface FoodDiaryRepository extends JpaRepository<FoodDiary, Integer>{
		
	@Query(value = "select * from foodDiary where userId = :userId ORDER BY date desc" , nativeQuery = true)
	List<FoodDiary> mFoodList (int userId);

}

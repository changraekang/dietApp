package com.cos.dietApp.domain.diary;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ExerciseDiaryRepository extends JpaRepository<ExerciseDiary, String> {

	
	@Query(value = "select * from user where userId = :userId" , nativeQuery = true)
	List<ExerciseDiary> mExerciseList( String userId );
}

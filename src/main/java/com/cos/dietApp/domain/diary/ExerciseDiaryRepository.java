package com.cos.dietApp.domain.diary;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ExerciseDiaryRepository extends JpaRepository<ExerciseDiary, Integer> {

	
	@Query(value = "select * from exercisediary where userId = :userId ORDER BY date desc " , nativeQuery = true)
	List<ExerciseDiary> mExerciseList( int userId );
}

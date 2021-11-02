package com.cos.dietApp.service;

import java.nio.file.Files; 
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID; 

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cos.dietApp.domain.diary.ExerciseDiary;
import com.cos.dietApp.domain.diary.ExerciseDiaryRepository;
import com.cos.dietApp.domain.diary.FoodDiary;
import com.cos.dietApp.domain.diary.FoodDiaryRepository;
import com.cos.dietApp.domain.user.User;
import com.cos.dietApp.web.dto.ExerciseReqDto;
import com.cos.dietApp.web.dto.FoodReqDto;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DiaryService {
	private final FoodDiaryRepository foodDiaryRepository;
	private final ExerciseDiaryRepository exerciseDiaryRepository;

	/*
	@Value("${file.path}")
	private String uploadFolder;
	
	 
	@Transactional
	public void 식단일기(@Valid FoodReqDto dto) {
		UUID uuid = UUID.randomUUID();
		String imageFileName = uuid+"_"+dto.getFile().getOriginalFilename();
		
		Path imageFilePath = Paths.get(uploadFolder+imageFileName);
		//System.out.println("파일패스 : "+imageFilePath);
		try {
			Files.write(imageFilePath, dto.getFile().getBytes());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		foodDiaryRepository.save(dto.toEntity(imageFileName));

	}
	 */

	@Transactional
	public void 운동일기(@Valid ExerciseReqDto dto , User principal) {

		exerciseDiaryRepository.save(dto.toEntity(principal));

	}
	@Transactional
	public void 식단일기 (@Valid FoodReqDto dto, User principal) {
		
		foodDiaryRepository.save(dto.toEntity(principal));
		
	}
	public List<ExerciseDiary> 운동일기보기( int id) {
		
		List<ExerciseDiary> exerciseDiaries = exerciseDiaryRepository.mExerciseList(id); 
		
		
		System.out.println(exerciseDiaries + "운동일기");
		return exerciseDiaries;
		
	}
	public List<FoodDiary> 식단일기보기( int id) {
		
		List<FoodDiary> foodDiaries = foodDiaryRepository.mFoodList(id); 
		
		
		return foodDiaries;
		
	}

}

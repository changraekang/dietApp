package com.cos.dietApp.service;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID; 

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cos.dietApp.domain.diary.ExerciseDiaryRepository;
import com.cos.dietApp.domain.diary.FoodDiaryRepository;
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
	public void 운동일기(@Valid ExerciseReqDto dto) {

		exerciseDiaryRepository.save(dto.toEntity());

	}
	@Transactional
	public void 식단일기 (@Valid FoodReqDto dto) {
		
		foodDiaryRepository.save(dto.toEntity());
		
	}
}

package com.cos.dietApp.service;


import javax.validation.Valid;

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
		
		
		@Transactional
		public void 음식일기(FoodReqDto dto) {
			
			foodDiaryRepository.save(dto.toEntity());
			
		}

		public void 운동일기(@Valid ExerciseReqDto dto) {
			
			exerciseDiaryRepository.save(dto.toEntity());
			
		}
}

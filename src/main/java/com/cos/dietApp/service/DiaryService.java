package com.cos.dietApp.service;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.validation.Valid;

import org.qlrm.mapper.JpaResultMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cos.dietApp.domain.diary.ExerciseDiary;
import com.cos.dietApp.domain.diary.ExerciseDiaryRepository;
import com.cos.dietApp.domain.diary.FoodDiary;
import com.cos.dietApp.domain.diary.FoodDiaryRepository;
import com.cos.dietApp.domain.user.User;
import com.cos.dietApp.handler.ex.MyNotFoundException;
import com.cos.dietApp.web.dto.ExerciseReqDto;
import com.cos.dietApp.web.dto.FoodReqDto;
import com.cos.dietApp.web.dto.kcalDTO;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DiaryService {
	private final FoodDiaryRepository foodDiaryRepository;
	private final ExerciseDiaryRepository exerciseDiaryRepository;
	private final EntityManager em; // Repository는 EntityManager를 구현해서 만들어져 있는 구현체

	
	@Transactional(readOnly = true)
	public double 식단kcal(int id){
		
		// 쿼리 준비
		StringBuffer sb = new StringBuffer();
		sb.append("SELECT  round(AVG(kcal)) as kcal ");
		sb.append(" from foodDiary where userId = ? "); // 세미콜론 첨부하면 안됨
		
		// 1.물음표 principalId
		
		// 쿼리 완성
		Query query = em.createNativeQuery(sb.toString())
				.setParameter(1, id);
		
		
		
		// 쿼리 실행 (qlrm 라이브러리 필요 = DTO에 DB결과를 매핑하기 위해서)
		JpaResultMapper result = new JpaResultMapper();
		try {
			kcalDTO kcalDto =  result.uniqueResult(query, kcalDTO.class);
			return kcalDto.getKcal().doubleValue();
			
		} catch (Exception e) {
			return 0.0;

		}
	}
	@Transactional(readOnly = true)
	public double 운동kcal(int id){
		
		// 쿼리 준비
		StringBuffer sb = new StringBuffer();
		sb.append("SELECT  round(AVG(kcal)) as kcal ");
		sb.append(" from exercisediary where userId = ? "); // 세미콜론 첨부하면 안됨
		
		// 1.물음표 principalId
		
		// 쿼리 완성
		Query query = em.createNativeQuery(sb.toString())
				.setParameter(1, id);
		
		
		
		// 쿼리 실행 (qlrm 라이브러리 필요 = DTO에 DB결과를 매핑하기 위해서)
		JpaResultMapper result = new JpaResultMapper();
		try {
			kcalDTO kcalDto =  result.uniqueResult(query, kcalDTO.class);
			return kcalDto.getKcal().doubleValue();
			
		} catch (Exception e) {
			return 0.0;

		}
			
	}
	
	
	
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
	public ExerciseDiary 운동일기상세보기 (int id ) {
		ExerciseDiary exerciseDiaryEntity = exerciseDiaryRepository.findById(id).orElseThrow(() -> new MyNotFoundException(id + "를 못 찾았어요"));
		return exerciseDiaryEntity;
	}

	public List<FoodDiary> 식단일기보기( int id) {
		
		List<FoodDiary> foodDiaries = foodDiaryRepository.mFoodList(id); 
		
		
		return foodDiaries;
		
	}

	public FoodDiary 식단일기상세보기 (int id ) {
		FoodDiary foodDiaryEntity = foodDiaryRepository.findById(id).orElseThrow(() -> new MyNotFoundException(id + "를 못 찾았어요"));
		return foodDiaryEntity;
	}

}

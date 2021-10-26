package com.cos.dietApp.web.dto;

import javax.validation.constraints.NotBlank;

import com.cos.dietApp.domain.diary.ExerciseDiary;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExerciseReqDto {
	
	@NotBlank
	private String 	Exercise;
	private String 	kcal;
	@NotBlank
	private String 	time; // 운동시간
	private String 	file;

	@NotBlank
	private String 	date; // 운동한 날짜
	
	
	public ExerciseDiary toEntity() {
		ExerciseDiary exerciseD = new ExerciseDiary();
		exerciseD.setExercise(Exercise);
		exerciseD.setTime(time);
		exerciseD.setKcal(kcal);
		exerciseD.setDate(date);
		
		
		return exerciseD;
	}

}

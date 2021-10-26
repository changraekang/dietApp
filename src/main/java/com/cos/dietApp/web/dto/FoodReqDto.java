package com.cos.dietApp.web.dto;

import javax.validation.constraints.NotBlank;

import org.springframework.web.multipart.MultipartFile;

import com.cos.dietApp.domain.diary.FoodDiary;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FoodReqDto {
	@NotBlank
	private String 	food;
	private String 	food1;
	private String 	food2;
	private String 	food3;
	private String 	food4;
	private String 	kcal;
	@NotBlank
	private String 	mealtime; // 아침,점심,저녁
	@NotBlank
	private String 	date;
	
	public FoodDiary toEntity() {
		FoodDiary foodD = new FoodDiary();
		foodD.setFood(food);
		foodD.setFood1(food1);
		foodD.setFood2(food2);
		foodD.setFood3(food3);
		foodD.setFood4(food4);
		foodD.setMealtime(mealtime);
		foodD.setKcal(kcal);
		foodD.setDate(date);
		
		
		return foodD;
	}
	
}

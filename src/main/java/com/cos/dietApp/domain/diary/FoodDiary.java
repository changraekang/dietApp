package com.cos.dietApp.domain.diary;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@Data
@Document( collection = "FoodDiary" )
public class FoodDiary {
		@Id
		private int 	id;
		private String 	food;
		private String 	kcal;
		private String 	mealtime; // 아침,점심,저녁
		private String 	date;
	
}

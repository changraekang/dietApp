package com.cos.dietApp.domain.diary;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Entity
@AllArgsConstructor
@Data
public class FoodDiary {
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private int 	id;
		private String 	food;
		private String 	food1;
		private String 	food2;
		private String 	food3;
		private String 	food4;
		private String 	kcal;
		private String 	mealtime; // 아침,점심,저녁
		private String 	date;	//식사 날짜
	
}

package com.cos.dietApp.domain.diary;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class FoodDiary {
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private int 	id;
		@Column(nullable = false, length = 50)
		private String 	food;
		private String 	kcal;
		private String 	mealtime; // 아침,점심,저녁
		private String 	date;
	
}

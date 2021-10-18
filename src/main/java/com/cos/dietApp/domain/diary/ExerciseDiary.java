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
@Document( collection = "ExerciseDiary" )
public class ExerciseDiary {

	@Id
	private int 	id;
	private String 	Exercise;
	private String 	kcal;
	private String 	time; // 운동시간,횟수
	private String 	date;
	
	
	
}

package com.cos.dietApp.domain.diary;

import javax.persistence.Column; 
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;



import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Builder
@AllArgsConstructor
@Data
public class ExerciseDiary {

	@Id
	private int 	id;
	private String 	Exercise;
	private String 	kcal;
	private String 	time; // 운동시간,횟수
	private String 	date; // 운동한 날짜
	
	
	
}

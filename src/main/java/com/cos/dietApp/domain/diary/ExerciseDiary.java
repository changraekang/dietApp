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
public class ExerciseDiary {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int 	id;
	@Column(nullable = false, length = 50)
	private String 	Exercise;
	private String 	kcal;
	private String 	time; // 운동시간,횟수
	private String 	date;
	
	
	
}

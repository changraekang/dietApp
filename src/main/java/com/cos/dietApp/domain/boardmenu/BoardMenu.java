package com.cos.dietApp.domain.boardmenu;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity
public class BoardMenu {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id; // PK (자동 증가 번호)
	private String menu;
}

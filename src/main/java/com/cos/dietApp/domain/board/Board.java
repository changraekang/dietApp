package com.cos.dietApp.domain.board;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Board {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id; // PK (자동 증가 번호)
	@Column(nullable = false, length = 50)
	private String title;
	@Lob
	private String content;
	@Lob
	private String thumbnail;
}

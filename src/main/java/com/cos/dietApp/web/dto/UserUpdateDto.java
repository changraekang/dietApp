package com.cos.dietApp.web.dto;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserUpdateDto {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id; // PK
	@Column(nullable = false, length = 20, unique = true)
	private String username; // ID
	@Column(nullable = false, length = 1000)
	private String password;
	@Column(nullable = false, length = 20)
	private String uName; // 실명
	@Column(nullable = false, length = 20)
	private String uPhone;
	@Column(nullable = false, length = 50)
	private String uEmail;
	@Column(nullable = false, length = 20)
	private String uGender;
	@Column(nullable = false, length = 3)
	private int uWeight;
	@Column(nullable = false, length = 3)
	private int uHeight;
	@Column(nullable = true, length = 5)
	private String uMuscle;
	@Column(nullable = false, length = 5)
	private String uBMI;

}

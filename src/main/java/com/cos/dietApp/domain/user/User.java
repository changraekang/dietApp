package com.cos.dietApp.domain.user;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// Table Model
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id; // PK
	@Column(nullable = false, length = 20, unique = true)
	private String username; // ID
	@Column(nullable = false, length = 1000)
	private String password;
	@Column(nullable = false, length = 20)
	private String name; // 실명
	@Column(nullable = false, length = 20)
	private String userPhone;
	@Column(nullable = false, length = 50)
	private String userEmail;
	@Column(nullable = false, length = 20)
	private String userGender;
	@Column(nullable = false, length = 7)
	private double userWeight;
	@Column(nullable = false, length = 7)
	private double userHeight;
	@Column(nullable = false, length = 7)
	private double userBMI;
	@Column(nullable = true, length = 3)
	private double goalWeight; //목표무게
	@NotBlank
	private String goalPeriod; //목표날짜
	


}

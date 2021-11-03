package com.cos.dietApp.domain.user;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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
	@Column(nullable = false, length = 70)
	private String password;
	@Column(nullable = false, length = 20)
	private String uName; // 실명
	@Column(nullable = false, length = 20)
	private String uPhone;
	@Column(nullable = false, length = 50)
	private String uEmail;
	@Column(nullable = false, length = 20)
	private String uGender;
	@Column(nullable = false, length = 20)
	private int uWeight;
	@Column(nullable = false, length = 20)
	private int uHeight;
	@Column(nullable = true, length = 20)
	private String uMuscle;
	@Column(nullable = false, length = 20)
  private String uBMI;
	@Column(nullable = true, length = 20)
	private int gWeight; //목표무게
	@Column(nullable = true, length = 20)
	private String gPeriod; //목표날짜
	


}

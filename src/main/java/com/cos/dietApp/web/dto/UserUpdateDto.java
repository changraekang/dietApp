package com.cos.dietApp.web.dto;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

import com.cos.dietApp.domain.user.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserUpdateDto {
	
	
	private String uName; // 실명
	private String uPhone;
	private String uEmail;
	private String uGender;
	private int uWeight;
	private int uHeight;
	private String uMuscle;
	private String uBMI;
	private int gWeight; //목표무게
	private String gPeriod; //목표날짜

	public User toEntity() {
		User user = new User ();
		user.setUName(uName);
		user.setUPhone(uPhone);
		user.setUEmail(uEmail);
		user.setUGender(uGender);
		
		user.setUWeight(uWeight);
		user.setUHeight(uHeight);
		user.setUMuscle(uMuscle);
		user.setUBMI(String.format("%.2f",uBMI));
		user.setGWeight(gWeight);
		user.setGPeriod(gPeriod);
		
		
		
		return user;
	}
	

}

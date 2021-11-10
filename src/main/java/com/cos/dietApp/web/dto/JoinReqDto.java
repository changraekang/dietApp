package com.cos.dietApp.web.dto;

import javax.validation.constraints.NotBlank;

import com.cos.dietApp.domain.user.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class JoinReqDto {
	
	
	private String username;
	private String password;
	private String Name;
	private String userPhone;
	private String userEmail;
	private String userGender;
	
	private double userWeight;
	private double goalWeight;
	private double userHeight;
	@NotBlank
	private String goalPeriod;
	private double userBMI;
	
	

	public User toEntity() {
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		user.setName(Name);
		user.setUserPhone(userPhone);
		user.setUserEmail(userEmail);
		user.setUserGender(userGender);
		user.setUserWeight(userWeight);
		user.setGoalWeight(goalWeight);
		user.setUserHeight(userHeight);
		user.setGoalPeriod(goalPeriod);
		user.setUserBMI(userBMI);
		
		return user;
		
	}
}








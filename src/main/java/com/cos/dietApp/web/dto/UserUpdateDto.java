package com.cos.dietApp.web.dto;




import com.cos.dietApp.domain.user.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserUpdateDto {
	
	
	private String name; // 실명
	private String userPhone;
	private String userEmail;
	private double userWeight;
	private double userHeight;
	private double userBMI;
	private double goalWeight; //목표무게
	private String goalPeriod; //목표날짜

	public User toEntity() {
		User user = new User ();
		user.setName(name);
		user.setUserPhone(userPhone);
		user.setUserEmail(userEmail);
		
		user.setUserWeight(userWeight);
		user.setUserHeight(userHeight);
		user.setUserBMI(userBMI);
		user.setGoalPeriod(goalPeriod);
		user.setGoalWeight(goalWeight);
		
		
		return user;
	}
	

}

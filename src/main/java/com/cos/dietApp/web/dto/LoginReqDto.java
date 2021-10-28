package com.cos.dietApp.web.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// DTO = Data Transfer Object
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginReqDto {
	private String username;
	private String password;

}

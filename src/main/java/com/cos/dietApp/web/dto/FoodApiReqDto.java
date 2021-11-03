package com.cos.dietApp.web.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class FoodApiReqDto {
	private String foodstr;
	private String page;
}

package com.cos.dietApp.web.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PageReqDto {
	private int nowPage;
	private double totalCount;
}

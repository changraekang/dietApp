package com.cos.dietApp.web.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PageRespDto {
	private int nowPage;
	private int lastPage;
	private int prePage;
	private int nextPage;
	private int endPage;
}

package com.cos.dietApp.domain.news;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;


@Builder
@AllArgsConstructor
@Data
@Document( collection = "diet_news")
public class News {
	
	@Id
	private String _id;

	
	private String head;
	private String summary;
	private String thumnail;
	private String href;
	
}

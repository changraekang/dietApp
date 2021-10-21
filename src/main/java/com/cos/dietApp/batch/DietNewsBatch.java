package com.cos.dietApp.batch;

import org.springframework.stereotype.Component;

import com.cos.dietApp.domain.news.NewsRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class DietNewsBatch {
	private final NewsRepository newsRepository;
	

}

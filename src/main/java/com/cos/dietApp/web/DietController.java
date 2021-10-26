package com.cos.dietApp.web;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cos.dietApp.service.DiaryService;
import com.cos.dietApp.util.Script;
import com.cos.dietApp.web.dto.FoodReqDto;
import com.cos.dietApp.web.dto.ExerciseReqDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class DietController {
	private final HttpSession session;
	private final DiaryService diaryService;

	
	//창래
	@PostMapping("/food")
	public @ResponseBody String food( @Valid FoodReqDto dto ) {
		diaryService.식단일기(dto);
		
		return Script.href("/diet");
	}
	
	@PostMapping("/exercise")
	public @ResponseBody String workout ( @Valid ExerciseReqDto dto) {
		diaryService.운동일기(dto);
		
		return Script.href("/exercise");		
	}
	@GetMapping("/news")
	public String news () {
		
		return "news/news";
	}
	
	@GetMapping("/exercise")
	public String exercise () {
		
		return "diary/exercise";
	}
	@GetMapping("/diet")
	public String diet () {
		
		return "diary/diet";
	}
	
	//용세
	//규호
	
}

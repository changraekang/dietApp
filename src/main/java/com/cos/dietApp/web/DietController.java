package com.cos.dietApp.web;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
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
	@PostMapping("/test/food")
	public @ResponseBody String food( @Valid FoodReqDto dto ) {
		diaryService.음식일기(dto);
		
		return Script.href("http://localhost:8080/test/diet");
	}
	
	@PostMapping("/test/exercise")
	public @ResponseBody String workout ( @Valid ExerciseReqDto dto) {
		diaryService.운동일기(dto);
		
		return Script.href("http://localhost:8080/test/exercise");		
	}
	
	
	//용세
	//규호
	
}

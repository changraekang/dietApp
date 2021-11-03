package com.cos.dietApp.web;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cos.dietApp.domain.user.User;
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
		User principal = (User) session.getAttribute("principal");

		diaryService.식단일기(dto, principal);
		
		return Script.href("/diet");
	}
	
	@PostMapping("/exercise")
	public @ResponseBody String workout ( @Valid ExerciseReqDto dto) {
		User principal = (User) session.getAttribute("principal");
		diaryService.운동일기(dto, principal);
		
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
	
	@GetMapping("/exercise/{id}/list")
	public String exerciseList (  Model model , @PathVariable int id ) {
		
		model.addAttribute("exercisesEntity", diaryService.운동일기보기(id));
		return "diary/exerciseList";
	}
	@GetMapping("/diet/{id}/list")
	public String dietList ( Model model , @PathVariable int id ) {
		
		model.addAttribute("foodsEntity", diaryService.식단일기보기(id));
		return "diary/dietList";
	}
	@GetMapping("/exercise/diary/{id}")
	public String exerciseDiary (  Model model , @PathVariable int id ) {
		
		model.addAttribute("exercisesEntity", diaryService.운동일기상세보기(id));
		return "diary/exerciseList";
	}
	@GetMapping("diet/1/diary/{id}")
	public String dietDiary ( Model model , @PathVariable int id ) {
		
		model.addAttribute("foodsEntity", diaryService.식단일기상세보기(id));
		return "diary/dietDetail";
	}
	
	//용세
	//규호
	
}

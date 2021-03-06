package com.cos.dietApp.web;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cos.dietApp.domain.user.User;
import com.cos.dietApp.handler.ex.MyNotFoundException;
import com.cos.dietApp.service.DiaryService;
import com.cos.dietApp.util.Script;
import com.cos.dietApp.web.dto.CMRespDto;
import com.cos.dietApp.web.dto.DietDiaryReqDto;
import com.cos.dietApp.web.dto.ExerciseReqDto;
import com.cos.dietApp.web.dto.FoodReqDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class DietController {
	private final HttpSession session;
	private final DiaryService diaryService;

	
	//창래
	@PostMapping("/food")
	public @ResponseBody CMRespDto food(@Valid @RequestBody FoodReqDto dto, BindingResult bindingResult) {
		User principal = (User) session.getAttribute("principal");
		System.out.println(dto);
		diaryService.식단일기(dto, principal);
		
		return new CMRespDto(1, "성공", null);
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
		User principal = (User) session.getAttribute("principal");
		
		if (principal == null ) {
			throw new MyNotFoundException("인증이 되지 않습니다.");
		}
		model.addAttribute("exercisesEntity", diaryService.운동일기보기(id));
		return "diary/exerciseList";
	}
	@GetMapping("/diet/{id}/list")
	public String dietList ( Model model , @PathVariable int id ) {
		User principal = (User) session.getAttribute("principal");
		
		if (principal == null ) {
			throw new MyNotFoundException("인증이 되지 않습니다.");
		}
		model.addAttribute("foodsEntity", diaryService.식단일기보기(id));
		return "diary/dietList";
	}
	@GetMapping("/exercise/{id}")
	public String exerciseDiary (  Model model , @PathVariable int id ) {
		User principal = (User) session.getAttribute("principal");
		
		if (principal == null ) {
			throw new MyNotFoundException("인증이 되지 않습니다.");
		}
		model.addAttribute("exercisesEntity", diaryService.운동일기상세보기(id));
		return "diary/exerciseDetail";
	}
	@GetMapping("/diet/{id}")
	public String dietDiary ( Model model , @PathVariable int id ) {
		User principal = (User) session.getAttribute("principal");
		
		if (principal == null ) {
			throw new MyNotFoundException("인증이 되지 않습니다.");
		}
		
		model.addAttribute("foodsEntity", diaryService.식단일기상세보기(id));
		return "diary/dietDetail";
	}
	
	//용세
	@GetMapping("/diet/foodAdd")
	public String popuptest(){
		
		return "popup/foodAdd";
	}
	
	@PostMapping("/diet/diary")
	public @ResponseBody CMRespDto<?> getDietList(DietDiaryReqDto userId){
		
		System.out.println("전달");
		return new CMRespDto<>(1, "성공", diaryService.식단가져오기((User)session.getAttribute("principal")));
	}
	
}

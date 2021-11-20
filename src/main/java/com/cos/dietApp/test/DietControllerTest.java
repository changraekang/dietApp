package com.cos.dietApp.test;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cos.dietApp.domain.user.User;
import com.cos.dietApp.domain.user.UserRepository;
import com.cos.dietApp.service.DiaryService;
import com.cos.dietApp.web.dto.CMRespDto;
import com.cos.dietApp.web.dto.DietDiaryReqDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class DietControllerTest {
	private final DiaryService diaryService;
	private final HttpSession session;
	private final UserRepository userRepository;
	
	@GetMapping("/test/popup")
	public String popuptest(){
		
		return "test/popup";
	}
	
	@GetMapping("/test/diet/diary")
	public @ResponseBody CMRespDto<?> getDietList(){
		User user = userRepository.findById(1).get();
		System.out.println("테스트 전달");
		return new CMRespDto<>(1, "성공", diaryService.식단가져오기(user));
	}
}

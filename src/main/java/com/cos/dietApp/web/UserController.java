package com.cos.dietApp.web;

import java.util.HashMap; 
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cos.dietApp.domain.user.User;
import com.cos.dietApp.handler.ex.MyAPINotFoundException;
import com.cos.dietApp.service.DiaryService;
import com.cos.dietApp.service.UserService;
import com.cos.dietApp.util.Script;
import com.cos.dietApp.web.dto.CMRespDto;
import com.cos.dietApp.web.dto.JoinReqDto;
import com.cos.dietApp.web.dto.LoginReqDto;
import com.cos.dietApp.web.dto.UserUpdateDto;

import lombok.RequiredArgsConstructor;
import lombok.val;

@RequiredArgsConstructor
@Controller
public class UserController {

	
	// DI
	private final UserService	userService;
	private final HttpSession session;
	private final DiaryService diaryService;

	// Main
	@GetMapping("/")
	public String main () {
		
		return "index";
	}
	
	//  userBody
	@GetMapping("/myBody/{id}")
	public String myBody (  Model model, @PathVariable int id) {
		
		
		model.addAttribute("exercisesEntity", diaryService.운동kcal(id));
		model.addAttribute("foodsEntity", diaryService.식단kcal(id));
		// 기본은 userRepository.findById(id) -> DB에서 가져와야 함
		// 우회적으로 session value 를 가져올 수 있다
		// Validation 체크 불필요 자신의 session 만 가져오기 때문
		return "user/userBody";
	}
	

	
	

	//회원가입 부분
	
	
	//회원가입	
	@PostMapping("/join")
	public @ResponseBody String join(@Valid JoinReqDto joinDto, BindingResult bindingResult) { // username= &password= &email=으로 데이터가 들어온다
		
		// 1. 유효성 검사 실패 - 자바스크립트 응답(경고창 띄우고 뒤로가기)
		if(bindingResult.hasErrors()) {
			Map<String, String> errorMap = new HashMap<>();
			for(FieldError error : bindingResult.getFieldErrors()) {
				errorMap.put(error.getField(), error.getDefaultMessage());
				System.out.println("필드 : " + error.getField());
				System.out.println("메세지 : " + error.getDefaultMessage());
			}
			return Script.back(errorMap.toString());
		}
		userService.회원가입(joinDto);
		
		return Script.href("/"); //리다이렉션(http상태코드: 300)
	}
	
	@GetMapping("/joinForm")
	public String join() {
		return "user/joinForm"; // ViewResolver
	}
	
	// 로그인 부분
	
	
	// 로그인
	@PostMapping("/login") 
	public @ResponseBody String login(@Valid LoginReqDto loginDto, BindingResult bindingResult) {
		
		System.out.println("에러사이즈:"+bindingResult.getFieldErrors().size());
		
		// 1. 유효성 검사 실패 - 자바스크립트 응답(경고창 띄우고 뒤로가기)
		if(bindingResult.hasErrors()) {
			Map<String, String> errorMap = new HashMap<>();
			for(FieldError error : bindingResult.getFieldErrors()) {
				errorMap.put(error.getField(), error.getDefaultMessage());
				System.out.println("필드 : " + error.getField());
				System.out.println("메세지 : " + error.getDefaultMessage());
			}
			return Script.back(errorMap.toString());
		}
		
		if(userService.로그인(loginDto) == null) {
			System.out.println("로그인 되지 않았습니다:");
			return Script.href("/");

		} else {
			session.setAttribute("principal", userService.로그인(loginDto));
			return Script.href("/myBody/" + userService.로그인(loginDto).getId() , "로그인 성공");
		}
	}
	@GetMapping("/loginForm")
	public String loginForm() {
		return "user/loginForm"; // ViewResolver
	}
	
	//로그아웃
	@GetMapping("/logout")
	public String logout() {
		session.invalidate();
		return "redirect:/";
	}
	
	// 회원정보페이지-----------------------------
	@GetMapping("user/{id}")
	public String userInfo(@PathVariable int id) {
		// 기본은 userRepository.findById(id)로 DB에서 가져와야함
		// 편법은 세션에서 값을 가져올 수도 있다 - 인증과 권한 필요 없음
		// 세션에 있는 값을 쓸거라서 모델에 담아 갈 필요가 없다(로그인을 했다)
		
		return "user/updateForm";
	}
	// 회원정보수정
	@PutMapping("/user/{id}")
	public @ResponseBody CMRespDto<String> userUpdate ( @PathVariable int id, @RequestBody @Valid UserUpdateDto dto, BindingResult bindingResult) {
		
		if (bindingResult.hasErrors()) {
			Map<String, String> errorMap = new HashMap<>();
			for (FieldError error : bindingResult.getFieldErrors()) {
				errorMap.put(error.getField(), error.getDefaultMessage());
				System.out.println("필드:" + error.getField());
				System.out.println("메시지:" + error.getDefaultMessage());
			}
			return new CMRespDto<>(-1, "업데이트 실패", null);
		}
		
		User principal = (User) session.getAttribute("principal");
		if (principal == null) {
			throw new MyAPINotFoundException("인증이 되지 않습니다");
		}
		
		
		
		userService.회원정보수정(principal, id, dto);
		session.setAttribute("principal", principal);	
		return new CMRespDto<>(1, "업데이트 성공", null);
	
	
	
	}
	
	
}










package com.cos.dietApp.web;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cos.dietApp.domain.user.User;
import com.cos.dietApp.domain.user.UserRepository;
import com.cos.dietApp.util.MyAlgorithm;
import com.cos.dietApp.util.SHA;
import com.cos.dietApp.util.Script;
import com.cos.dietApp.web.dto.JoinReqDto;
import com.cos.dietApp.web.dto.LoginReqDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class UserController {

	private final UserRepository userRepository;
	private final HttpSession session;
	
		//창래
		@GetMapping("/myBody")
		public String myBody () {
			
			return "user/userBody";
		}
		
		@GetMapping("/userupdate")
		public String userupdate () {
			
			return "user/updateForm";
		}
		
//		@GetMapping("/joinForm")
//		public String join () {
//			
//			return "user/joinForm";
//		}
		
		@GetMapping("/")
		public String main () {
			
			return "index";
		}
		
		//용세
		//규호
	
	
	@GetMapping("/joinForm")
	public String join() {
		return "user/joinForm"; // ViewResolver
	}
	
	@GetMapping("/loginForm")
	public String loginForm() {
		return "user/loginForm"; // ViewResolver
	}
	
	@GetMapping("/loginFormTest")
	public String loginFormTest() {
		return "user/loginFormTest"; // ViewResolver
	}
	
		
	// 3. 있으면
	// 4. Save to session
	// 5. Return MainPage
	
	
	// insert into user(username, password, uName, uPhone, uEmail) values('ssar', '1234', 'Tom', '010-1234-9876', 'ssar@naver.com')
//	@PostMapping("/join")
//	public String join(JoinReqDto dto) { // username=love&password=1234&name=john&phone=010-1234-5678&email=love@naver.com
//		
//		System.out.println(dto.getUsername());
//		System.out.println(dto.getPassword());
//		System.out.println(dto.getUName());
//		System.out.println(dto.getUPhone());
//		System.out.println(dto.getUEmail());
//		System.out.println(dto.getUGender());
//		System.out.println(dto.getUHeight());
//		System.out.println(dto.getUMuscle());
//		System.out.println(dto.getUFat());
//		System.out.println(dto.getUBMI());
//		
//		
//		User user = new User();
//		user.setUsername(dto.getUsername());
//		user.setPassword(dto.getPassword());
//		user.setUName(dto.getUName());
//		user.setUPhone(dto.getUPhone());
//		user.setUEmail(dto.getUEmail());
//		user.setUGender(dto.getUGender());
//		user.setUWeight(dto.getUWeight());
//		user.setUHeight(dto.getUHeight());
//		user.setUMuscle(dto.getUMuscle());
//		user.setUFat(dto.getUFat());
//		user.setUBMI(dto.getUBMI());
//		
//		if(dto.getUsername() == null ||
//		   dto.getPassword() == null ||
//		   dto.getUName()    == null ||
//		   dto.getUPhone()   == null ||
//		   dto.getUEmail()   == null ||
//		   dto.getUGender()  == null ||
//		   !dto.getUsername().equals("") ||
//		   !dto.getPassword().equals("") ||
//		   !dto.getUName().equals("")    ||
//		   !dto.getUPhone().equals("")   ||
//		   !dto.getUEmail().equals("")   ||
//		   !dto.getUGender().equals("")
//		) {
//			return "error/error";
//		}
//		
//		userRepository.save(dto.toEntity());
//		
//		return "redirect:/loginForm"; // Redirection (300) ViewResolver
//		
//	}
//	
	@PostMapping("/join")
	public @ResponseBody String join(@Valid JoinReqDto dto, BindingResult bindingResult) { // username=love&password=1234&email=love@nate.com으로 데이터가 들어온다
		
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
		
		String encPassword = SHA.encrypt(dto.getPassword(), MyAlgorithm.SHA256);
       
        dto.setPassword(encPassword);		

		// 2. 정상 - 로그인 페이지
		// User 객체에 데이터를 넣고 User 객체로 받기
		userRepository.save(dto.toEntity());
		
		return Script.href("/"); //리다이렉션(http상태코드: 300)
	}
	
	
	@PostMapping("/login") 
	public String login(LoginReqDto loginDto) {
		// 1. Get username, password 
		System.out.println(loginDto.getUsername());
		System.out.println(loginDto.getPassword());
		
		// 2. DB -> Select
		String encPassword = SHA.encrypt(loginDto.getPassword(), MyAlgorithm.SHA256);
		User principal = userRepository.mLogin(loginDto.getUsername(), encPassword);

		if(principal == null) {
			System.out.println("로그인 되지 않았습니다:"+principal.getUsername());
			return "redirect:/loginForm";
		} else {
			System.out.println("로그인 되었습니다:"+principal.getUsername());
			session.setAttribute("principal", principal);
		    return "redirect:/myBody";
		}
	}
	
	@GetMapping("/logout")
	public String logout() {
		session.invalidate();
		return "redirect:/";
	}
	
}
	












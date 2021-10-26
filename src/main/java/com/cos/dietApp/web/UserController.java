package com.cos.dietApp.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {
	
	
	//창래
	@GetMapping("/myBody")
	public String myBody () {
		
		return "user/userBody";
	}
	
	@GetMapping("/userupdate")
	public String userupdate () {
		
		return "user/updateForm";
	}
	
	@GetMapping("/joinForm")
	public String join () {
		
		return "user/joinForm";
	}
	
	@GetMapping("/")
	public String main () {
		
		return "index";
	}
	//용세
	//규호
}

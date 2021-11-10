package com.cos.dietApp.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DietControllerTest {
	
	@GetMapping("/test/popup")
	public String popuptest(){
		
		return "test/popup";
	}
}

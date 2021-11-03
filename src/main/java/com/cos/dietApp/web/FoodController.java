package com.cos.dietApp.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FoodController {

	@GetMapping("/calorieDic")
	public String calorieDic () {
		
		return "wagle/calorieDic";
	}
}

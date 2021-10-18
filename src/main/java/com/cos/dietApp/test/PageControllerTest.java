package com.cos.dietApp.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageControllerTest {


	@GetMapping("/test/news")
	public String news () {
		
		return "news/news";
	}
	@GetMapping("/test/exercise")
	public String exercise () {
		
		return "diary/exercise";
	}
	@GetMapping("/test/diet")
	public String diet () {
		
		return "diary/diet";
	}
	@GetMapping("/test/dietPhoto")
	public String dietPhoto () {
		
		return "dietStimulate/dietPhoto";
	}
	@GetMapping("/test/dietYoutube")
	public String dietYoutube () {
		
		return "dietStimulate/dietYoutube";
	}
	@GetMapping("/test/wagleFree")
	public String wagleFree () {
		
		return "wagle/Free";
	}
	@GetMapping("/test/wagleQnA")
	public String wagleQnA () {
		
		return "wagle/QnA";
	}
	@GetMapping("/test/wagleShowoff")
	public String wagleShowoff () {
		
		return "wagle/showoff";
	}
	@GetMapping("/test/calorieDic")
	public String calorieDic () {
		
		return "wagle/calorieDic";
	}
	@GetMapping("/test/recipe")
	public String recipe () {
		
		return "wagle/recipe";
	}
	@GetMapping("/test/myBody")
	public String myBody () {
		
		return "user/userBody";
	}
	
	@GetMapping("/test/userupdate")
	public String userupdate () {
		
		return "user/updateForm";
	}
	
	@GetMapping("/test/joinForm")
	public String join () {
		
		return "user/joinForm";
	}
	
	@GetMapping("/test/")
	public String main () {
		
		return "index";
	}
}



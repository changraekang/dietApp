package com.cos.dietApp.handler;


import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cos.dietApp.handler.ex.MyAPINotFoundException;
import com.cos.dietApp.handler.ex.MyNotFoundException;
import com.cos.dietApp.util.Script;
import com.cos.dietApp.web.dto.CMRespDto;
// @ControllerAdvice 는 1. ExceptionHandling 2. @Controller의 기능까지 수행
@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(value = MyNotFoundException.class)
	public @ResponseBody String error1(MyNotFoundException e) {
		System.out.println("오류 : " + e.getMessage());
		return Script.href("/", e.getMessage());
	}
	   
	@ExceptionHandler(value = MyAPINotFoundException.class)
	public @ResponseBody CMRespDto error2(MyAPINotFoundException e) {
		System.out.println("오류 : " + e.getMessage());
		return new CMRespDto(-1,e.getMessage(), null);
	}
	
}

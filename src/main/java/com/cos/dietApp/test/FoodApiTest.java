package com.cos.dietApp.test;

import org.json.simple.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cos.dietApp.util.CalorieAPI;
import com.cos.dietApp.web.dto.CMRespDto;
import com.cos.dietApp.web.dto.FoodApiReqDto;
import com.cos.dietApp.web.dto.PageReqDto;
import com.cos.dietApp.web.dto.PageRespDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class FoodApiTest {

	private final CalorieAPI calorieAPI;
	
	@GetMapping("/test/api/{page}")
	public @ResponseBody CMRespDto<JSONObject> apiTest(@PathVariable String page) {
		FoodApiReqDto dto = new FoodApiReqDto("바나나",page);
		return new CMRespDto<>(1, "성공", calorieAPI.calorie(dto));
	}
	
	@GetMapping("/test/cal")
	public String calorieDic () {
		
		return "test/cal";
	}
	
	@PostMapping("/pagecal")
	public @ResponseBody PageRespDto pagecal(@RequestBody PageReqDto dto) {
		int pageten = (int) (Math.ceil(dto.getNowPage() / 10.0) * 10);
		int nowPage = dto.getNowPage();
		int lastPage = (int) Math.ceil(dto.getTotalCount() / 10.0);
		int prePage = pageten - 10;
		int nextPage = pageten + 1;
		PageRespDto pageRespDto = new PageRespDto (nowPage, lastPage, prePage, nextPage);

		return pageRespDto;
	}

}

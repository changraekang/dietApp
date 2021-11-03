package com.cos.dietApp.test;

import org.json.simple.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cos.dietApp.web.dto.CMRespDto;
import com.cos.dietApp.web.dto.FoodApiReqDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class CalorieSearch {
	
	private final CalorieAPITest calorieAPITest;
	/*
			항목명		항목 설명			크기	
			resultCode	결과코드			4
			resultMsg	결과메시지			50
			numOfRows	한 페이지 결과수	3
			pageNo		페이지 번호			5
			totalCount	전체 결과 수		7
			DESC_KOR	식품이름			3000
			SERVING_WT	1회제공량 (g)		3000
			NUTR_CONT1	열량 (kcal)			3000
			NUTR_CONT2	탄수화물 (g)		3000
			NUTR_CONT3	단백질 (g)			3000
			NUTR_CONT4	지방 (g)			3000
			NUTR_CONT5	당류 (g)			3000
			NUTR_CONT6	나트륨 (mg)			3000
			NUTR_CONT7	콜레스테롤 (mg)		3000
			NUTR_CONT8	포화지방산 (g)		3000
			NUTR_CONT9	트랜스지방산 (g)	3000
	 */
	
	@GetMapping("/test/cal")
	public String apiDataTest(Model model) {
//		FoodApiReqDto dto = new FoodApiReqDto("바나나","1");
//		CMRespDto<JSONObject> calorie = new CMRespDto<>(1, "성공", calorieAPITest.calorie(dto));
//		model.addAttribute("calorie", calorie);
		
		return "test/apitest";
	}
	@GetMapping("/test/api")
	public @ResponseBody CMRespDto<JSONObject> apiTest() {
		FoodApiReqDto dto = new FoodApiReqDto("바나나","1");
		return new CMRespDto<>(1, "성공", calorieAPITest.calorie(dto));
	}
	
	@PostMapping("/test/food/getapi")
	public @ResponseBody CMRespDto<JSONObject> getApiTest(Model model, @RequestBody FoodApiReqDto dto) {
		System.out.println("경로 호출됨");
		
		return new CMRespDto<>(1, "성공", calorieAPITest.calorie(dto));
	}
}

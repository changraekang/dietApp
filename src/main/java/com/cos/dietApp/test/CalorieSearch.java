package com.cos.dietApp.test;

import org.json.simple.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cos.dietApp.web.dto.CMRespDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class CalorieSearch {
	
	private final CalorieAPITest calorieAPITest;
	
	@GetMapping("/test/cal")
	public String ApiDataTest(Model model) {
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
		CMRespDto<JSONObject> calorie = new CMRespDto<>(1, "성공", calorieAPITest.calorie("바나나", "1"));
		model.addAttribute("calorie", calorie);
		
		return "test/apitest";
	}
	@GetMapping("/test/api")
	public @ResponseBody CMRespDto<JSONObject> ApiTest() {
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
		
		return new CMRespDto<>(1, "성공", calorieAPITest.calorie("바나나", "1"));
	}
}

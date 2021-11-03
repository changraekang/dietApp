<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<%@ include file="../layout/header.jsp" %>
<h2>칼로리사전</h2>

<div class="container">
		<input type="text" id="foodstr" name="foodstr" placeholder="Enter username">
		<input type="button" onclick="foodsearch()" value="검색">

	<table id="foodtable">
		<c:forEach var="food" items="${calorie.body.body.items}">
		<tr>
			<td>상품명 : ${food.DESC_KOR}</td>
			<td>데이터 갱신 연도 : ${food.BGN_YEAR}</td>
			<td>제조사 명 : ${food.ANIMAL_PLANT}</td>
			<td>1회제공량 (g) : ${food.SERVING_WT}</td>
			<td>열량 (kcal) : ${food.NUTR_CONT1}</td>
			<td>탄수화물 (g) : ${food.NUTR_CONT2}</td>
			<td>단백질 (g) : ${food.NUTR_CONT3}</td>
			<td>지방 (g) : ${food.NUTR_CONT4}</td>
			<td>당류 (g) : ${food.NUTR_CONT5}</td>
			<td>나트륨 (mg) : ${food.NUTR_CONT6}</td>
			<td>콜레스테롤 (mg) : ${food.NUTR_CONT7}</td>
			<td>포화지방산 (g) : ${food.NUTR_CONT8}</td>
			<td>트랜스지방산 (g) : ${food.NUTR_CONT9}</td>
		</tr>
		</c:forEach>
	</table>
	<div id="testtable">
	</div>
</div>

	<script>
		async function foodsearch() {
		//	event.preventDefault(event);
			alert("클릭");
			let foodApiReqDto = {
				foodstr : document.querySelector('#foodstr').value,
				page : "1"
			};
			alert(foodApiReqDto.foodstr);
			alert(foodApiReqDto.page);
			let response = await fetch("http://localhost:8080/test/food/getapi", {
				method : "get",
				body : JSON.stringify(foodApiReqDto),
				headers : {
					"Content-Type" : "application/json; charset=utf-8"
				}
			});
			
			let parseResponse = await response.json();
			
			if (parseResponse.code == 1) {
				alert("일단 성공");
				let testTable = document.quertSelector('#testtable');
				testTable.html(parseResponse);
				alert("출력 완료");
			} else {
				alert("API 실패");
			}
		}
	</script>
<%@ include file="../layout/footer.jsp" %>
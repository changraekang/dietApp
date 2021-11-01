<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<%@ include file="../layout/header.jsp" %>
<h2>칼로리사전</h2>

<table>
	<input type="text" name="calorieapi">
	<input type="button" onsubmit="apisearch()" value="검색">

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
<%@ include file="../layout/footer.jsp" %>
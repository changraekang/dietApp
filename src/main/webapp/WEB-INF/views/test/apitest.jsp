<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<%@ include file="../layout/header.jsp" %>
<h2>칼로리사전</h2>
<style>
	#foodtable tr td{
		border: black 1px solid;
	}
	#foodtable tr{
		border-collapse: collapse;
	}
</style>
<div class="container">
		<input type="text" id="foodstr" name="foodstr" placeholder="Enter username">
		<input type="button" onclick="foodsearch()" value="검색">

	<div>
 	 	<table id="foodtable">
		</table>
	</div>
</div>

	<script>
		async function foodsearch() {
		//	event.preventDefault(event);
			let foodApiReqDto = {
				foodstr : document.querySelector('#foodstr').value,
				page : "1"
			};
			let response = await fetch("http://localhost:8080/test/food/getapi", {
				method : "post",
				body : JSON.stringify(foodApiReqDto),
				headers : {
					"Content-Type" : "application/json; charset=utf-8"
				}
			});
			
			let parseResponse = await response.json();
			
			if (parseResponse.code == 1) {
				let i = 0;
				let table = document.querySelector('#foodtable');
				table.innerHTML = '';
				while(parseResponse.body.body.items[i] != null){
	 				let html = '<tr>';
					html += '<td>상품명 : ' + parseResponse.body.body.items[i].DESC_KOR + '</td>';
					html += '<td>데이터 갱신 연도 : ' + parseResponse.body.body.items[i].BGN_YEAR + '</td>';
					html += '<td>제조사 명 : ' + parseResponse.body.body.items[i].ANIMAL_PLANT + '</td>';
					html += '<td>1회제공량 (g) : ' + parseResponse.body.body.items[i].SERVING_WT + '</td>';
					html += '<td>열량 (kcal) : ' + parseResponse.body.body.items[i].NUTR_CONT1 + '</td>';
					html += '<td>탄수화물 (g) : ' + parseResponse.body.body.items[i].NUTR_CONT2 + '</td>';
					html += '<td>단백질 (g) : ' + parseResponse.body.body.items[i].NUTR_CONT3 + '</td>';
					html += '<td>지방 (g) : ' + parseResponse.body.body.items[i].NUTR_CONT4 + '</td>';
					html += '<td>당류 (g) : ' + parseResponse.body.body.items[i].NUTR_CONT5 + '</td>';
					html += '<td>나트륨 (mg) : ' + parseResponse.body.body.items[i].NUTR_CONT6 + '</td>';
					html += '<td>콜레스테롤 (mg) : ' + parseResponse.body.body.items[i].NUTR_CONT7 + '</td>';
					html += '<td>포화지방산 (g) : ' + parseResponse.body.body.items[i].NUTR_CONT8 + '</td>';
					html += '<td>트랜스지방산 (g) : ' + parseResponse.body.body.items[i].NUTR_CONT9 + '</td>';
					html += '</tr>';
					document.querySelector('#foodtable').innerHTML += html;
					i++;
				}
				
			} else {
				alert("검색에 실패하였습니다.");
			}
		}
	</script>
<%@ include file="../layout/footer.jsp" %>
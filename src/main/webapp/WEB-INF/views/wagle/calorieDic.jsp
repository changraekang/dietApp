<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<%@ include file="../layout/header.jsp" %>
<h2>칼로리사전</h2>
<style>
	#foodtable tr td{
		border: black 1px solid;
	}
	#foodtable tr th{
		border: black 1px solid;
		text-decoration: blink;
	}
	#foodtable tr{
		border-collapse: collapse;
	}
</style>
<div class="container">
		<input type="text" id="foodstr" name="foodstr" placeholder="Enter food">
		<input type="button" onclick="foodsearch()" value="검색">

	<div>
 	 	<table id="foodtable">
		</table>
	</div>
</div>

	<script>
		async function foodsearch() {
			let foodApiReqDto = {
				foodstr : document.querySelector('#foodstr').value,
				page : "1"
			};
			let response = await fetch("http://localhost:8080/calorieDic/getapi", {
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
				let html = '<tr>';
				html += '<th>상품명</th>';
				html += '<th>제조사명</th>';
				html += '<th>데이터 갱신 연도</th>';
				html += '<th>1회 제공량(g)</th>';
				html += '<th>열량 (kcal)</th>';
				html += '<th>탄수화물 (g)</th>';
				html += '<th>단백질 (g)</th>';
				html += '<th>지방 (g)</th>';
				html += '<th>당류 (g)</th>';
				html += '<th>나트륨 (mg)</th>';
				html += '</tr>';
				table.innerHTML = html;
				while(parseResponse.body.body.items[i] != null){
	 				let html = '<tr>';
					html += '<td>' + parseResponse.body.body.items[i].DESC_KOR + '</td>';
					html += '<td>' + parseResponse.body.body.items[i].ANIMAL_PLANT + '</td>';
			        html += '<td>' + parseResponse.body.body.items[i].BGN_YEAR + '</td>';
					html += '<td>' + parseResponse.body.body.items[i].SERVING_WT + '</td>';
					html += '<td>' + parseResponse.body.body.items[i].NUTR_CONT1 + '</td>';
					html += '<td>' + parseResponse.body.body.items[i].NUTR_CONT2 + '</td>';
					html += '<td>' + parseResponse.body.body.items[i].NUTR_CONT3 + '</td>';
					html += '<td>' + parseResponse.body.body.items[i].NUTR_CONT4 + '</td>';
					html += '<td>' + parseResponse.body.body.items[i].NUTR_CONT5 + '</td>';
					html += '<td>' + parseResponse.body.body.items[i].NUTR_CONT6 + '</td>';
					html += '</tr>';
					table.innerHTML += html;
					i++;
				}
				
			} else {
				alert("검색에 실패하였습니다.");
			}
		}
	</script>

<%@ include file="../layout/footer.jsp" %>
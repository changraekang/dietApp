<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<%@ include file="../layout/header.jsp"%>
<h2>칼로리사전</h2>
<style>
#foodtable tr td {
	border: black 1px solid;
}

#foodtable tr th {
	border: black 1px solid;
	text-decoration: blink;
}

#foodtable tr {
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
	<ul class="pagination">
		<li class="page-item"><a class="page-link" href="#">Previous</a></li>
		<li class="page-item"><a class="page-link" href="#">1</a></li>
		<li class="page-item"><a class="page-link" href="#">2</a></li>
		<li class="page-item"><a class="page-link" href="#">3</a></li>
		<li class="page-item"><a class="page-link" href="#">Next</a></li>
	</ul>
</div>

<script>
	async function foodsearch() {
		let foodApiReqDto = {
			foodstr : document.querySelector('#foodstr').value,
			page : "1"
		};
		let response = await
		fetch("http://localhost:8080/calorieDic/getapi", {
			method : "post",
			body : JSON.stringify(foodApiReqDto),
			headers : {
				"Content-Type" : "application/json; charset=utf-8"
			}
		});

		let parseResponse = await
		response.json();

		if (parseResponse.code == 1) {
			let i = 0;
			let table = document.querySelector('#foodtable');
			let data = parseResponse.body.body;
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
			while (data.items[i] != null) {
				let html = '<tr>';
				html += '<td>' + data.items[i].DESC_KOR + '</td>';
				html += '<td>' + data.items[i].ANIMAL_PLANT + '</td>';
				html += '<td>' + data.items[i].BGN_YEAR + '</td>';
				html += '<td>' + data.items[i].SERVING_WT + '</td>';
				html += '<td>' + data.items[i].NUTR_CONT1 + '</td>';
				html += '<td>' + data.items[i].NUTR_CONT2 + '</td>';
				html += '<td>' + data.items[i].NUTR_CONT3 + '</td>';
				html += '<td>' + data.items[i].NUTR_CONT4 + '</td>';
				html += '<td>' + data.items[i].NUTR_CONT5 + '</td>';
				html += '<td>' + data.items[i].NUTR_CONT6 + '</td>';
				html += '</tr>';
				table.innerHTML += html;
				i++;
			}
			lastpagenum = Math.ceil(data.totalCount/5);
			
			pagecal(15,lastpagenum)
			
		} else {
			alert("검색에 실패하였습니다.");
		}
	}
	
	function pagecal(nowpage, lastpage){
		prepage = Math.ceil(nowpage/10)*10 - 10;
		nextpage = Math.ceil(nowpage/10)*10 + 1;
		alert(prepage + ' : ' + nextpage);
	}
</script>

<%@ include file="../layout/footer.jsp"%>
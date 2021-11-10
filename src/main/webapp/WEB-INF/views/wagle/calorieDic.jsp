<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<%@ include file="../layout/header.jsp"%>
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
	<h2>칼로리사전</h2>
	<input type="text" id="foodstr" placeholder="Enter food">
	<input type="button" onclick="foodsave()" value="검색">
	<input type="hidden" id="foodstrsave">

	<div>
		<table id="foodtable">
		</table>
	</div>
	<div id="paging">

	</div>
</div>

<script>
	function foodsave() {
		document.querySelector('#foodstrsave').value = document.querySelector('#foodstr').value
		foodsearch(1);
	}
	async function foodsearch(pagenum) {
		let foodApiReqDto = {
			foodstr : document.querySelector('#foodstrsave').value,
			page : pagenum
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
			let totalCount = data.totalCount;
			pagecal(pagenum, totalCount)
			
		} else {
			alert("검색에 실패하였습니다.");
		}
	}
	
	async function pagecal(nowpagenum, totalCount){
		let pageReqDto = {
			nowPage : nowpagenum,
			totalCount : totalCount
		};
		let pageResponse = await fetch("http://localhost:8080/calorieDic/pagecal", {
			method : "post",
			body : JSON.stringify(pageReqDto),
			headers : {
				"Content-Type" : "application/json; charset=utf-8"
			}
		});

		let page = await pageResponse.json();
		let html = '<ul class="pagination">';
		if(page.prePage != 0){
			html += '<li class="page-item"><a class="page-link" href="javascript:void(0);" onclick="gopage(1)">처음</a></li>';
			html += '<li class="page-item"><a class="page-link" href="javascript:void(0);" onclick="gopage(' + page.prePage + ')">이전</a></li>';
		}
		for(let i = page.prePage+1 ; i <= page.endPage ; i++){
			if(i == page.nowPage){
				html += '<li class="page-item active"><a class="page-link">' + i +'</a></li>';				
			} else {
				html += '<li class="page-item"><a class="page-link" href="javascript:void(0);" onclick="gopage(' + i + ')">' + i +'</a></li>';
			}
		}
		if(page.nextPage <= page.lastPage) {
			html += '<li class="page-item"><a class="page-link" href="javascript:void(0);" onclick="gopage(' + page.nextPage +')">다음</a></li>';
			html += '<li class="page-item"><a class="page-link" href="javascript:void(0);" onclick="gopage(' + page.lastPage + ')">마지막</a></li>';
		}
		html += '</ul>';
		document.querySelector('#paging').innerHTML = html;
	}
	
	function gopage(pagenum){
		foodsearch(pagenum);
	}
</script>

<%@ include file="../layout/footer.jsp"%>
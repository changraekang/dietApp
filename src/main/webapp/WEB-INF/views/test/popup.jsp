<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet">
<script	src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js"></script>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
	integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
	crossorigin="anonymous"></script>

<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
	integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
	crossorigin="anonymous"></script>
<link rel="stylesheet"  href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.js"></script>
<link rel="stylesheet" href="css/main.min.css">

<title>다이어트 다이어리</title>
<style>
body {
  display: flex;
  flex-direction: column;
}
ul {
	list-style-type: none;
	margin: 0;
	padding: 0;
	overflow: hidden;
	border: 1px solid #e7e7e7;
	background-color: #f3f3f3;
}

#chooseFile {
	visibility: hidden;
}



#diarysave{
	visibility: hidden;
}

#diaryphoto {
	visibility: hidden;
	width: 100%;
	height: 50%;
	object-fit: cover;
}

li {
	float: left;
}
a {
	text-decoration: none;
}
li a {
	display: block;
	color: #666;
	text-align: center;
	padding: 14px 16px;
	text-decoration: none;
}

li a:hover:not(.active) {
	color: white;
	background-color: #04AA6D;
}

li a.active {
	color: white;
	background-color: #04AA6D;
}

dropdown2 {
	position: relative;
	display: inline-block;
}

.dropdown2-content {
	display: none;
	position: absolute;
	background-color: #f9f9f9;
	min-width: 160px;
	box-shadow: 0px 8px 16px 0px rgba(0, 0, 0, 0.2);
	padding: 12px 16px;
	z-index: 1;
}

.dropdown2:hover .dropdown2-content {
	display: block;
}

.flex_container {
	display: flex;
}

.flex_item {
	margin: auto;
}

.jumbotron {
	background-color: #f9f9f9;
}
</style>
</head>
<body>

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
			let html = '<tr id="food' + i + '" onClick="calSelect(' + i + ')">';
			html += '<td id="foodname' + i + '">' + data.items[i].DESC_KOR + '</td>';
			html += '<td>' + data.items[i].ANIMAL_PLANT + '</td>';
			html += '<td>' + data.items[i].BGN_YEAR + '</td>';
			html += '<td id="gram' + i + '">' + data.items[i].SERVING_WT + '</td>';
			html += '<td id="calorie' + i + '">' + data.items[i].NUTR_CONT1 + '</td>';
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
function calSelect(id){
	let food = {
			name : document.querySelector('#foodname' + id).textContent,
			gram : document.querySelector('#gram' + id).textContent,
			kcal : document.querySelector('#calorie' + id).textContent
	}
	opener.calorieCallBack(food);
	window.close();
}
</script>
</body>
</html>
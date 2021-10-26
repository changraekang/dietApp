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
<title>Insert title here</title>
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
	<ul class="nav justify-content-around bg-light">
		<li class="flex-fill"><a class="" href="/news" style= "text-decoration: none;">News</a></li>
		<li class="flex-fill"><a href="/calorieDic" style= "text-decoration: none;">칼로리 사전</a> </li>
		<li class="dropdown2 flex-fill"><a href="javascript:void(0)"
			class="dropbtn " style= "text-decoration: none;">와글와글</a>
			<div class="dropdown2-content flex-fill" style="width: 15.8%">
				<a href="/board" style= "text-decoration: none;">자유게시판</a> 
				<a href="/wagleQnA" style= "text-decoration: none;">건강 QnA</a>
				<a href="/recipe" style= "text-decoration: none;">다이어트 Recipe</a> 
				<a href="/wagleShowoff" style= "text-decoration: none;">다이어트 인증샷</a>
			</div></li>
		<li class="dropdown2 flex-fill"><a href="javascript:void(0)"
			class="dropbtn" style= "text-decoration: none;">다이어트 다이어리</a>
			<div class="dropdown2-content flex-fill" style="width: 19.5%">
			<a href="/exercise" style= "text-decoration: none;">운동 일기</a> 
			<a href="/diet" style= "text-decoration: none;">식단 일기</a>
			</div></li>
		<li class="flex-fill"><a href="/myBody" style= "text-decoration: none;">나의 Body</a></li>
		<li class="flex-fill"><a href="/userupdate" style= "text-decoration: none;">회원정보</a></li>
	</ul>
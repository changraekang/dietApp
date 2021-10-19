<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js"></script>
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"

        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"

        crossorigin="anonymous"></script>

    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"

        integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"

        crossorigin="anonymous"></script>

<title>Insert title here</title>
<style>
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
  box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
  padding: 12px 16px;
  z-index: 1;
}

.dropdown2:hover .dropdown2-content {
  display: block;}
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
  <li class="flex-fill"><a class="" href="#home">News</a></li>
  <li class="dropdown2 flex-fill"><a href="javascript:void(0)" class="dropbtn">다이어트 자극</a>
			<div class="dropdown2-content flex-fill" style= "width: 17.8%">
				<a href="/">다이어트 자극 사진</a> <a href="/dietApp/src/main/webapp/WEB-INF/views/diary/exercise.jsp">다이어트 자극 영상<img src="/image/youtube.png" style= "height: 18px;"></a> 
			</div></li>
  <li class="dropdown2 flex-fill"><a href="javascript:void(0)" class="dropbtn " >와글와글</a>
			<div class="dropdown2-content flex-fill" style= "width: 15.8%">
				<a href="#">자유게시판</a> 
				<a href="#">건강 QnA</a> 
				<a href="#">칼로리 사전</a> 
				<a href="#">다이어트 Recipe</a> 
				<a href="#">다이어트 인증샷</a>
			</div></li>
  <li class="dropdown2 flex-fill"><a href="javascript:void(0)" class="dropbtn">다이어트 다이어리</a>
			<div class="dropdown2-content flex-fill" style= "width: 19.5%" >
				<a href="#">운동 일기</a> <a href="#">식단 일기</a> 
			</div></li>
  <li  class="flex-fill" ><a href="#about">나의 Body</a></li>
  <li  class="flex-fill" ><a href="#about">회원정보</a></li>
</ul>

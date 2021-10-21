<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ include file="../layout/header.jsp" %>
	<h2>게시글 리스트</h2>
<div class="container">
	<!-- boardsEntity -> pageScope에 있음. -->
 	<c:forEach var="board" items="${boardsEntity}">
		<!-- 카드 글 시작 -->
		<div class="card">
			<div class="card-body">
				<!-- el표현식은 변수를 적으면 자동으로 get 함수를 사용해준다 -->
				<a href="/test/board/${board.id }">
				<img src="${board.thumbnail}">
				<h4 class="card-title">${board.title }</h4>
				</a>
			</div>
		</div>
		<br>
		<!-- 카드 글 끝 -->
	</c:forEach>
</div>

<%@ include file="../layout/footer.jsp" %>
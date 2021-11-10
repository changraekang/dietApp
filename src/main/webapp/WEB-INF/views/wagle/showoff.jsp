<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ include file="../layout/header.jsp" %>
<style>
.container {
    display: grid;
    grid-template-columns: 1fr 5fr;
    grid-gap: 10px;
}
.boardList {
    display: grid;
    grid-template-columns: 1fr 1fr 1fr 1fr 1fr;
    grid-gap: 10px;
}
</style>
<div class="container">
	<div class="box1">
		<br><br><br>
		<ul>
			<li><h4><a href="/board?menuId=1" style= "text-decoration: none;">자유게시판</a></h4></li>
			<li><h4><a href="/board?menuId=2" style= "text-decoration: none;">QnA게시판</a></h4></li>
			<li><h4><a href="/board?menuId=3" style= "text-decoration: none;">인증게시판</a></h4></li>
		</ul>
	</div>
	
	
	
	<div class="board">
	<h2>${boardMenu.menu} 게시판</h2>
		<div class="boardList">
			<!-- boardsEntity -> pageScope에 있음. -->
		 	<c:forEach var="board" items="${boardsEntity}">
				<!-- 카드 글 시작 -->
				<div class="card">
					<div class="card-body">
						<div class="box${board.id}">
							<!-- el표현식은 변수를 적으면 자동으로 get 함수를 사용해준다 -->
							<a href="/board/${board.id }">
							<c:if test="${!empty board.thumbnail}">
									<img src="${board.thumbnail}" width="100px" height="100px">
							</c:if>
							<h4 class="card-title">${board.title}</h4>
							</a>
						</div>
				</div>
				<br>
				<!-- 카드 글 끝 -->
		 		</div>
			</c:forEach>
		</div>
		<div align="right">
			<h2><a href="/board/saveForm?menuId=${menuId}" class="btn btn-primary">글쓰기</a></h2>
		</div>
	</div>
</div>

<%@ include file="../layout/footer.jsp" %>
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
	
	
	
	<div class="box2">
	<h2>${boardMenu.menu} 게시판</h2>
		<c:choose>
			<c:when test="${boardMenu.id == 3}">
				<!-- 썸네일이 있는 게시판 -->
				<div class="boardList">
				 	<c:forEach var="board" items="${boardsEntity.content}">
						<!-- 카드 글 시작 -->
						<div class="card">
							<div class="card-body">
								<div class="box${board.id}">
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
			</c:when>
			<c:otherwise>	
				<!-- 썸네일이 없는 게시판 -->
			 	<c:forEach var="board" items="${boardsEntity.content}">
					<!-- 카드 글 시작 -->
					<div class="card">
						<div class="card-body">
							<a href="/board/${board.id }">
								<h4 class="card-title">${board.title}<c:if test="${!empty board.thumbnail}"><img src="/image/paint"></c:if></h4>
							</a>
						</div>
					</div>
					<br>
					<!-- 카드 글 끝 -->
				</c:forEach>
			</c:otherwise>
		</c:choose>
		<div>
			<span id="paging">
				<ul class="pagination">
					<c:if test="${page.prePage != 0}">
						<li class="page-item"><a class="page-link" href="/board?menuId=${boardMenu.id}">처음</a></li>
						<li class="page-item"><a class="page-link" href="/board?menuId=${boardMenu.id}&page=${page.prePage-1}">이전</a></li>
					</c:if>
					<c:forEach var="now" begin="${page.prePage + 1}" end="${page.endPage}">
						<c:if test="${page.nowPage == now}">
							<li class="page-item active"><a class="page-link">${now}</a></li>
						</c:if>
						<c:if test="${page.nowPage != now}">
							<li class="page-item"><a class="page-link" href="/board?menuId=${boardMenu.id}&page=${now-1}">${now}</a></li>
						</c:if>
					</c:forEach>
					<c:if test="${page.nextPage <= page.lastPage}">
						<li class="page-item"><a class="page-link" href="/board?menuId=${boardMenu.id}&page=${page.nextPage-1}">다음</a></li>
						<li class="page-item"><a class="page-link" href="/board?menuId=${boardMenu.id}&page=${page.lastPage-1}">마지막</a></li>
					</c:if>
				</ul>
			</span>
		</div>
		<div align="right">
			<h2><a href="/board/saveForm?menuId=${menuId}" class="btn btn-primary">글쓰기</a></h2>
		</div>
	</div>
</div>

<%@ include file="../layout/footer.jsp" %>
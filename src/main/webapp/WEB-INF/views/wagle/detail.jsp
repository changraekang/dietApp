<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<%@ include file="../layout/header.jsp" %>
<div class="container">
	<br />
	<div>
		<span>글 번호 : ${boardEntity.id}</span> 작성자 : <span><i>유저1</i></span>
	</div>
	<br />
	<div>
		<h3>${boardEntity.title}</h3>
	</div>
	<hr />
	<div>
		<div>${boardEntity.content}</div>
	</div>
	<hr />

	<div>
		<span style="float:reft;">
		<a href="#"  style="text-decoration: none; color: #666; background-color: #AAFFAA;
			font-size: 24px;">전체글</a>
		</span>
		<span style="float:right;">
		<a href="#"  style="text-decoration: none; color: #666; background-color: #AAFFAA;
			font-size: 24px;">수정</a>
		<a href="#"  style="text-decoration: none; color: #666; background-color: #AAFFAA;
			font-size: 24px;">삭제</a>
		</span>
	</div>
	
	<div class="card">
		<div class="card-header">
			<b>댓글 리스트</b>
		</div>
		<ul id="reply-box" class="list-group">
			<li id="reply-1" class="list-group-item d-flex justify-content-between">
				<div>댓글 내용</div>
				<div class="d-flex">
					<div class="font-italic">작성자 : 유저1 &nbsp;</div>
					<button class="badge" id="reply">삭제</button>
				</div>
			</li>
		</ul>
	</div>
</div>

<%@ include file="../layout/footer.jsp" %>

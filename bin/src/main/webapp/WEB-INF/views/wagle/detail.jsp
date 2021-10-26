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


</div>

<%@ include file="../layout/footer.jsp" %>

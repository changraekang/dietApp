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
		<input type="hidden" id="menuId" value="${boardEntity.boardMenu.id}">
		<span style="float:reft;">
		<a href="/board?menuId=${boardEntity.boardMenu.id}" class="btn btn-primary">전체글</a>
		</span>
		<span style="float:right;">
		<a href="/board/${boardEntity.id}/updateForm"  class="btn btn-primary">수정</a>
		<a onclick="deleteById(${boardEntity.id})" class="btn btn-primary" style="background-color: #111111;">삭제</a>
		</span>
	</div>
	
	<script>
		async function deleteById(id){
			// 1. 비동기 함수 호출 -> 비동기를 잘처리하는 방법??????
			let response = await fetch("http://localhost:8080/board/"+id, {
				method: "delete"
			}); // 약속 - 어음 (10초)
			
			// 2.코드
			// json() 함수는 json형태의 문자열을 자바스크립트 오브젝트로 변환해준다.
			let parseResponse = await response.json();
			console.log(parseResponse);
			
			if(parseResponse.code == -1){
				alert(parseResponse.msg);
				location.href="/";
			} else {
				alert("삭제 성공");
				location.href="/board?menuId="+document.querySelector('#menuId').value;
			}	
		}		
	</script>
	
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

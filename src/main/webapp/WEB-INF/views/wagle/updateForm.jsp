<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<%@ include file="../layout/header.jsp" %>
	<h2>게시글 수정</h2>
	<div class="container">
		<form onsubmit="update(event, ${boardEntity.id})">
			<input type="hidden" name="menuId" id="menuId" value="${boardEntity.boardMenu.id}">
			<div class="form-group">
				<input type="text" id="title" name="title" class="form-control" value="${boardEntity.title}"
					placeholder="Enter title">
			</div>
			<div class="form-group">
				<textarea id="content" class="form-control" rows="5"
					name="content">${boardEntity.content}</textarea>
			</div>
			<div align="right">
				<button type="submit" class="btn btn-primary" >수정</button>&nbsp;&nbsp;
				<a onclick="cencel()" class="btn btn-primary" style="background-color: #111111;" >취소</a>
			</div>
		</form>
	</div>

	<script>
		async function update(event, id){
			event.preventDefault();

			let tn = document.querySelector('.note-editable img');
			if(tn != null){
				tn = tn.getAttribute('src');
			};
			// 주소 : PUT board/3
			let boardUpdateDto = {
				title: document.querySelector('#title').value,
				content: document.querySelector('#content').value,
				thumbnail : tn
			};
			
			// JSON.stringify(자바스크립트 오브젝트) => 리턴 json 문자열
	        // JSON.parse(제이슨 문자열) => 리턴 자바스크립트 함수
			let response = await fetch("http://localhost:8080/board/" + id,{
				method: "put",
				body: JSON.stringify(boardUpdateDto),
				headers:{
					"Content-Type":"application/json; charset=utf-8"
				}
			});
			
			let parseResponse = await response.json();
			
			if(parseResponse.code == 1){
				alert("업데이트 성공");
				location.href = "/board/" + id;
			} else {
				alert("업데이트 실패 - " + parseResponse.msg);
			}
		}
		
		function cencel(){
			history.back();
		}
		
		$('#content').summernote({
			height : 350
		});
	</script>

<%@ include file="../layout/footer.jsp" %>
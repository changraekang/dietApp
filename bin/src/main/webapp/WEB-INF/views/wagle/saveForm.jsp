<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<%@ include file="../layout/header.jsp" %>
	<h2>게시글 등록</h2>
	<div class="container">
		<form onsubmit="save()">
			<input type="hidden" name="menuId" id="menuId" value="${menuId}">
			<div class="form-group">
				<input type="text" id="title" name="title" class="form-control"
					placeholder="Enter title">
			</div>
			<div class="form-group">
				<textarea id="summernote" class="form-control" rows="5"
					name="content"></textarea>
			</div>
			<div align="right"><button type="submit" class="btn btn-primary" >글쓰기</button></div>
		</form>
	</div>

	<script>
		async function save() {
			event.preventDefault();
			let tn = document.querySelector('.note-editable img');
			if(tn != null){
				tn = tn.getAttribute('src');
			};
			let boardSaveReqDto = {
				title : document.querySelector('#title').value,
				content : document.querySelector('#summernote').value,
				thumbnail : tn,
				menuId : document.querySelector('#menuId').value
			};
			let response = await fetch("http://localhost:8080/board", {
				method : "post",
				body : JSON.stringify(boardSaveReqDto),
				headers : {
					"Content-Type" : "application/json; charset=utf-8"
				}
			});
			
			let parseResponse = await response.json();
			
			if (parseResponse.code == 1) {
				alert("게시글이 저장되었습니다.");
				location.href = "/board?menuId=" + document.querySelector('#menuId').value;
			} else {
				alert("게시글 저장이 실패하였습니다. - " + parseResponse.msg);
			}
		}

		$('#summernote').summernote({
			height : 350
		});
	</script>

<%@ include file="../layout/footer.jsp" %>
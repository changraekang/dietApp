<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<%@ include file="../layout/header.jsp" %>
	<h2>게시글 등록</h2>
	<div class="container">
		<form onsubmit="save()">
			<div class="form-group">
				<input type="text" id="title" name="title" class="form-control"
					placeholder="Enter title">
			</div>
			<div class="form-group">
				<textarea id="summernote" class="form-control" rows="5"
					name="content"></textarea>
			</div>
			<button type="submit" class="btn btn-primary">글쓰기</button>
		</form>
	</div>

	<script>
		async function save() {
			event.preventDefault();
			for(let i = 0; i < 6 ; i++){
				alert(i);
			};
			let boardSaveReqDto = {
				title : document.querySelector('#title').value,
				content : document.querySelector('#summernote').value,
				thumbnail : document.querySelector('.note-editable img').getAttribute('src')
			};
			let response = await fetch("http://localhost:8080/test/board", {
				method : "post",
				body : JSON.stringify(boardSaveReqDto),
				headers : {
					"Content-Type" : "application/json; charset=utf-8"
				}
			});
			
			let parseResponse = await response.json();
			
			if (parseResponse.code == 1) {
				alert("업데이트 성공");
				location.href = "/board";
			} else {
				alert("업데이트 실패 - " + parseResponse.msg);
			}
		}

		$('#summernote').summernote({
			height : 350
		});
	</script>

<%@ include file="../layout/footer.jsp" %>
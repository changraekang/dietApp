<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<%@ include file="../layout/header.jsp" %>
	<h2>게시글 수정</h2>
	<div class="container">
		<form onsubmit="save()">
			<input type="hidden" name="menuId" id="menuId" value="1">
			<div class="form-group">
				<input type="text" id="title" name="title" class="form-control"
					placeholder="Enter title">
			</div>
			<div class="form-group">
				<textarea id="summernote" class="form-control" rows="5"
					name="content"></textarea>
			</div>
			<div align="right">
				<button type="submit" class="btn btn-primary" >수정</button>&nbsp;&nbsp;
				<button type="submit" class="btn btn-primary" style="background-color: #111111;" >취소</button>
			</div>
		</form>
	</div>

	<script>
		$('#summernote').summernote({
			height : 350
		});
	</script>

<%@ include file="../layout/footer.jsp" %>
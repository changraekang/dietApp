<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<%@ include file="../layout/header.jsp"%>
<div class="container m_tm_20" style="height: 140%;">
	<div style="float: left; width: 33%;">
		<img id="body" alt="" src="/image/남자1.jpg" style="width: auto; height: auto;">
	</div>
	<div style="float: right; width: 44%; height: auto;">
		<table class="table">
			<thead>
				<tr>
					<th>이름</th>
					<th>현재체중</th>
					<th>목표체중</th>
					<th>목표날짜</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>${sessionScope.principal.UName}</td>
					<td>${sessionScope.principal.UWeight}kg</td>
					<td>${sessionScope.principal.GWeight}kg</td>
					<td>D- ${sessionScope.principal.GWeight}</td>
				</tr>
				<tr>
					<td colspan="4">목표체중과 날짜는 회원정보 수정에서 입력해주세요</td>
				</tr>
			</tbody>
		</table>
		<table class="table">
			<thead>
				<tr>
					<th>현재소비 Kcal</th>
					<th>목표소비 Kcal</th>
					<th>부족한소비 Kcal</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>280kcal</td>
					<td>450kcal</td>
					<td>170kcal</td>
				</tr>
			</tbody>
		</table>
		<table class="table">
			<thead>
				<tr>
					<th>현재섭취 Kcal</th>
					<th>목표섭취 Kcal</th>
					<th>초과섭취 Kcal</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>2850kcal</td>
					<td>2250kcal</td>
					<td>600kcal</td>
				</tr>
			</tbody>
		</table>
	</div>
</div>
<div class="container mt-3">
	<h2>목표체중 도달</h2>
	<div class="progress">
		<div class="progress-bar" style="width: 80%"></div>
	</div>
</div>
<input type="text" id="uGender" style="visibility: hidden"
			value="${sessionScope.principal.UGender}">
<script>
	var bmi = ${sessionScope.principal.UBMI};
	let gender =document.getElementById("uGender").value;
	//var gender = "male";
	if (gender === "male"){
		
	switch (true) {
	case (bmi < 18.6):
		document.getElementById("body").src = "/image/남자1.jpg";
		break;
	case (bmi < 23):
		document.getElementById("body").src = "/image/남자2.jpg";
		break;
	case (bmi < 25):
		document.getElementById("body").src = "/image/남자3.jpg";
		break;
	case (bmi >= 25):
		document.getElementById("body").src = "/image/남자5.jpg";
		break;

	}		
	
	} else {
	switch (true) {
	case (bmi < 18.6):
		document.getElementById("body").src = "/image/여자1.jpg";
		break;
	case (bmi < 23):
		document.getElementById("body").src = "/image/여자2.jpg";
		break;
	case (bmi < 25):
		document.getElementById("body").src = "/image/여자3.jpg";
		break;
	case (bmi >= 25):
		document.getElementById("body").src = "/image/여자5.jpg";
		break;
	}
	}
	
</script>
<%@ include file="../layout/footer.jsp"%>
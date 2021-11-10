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
					<td>${sessionScope.principal.name}</td>
					<td>${sessionScope.principal.userWeight}kg</td>
					<td>${sessionScope.principal.goalWeight}kg</td>
					<td>D-${daysCalcurate} 일</td>
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
					<td>${exercisesEntity } kcal</td>
					<td id = "exerciseKcal" ></td>
					<td id = "goalKcal"></td>
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
					<td>${foodsEntity }kcal</td>
					<td id= "needFoodKcal"></td>
					<td id= "goalFoodKcal"></td>
				</tr>
			</tbody>
		</table>
	</div>
</div>
<div class="container mt-3">
	<h2 id= "goal">목표체중 도달</h2>
	<div class="progress">
		<div id="progress" class="progress-bar" style="width: 0%"></div>
	</div>
</div>
<input type="text" id="userGender" style="visibility: hidden"
			value="${sessionScope.principal.userGender}">
<script>
let weight = ${sessionScope.principal.userWeight};
let goalWeight = ${sessionScope.principal.goalWeight};
let calWeight = weight - goalWeight;
console.log(calWeight);
let minusKcal = calWeight * 7000;
console.log(minusKcal);
let calKcal = minusKcal / ${daysCalcurate} ;
console.log(calKcal);
let foodKacl = (calKcal * 0.72).toFixed(0);
let exerciseKcal = (calKcal * 0.32).toFixed(0);
document.getElementById('exerciseKcal').innerText=exerciseKcal + "kcal"; 
document.getElementById('goalKcal').innerText=${exercisesEntity } - exerciseKcal + "kcal"; 


	





	var bmi = ${sessionScope.principal.userBMI};
	let gender =document.getElementById("userGender").value;
	if (gender === "male"){
		let needFoodKcal = 2500 - foodKacl;
		document.getElementById('needFoodKcal').innerText=needFoodKcal + "kcal"; 
		document.getElementById('goalFoodKcal').innerText=needFoodKcal -${foodsEntity }   + "kcal"; 
		console.log(needFoodKcal+"권장");
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
		let needFoodKcal = 2000 - foodKacl;
		document.getElementById('needFoodKcal').innerText=needFoodKcal + "kcal"; 
		document.getElementById('goalFoodKcal').innerText=needFoodKcal - ${foodsEntity }   + "kcal"; 

		console.log(needFoodKcal+"권장");
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
if 	(${sessionScope.principal.goalWeight} !=0 ){
let weightper = ((${sessionScope.principal.goalWeight}/${sessionScope.principal.userWeight})*100).toFixed(0);
$("#progress").css("width", weightper+"%");
document.getElementById('goal').innerText="목표체중도달 " + weightper + "%"; 
	
}
	
</script>
<%@ include file="../layout/footer.jsp"%>
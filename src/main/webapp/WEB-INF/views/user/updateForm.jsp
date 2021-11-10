<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<%@ include file="../layout/header.jsp"%>

<div class="container">
	<form onsubmit="update(event, ${sessionScope.principal.id})">
		<div class="form-group">
			<input type="text" name="username" id="username"
				value="${sessionScope.principal.username}" class="form-control"
				placeholder="username" maxlength="20" readonly="readonly">
		</div>
		<div class="form-group">
			목표몸무게: <input type="text" id="goalWeight"
				value= "${sessionScope.principal.goalWeight}" class="form-control" placeholder="">
		</div>
		<div class="form-group">
			목표날짜: <input type="date" id="goalPeriod"
				value="${sessionScope.principal.goalPeriod}" class="form-control"
				placeholder="">
		</div>
		<div class="form-group">
			이름: <input type="text"  id="name"
				value="${sessionScope.principal.name}" class="form-control"
				placeholder="your name" maxlength="20">
		</div>
		<div class="form-group">
			전화번호: <input type="text" id="phone"
				value="${sessionScope.principal.userPhone}" class="form-control"
				placeholder="Enter phone" maxlength="50">
		</div>
		<div class="form-group">
			Email: <input type="email"  id="email"
				value="${sessionScope.principal.userEmail}" class="form-control"
				placeholder="Enter email" maxlength="100">
		</div>
		
		<div class="form-group">
			몸무게: <input type="text"  id="weight" onkeyup="printName();"
				value="${sessionScope.principal.userWeight}" class="form-control"
				placeholder="Enter weight">
		</div>
		<div class="form-group">
			키 : <input type="text" id="height" onkeyup="printName();"
				value="${sessionScope.principal.userHeight}" class="form-control"
				placeholder="Enter height">
		</div>
		<div class="form-group">
			BMI지수: <input type="text" id="BMI"
				value="${sessionScope.principal.userBMI}" class="form-control"
				placeholder="your BMI" readonly="readonly">
		</div>
		

		<button type="submit" class="btn btn-primary">회원수정</button>
	</form>

</div>
<script>
		function printName()  {
		    const height = document.getElementById('height').value;
		    const weight = document.getElementById('weight').value;
		    
		    document.getElementById("bmi").value = (weight / ((height/100) * (height/100))).toFixed(2);
		    
		  }
	
    </script>
<script>
let a = new Date();
let c =  ${sessionScope.principal.goalPeriod}// 2021-11-05
console.log(a);
console.log(c);
/*
if (${sessionScope.principal.goalPeriod}.equals(null)){
document.getElementById('goalPeriod').value= new Date().toISOString().substring(0, 10);
}
*/

async function update(event, id){ 
      event.preventDefault();
      let userUpdateDto = {
    		  name: document.querySelector("#name").value,
              userPhone: document.querySelector("#phone").value,
              userEmail: document.querySelector("#email").value,
              userWeight: document.querySelector("#weight").value,
              userHeight: document.querySelector("#height").value,
              userBMI: document.querySelector("#BMI").value,
              goalPeriod: document.querySelector("#goalPeriod").value,
              goalWeight: document.querySelector("#goalWeight").value 
      };
		console.log(userUpdateDto.Name+"이름");
		console.log(userUpdateDto+"콘솔");

      let response = await fetch("http://localhost:8080/user/"+id, {
         method: "put",
         body: JSON.stringify(userUpdateDto),
         headers: {
            "Content-Type": "application/json; charset=utf-8"
         }
      });
      
      let parseResponse = await response.json();
      if(parseResponse.code == 1){
         alert("업데이트 성공");
         location.href = "/myBody/"+id;
      }else{
         alert("업데이트 실패 : "+parseResponse.msg);
      }
}


function printName()  {
    const height = document.getElementById('height').value;
    const weight = document.getElementById('weight').value;
    document.getElementById("BMI").value = (weight / ((height/100) * (height/100))).toFixed(2);
  }

</script>

<%@ include file="../layout/footer.jsp"%>
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
			목표몸무게: <input type="text" id="gweight"
				value= "${sessionScope.principal.GWeight}" class="form-control" placeholder="">
		</div>
		<div class="form-group">
			목표날짜: <input type="date" id="gperiod"
				value="get" class="form-control"
				placeholder="">
		</div>
		<div class="form-group">
			이름: <input type="text"  id="name"
				value="${sessionScope.principal.UName}" class="form-control"
				placeholder="your name" maxlength="20">
		</div>
		<div class="form-group">
			전화번호: <input type="text" id="phone"
				value="${sessionScope.principal.UPhone}" class="form-control"
				placeholder="Enter phone" maxlength="50">
		</div>
		<div class="form-group">
			Email: <input type="email"  id="email"
				value="${sessionScope.principal.UEmail}" class="form-control"
				placeholder="Enter email" maxlength="100">
		</div>
		<div class="input-group form-group" id=gender>
			성별: <input type="radio" id="male"  > <label
				for="male"> <i class="fas fa-male"> 남자</i>
			</label>   <input type="radio" id="female"> <label
				for="female"> <i class="fas fa-female">여자</i>
			</label>
		</div>
		<div class="form-group">
			몸무게: <input type="text"  id="weight"
				value="${sessionScope.principal.UWeight}" class="form-control"
				placeholder="Enter weight">
		</div>
		<div class="form-group">
			키 : <input type="text" id="height"
				value="${sessionScope.principal.UHeight}" class="form-control"
				placeholder="Enter height">
		</div>
		<div class="form-group">
			근육량: <input type="text" id="muscle"
				value="${sessionScope.principal.UMuscle}" class="form-control"
				placeholder="Enter muscle">
		</div>
		<div class="form-group">
			BMI지수: <input type="text" id="BMI"
				value="${sessionScope.principal.UBMI}" class="form-control"
				placeholder="your BMI" readonly="readonly">
		</div>
		

		<button type="submit" class="btn btn-primary">회원수정</button>
	</form>
		<input type="text" id="uGender" style="visibility: hidden"
			value="${sessionScope.principal.UGender}">
</div>

<script>
let a = new Date();
console.log(a);
document.getElementById('gperiod').value= new Date().toISOString().substring(0, 10);
let gender =document.getElementById("uGender").value;
console.log(gender);
switch (gender) {
case "male": 
	document.getElementById("male").checked = true;
	break;
case "female":
	document.getElementById("female").checked = true;
	break;
}
let bmi = document.querySelector("#BMI").value;
let muscle = document.querySelector("#muscle").value;
console.log(bmi);
console.log(muscle);
async function update(event, id){ 
      event.preventDefault();
      console.log(event);
      let userUpdateDto = {
    		  uName: 123,
    		  uPhone: 123,
    		  uEmail: 123,
    		  uGender: 123,
    		  uWeight: 123,
    		  uHeight: 123,
    		  uMuscle: 123,
    		  uBMI: 123,
    		  gPeriod: 123,
    		  gWeight: 123,
      };
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
         location.href = "/";
      }else{
         alert("업데이트 실패 : "+parseResponse.msg);
      }
}


function printName()  {
    const height = document.getElementById('height').value;
    const weight = document.getElementById('weight').value;
    document.getElementById("BMI").value = weight / ((height/100) * (height/100));
  }

</script>

<%@ include file="../layout/footer.jsp"%>
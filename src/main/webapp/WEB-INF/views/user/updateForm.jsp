<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@page import="java.text.DecimalFormat" %>

<%@ include file="../layout/header.jsp" %>

<div class="container">
   <form onsubmit="update(event, ${sessionScope.principal.id})">
     <div class="form-group">
       <input type="text" name="username" id="username" value="${sessionScope.principal.username}" class="form-control" placeholder="username"  maxlength="20" readonly="readonly">
     </div>
     <div class="form-group">
       <input type="password" name="password" id="password" value="${sessionScope.principal.password}" class="form-control" placeholder="password"  maxlength="20">
     </div>
     <div class="form-group">
       <input type="text"  name="UName" id="name" value="${sessionScope.principal.UName}" class="form-control" placeholder="your name"  maxlength="20">
     </div>
     <div class="form-group">
       <input type="text" name="UPhone" id="phone" value="${sessionScope.principal.UPhone}" class="form-control" placeholder="Enter phone"  maxlength="50">
     </div>
     <div class="form-group">
       <input type="email" name="UEmail" id="email" value="${sessionScope.principal.UEmail}"  class="form-control" placeholder="Enter email" maxlength="100">
     </div>
     <div class="input-group form-group">
                     <input type="radio" id="male" name="UGender" value="${sessionScope.principal.UGender}">
                     <label for="male">
                     <i class="fas fa-male"> 남자</i>
                     </label>   
                     <input type="radio" id="female" name="UGender" value="${sessionScope.principal.UGender}">
                     <label for="female"> 
                     <i class="fas fa-female">여자</i>
                     </label>
                  </div>
     <div class="form-group">
       <input type="text" name="UWeight" id="weight" value="${sessionScope.principal.UWeight}"  class="form-control" placeholder="Enter weight">
     </div>
     <div class="form-group">
       <input type="text" name="UHeight" id="height" value="${sessionScope.principal.UHeight}"  class="form-control" placeholder="Enter height">
     </div>
     <div class="form-group">
       <input type="text" name="UMuscle" id="muscle" value="${sessionScope.principal.UMuscle}"  class="form-control" placeholder="Enter muscle">
     </div>
     <div class="form-group">
       <input type="text" name="UBMI" id="BMI" value="${sessionScope.principal.UBMI}"  class="form-control" placeholder="your BMI" readonly="readonly">
     </div>
     
     <button type="submit" class="btn btn-primary">회원수정</button>
   </form>
</div>

<script>
async function update(event, id){ 
      event.preventDefault();

      let userUpdateDto = {
            uEmail: document.querySelector("#uEmail").value
      };

      let response = await fetch("http://localhost:8080/api/user/"+id, {
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
    document.getElementById("bmi").value = weight / ((height/100) * (height/100));
  }


</script>

<%@ include file="../layout/footer.jsp" %>
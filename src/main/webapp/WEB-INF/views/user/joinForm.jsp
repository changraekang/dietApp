<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<title>Join Page</title>
<!--Made with love by Mutiullah Samim -->

<!--Bootsrap 4 CDN-->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">

<!--Fontawesome CDN-->
<link rel="stylesheet"
	href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css"
	integrity="sha384-AYmEC3Yw5cVb3ZcuHtOA93w35dYTsvhLPVnYs9eStHfGJvOvKxVfELGroGkvsg+p"
	crossorigin="anonymous" />


<!--Custom styles-->
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script
	src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<style>
@import url('https://fonts.googleapis.com/css?family=Numans');

html, body {
	background-image: url('image/background.jpg');
	background-size: cover;
	background-repeat: no-repeat;
	height: 100%;
	font-family: 'Numans', sans-serif;
}

.container {
	height: 100%;
	align-content: center;
}

.card {
	float: left;
	height: 370px;
	margin-top: 30%;
	margin-bottom: auto;
	width: 400px;
	background-color: rgba(0, 0, 0, 0.5) !important;
	height: 450px;
}

.social_icon span {
	font-size: 60px;
	margin-left: 10px;
	color: #FFC312;
}

.social_icon span:hover {
	color: white;
	cursor: pointer;
}

.card-header h3 {
	color: white;
}

.card-footer {
	background-color: #F2FAFF !important;
}

.social_icon {
	position: absolute;
	right: 20px;
	top: -45px;
}

a:link {
	color: white;
}

a:visited {
	color: black;
}

a:hover {
	color: blue;
}

a:active {
	color: black
}

.input-group-prepend span {
	width: 50px;
	background-color: #FFC312;
	color: black;
	border: 0 !important;
}

input:focus {
	outline: 0 0 0 0 !important;
	box-shadow: 0 0 0 0 !important;
}

.login_btn {
	color: black;
	background-color: #FFC312;
	width: 100px;
}

.login_btn:hover {
	color: black;
	background-color: white;
}

.join_btn {
	color: black;
	background-color: #72C8FF;
	height: 35px;
	width: 100px;
}

.join_btn:hover {
	color: black;
	background-color: #32AFFF;
}

.links {
	color: black;
}

.fas {
	background-color: #FFC312;
}

.links a {
	margin-left: 4px;
}
</style>

</head>

<body>

	<div class="container">
		<div class="d-flex justify-content-center h-100">
			<form action="/join" method="post">
				<div class="card">
					<div class="card-header">
						<h3>Sign Up</h3>
					</div>
					<div class="card-body">
						<div class="input-group form-group">
							<div class="input-group-prepend">
								<span class="input-group-text"><i class="fas fa-user"></i></span>
							</div>
							<input type="text" class="form-control" placeholder="ID를 입력해주세요"
								required="required" maxlength="20">

						</div>
						<div class="input-group form-group">
							<div class="input-group-prepend">
								<span class="input-group-text"><i class="fas fa-key"></i></span>
							</div>
							<input type="password" class="form-control"
								placeholder="PASSWORD를 입력해주세요" required="required">
						</div>
						<div class="input-group form-group">
							<div class="input-group-prepend">
								<span class="input-group-text"><i
									class="fas fa-user-circle"></i></span>
							</div>
							<input type="text" class="form-control" placeholder="이름을 입력해주세요"
								required="required">
						</div>
						<div class="input-group form-group">
							<div class="input-group-prepend">
								<span class="input-group-text"><i class="fas fa-phone"></i></span>
							</div>
							<input type="text" class="form-control"
								placeholder="PHONE NUMBER를 입력해주세요" required="required">
						</div>
						<div class="input-group form-group">
							<div class="input-group-prepend">
								<span class="input-group-text"><i
									class="fas fa-address-book"></i></span>
							</div>
							<input type="email" class="form-control"
								placeholder="EMAIL를 입력해주세요" required="required">
						</div>
						<div class="form-group">
							<input type="submit" value="Join"
								class="btn float-right Join_btn">
						</div>
					</div>
				</div>
				<div class="card">
					<div class="card-header">
						<h3>Body Check</h3>

					</div>
					<div class="card-body">
						<div class="input-group form-group">
							<input type="radio" id="male" name="gender" value="male">
							<label for="male">
							<i class="fas fa-male"> 남자</i>
							</label>   
							<input type="radio" id="female" name="gender" value="female">
							<label for="female"> 
							<i class="fas fa-female">여자</i>
							</label>
						</div>
						<div class="input-group form-group">
							<div class="input-group-prepend">
								<span class="input-group-text"><i class="fas fa-weight"></i></span>
							</div>
							<input type="text" class="form-control" placeholder="몸무게를 입력해주세요"
								required="required">

						</div>
						<div class="input-group form-group">
							<div class="input-group-prepend">
								<span class="input-group-text"><i class="fas fa-child"></i></span>
							</div>
							<input type="text" class="form-control" placeholder="키를 입력해주세요"
								required="required">
						</div>
						<div class="input-group form-group">
							<div class="input-group-prepend">
								<span class="input-group-text"><i class="fas fa-dumbbell"></i></span>
							</div>
							<input type="text" class="form-control"
								placeholder="근육량을 입력해주세요(필수아님)">
						</div>

						<div class="input-group form-group">
							<div class="input-group-prepend">
								<span class="input-group-text"><i class="fas fa-child"></i></span>
							</div>
							<input type="text" class="form-control" placeholder="BMI"
								readonly="readonly">
						</div>

					</div>
				</div>
			</form>
		</div>
	</div>
</body>
</html>
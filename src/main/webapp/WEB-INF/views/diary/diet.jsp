<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta charset="UTF-8">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js"></script>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
	integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
	crossorigin="anonymous"></script>

<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
	integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
	crossorigin="anonymous"></script>


<link rel="stylesheet" href="css/main.min.css">

<style>


body {
	display: flex;
	flex-direction: column;
}
#todaydate {

 text-align: center;
 vertical-align:middle;
}

#chooseFile {
	visibility: hidden;
}



#diarysave{
	visibility: hidden;
}
#diarylist{
	visibility: hidden;
}

#diaryphoto {
	visibility: hidden;
	width: 100%;
	height: 50%;
	object-fit: cover;
}

</style>
<style>
#contextMenu {
	position: absolute;
	display: none;
	z-index: 2;
}

#contextMenu .dropdown-menu {
	border: none;
}

a {
	color: black;
	text-decoration: none;
}

a:link {
	color: black;
}

a:visited {
	color: black;
}

a:hover {
	color: black;
}

a:active {
	color: black
}

ul {
	list-style-type: none;
	margin: 0;
	padding: 0;
	overflow: hidden;
	border: 1px solid #e7e7e7;
	background-color: #f3f3f3;
}

li {
	float: left;
}

li a {
	display: block;
	color: #666;
	text-align: center;
	padding: 14px 16px;
	text-decoration: none;
}

li a:hover:not(.active) {
	color: white;
	background-color: #04AA6D;
}

li a.active {
	color: white;
	background-color: #04AA6D;
}

dropdown2 {
	position: relative;
	display: inline-block;
}

.dropdown2-content {
	display: none;
	position: absolute;
	background-color: #f9f9f9;
	min-width: 160px;
	box-shadow: 0px 8px 16px 0px rgba(0, 0, 0, 0.2);
	padding: 12px 16px;
	z-index: 1;
}

.dropdown2:hover .dropdown2-content {
	display: block;
}

.flex_container {
	display: flex;
}

.flex_item {
	margin: auto;
}

.jumbotron {
	background-color: #f9f9f9;
}

.image-thumbnail {
	width: 100%;
	height: 100%;
	object-fit: cover;
}

#calendar {
	max-width: 1200px;
	margin: 0 auto;
}
</style>
<title>Insert title here</title>
</head>
<body>


	<ul class="nav justify-content-around bg-light">
		<li class="flex-fill"><a class="" href="/news" style= "text-decoration: none;">News</a></li>
		<li class="flex-fill"><a href="/calorieDic" style= "text-decoration: none;">????????? ??????</a> </li>
		<li class="dropdown2 flex-fill"><a href="javascript:void(0)"
			class="dropbtn " style= "text-decoration: none;">????????????</a>
			<div class="dropdown2-content flex-fill" style="width: 15.8%">
				<a href="/board?menuId=1" style= "text-decoration: none;">???????????????</a> 
				<a href="/board?menuId=2" style= "text-decoration: none;">?????? QnA</a>
				<a href="/recipe" style= "text-decoration: none;">???????????? Recipe</a> 
				<a href="/board?menuId=3" style= "text-decoration: none;">???????????? ?????????</a>
			</div></li>
		<li class="dropdown2 flex-fill"><a href="javascript:void(0)"
			class="dropbtn" style= "text-decoration: none;">???????????? ????????????</a>
			<div class="dropdown2-content flex-fill" style="width: 19.5%">
			<a href="/exercise" style= "text-decoration: none;">?????? ??????</a> 
			<a href="/diet" style= "text-decoration: none;">?????? ??????</a>
			</div></li>
		<li class="flex-fill"><a href="/myBody/${sessionScope.principal.id}" style= "text-decoration: none;">?????? Body</a></li>
		<li class="dropdown2 flex-fill"><a href="javascript:void(0)"  class="droptbtn" style= "text-decoration: none;">????????????</a>
			<div class="dropdown2-content flex-fill" style="width: 15.8%">
			<a href="/user/${sessionScope.principal.id}" style= "text-decoration: none;">????????????</a> 
			<a href="/logout" style= "text-decoration: none;">????????????</a>
			</div>
		</li>
		
	</ul>
	<div class="jumbotron text-center"
		style="height: 200px; position: relative">
		<img class="image-thumbnail" src="/image/eating.jpg">
	</div>


	<input type="hidden" id="userId" value="${sessionScope.principal.id}">
	<!-- ?????? + ?????? ?????? -->
	
	<div class="container m_tm_20" style="height: 100%;">

		<div id="calendar" style="float: left; width: 66%; height: 200px;"></div>
			
				<div id = "todaydate" >
				</div>
				<br>
		<div id="diary" style="float: left; width: 34%; height: 650px;">
		<form class="upload-form" action="/food" method="post" enctype="multipart/form-data">
				<div class="form-group">
					<input type="text" id="date" name="date" class="form-control"
						required="required" readonly="readonly">
				</div>
				<br>
				<div id="mealtime" class="form-group">
						<p>?????? ????????? ??????????????????:</p>
					?? <input type="radio" id="??????" name="mealtime" value="??????" required > ??<label for="??????">??????</label>
					?? <input type="radio" id="??????" name="mealtime" value="??????"> ??<label for="??????">??????</label>
					?? <input type="radio" id="??????" name="mealtime" value="??????">  <label for="??????">??????</label>
					?? <input type="radio" id="??????" name="mealtime" value="??????">  <label for="??????">??????</label><br>

				</div>
				
				<script>
					
				</script>
				
				<div class="form-group" id="diet" style="width: 100%;">
					<table style="width: 100%;" id="fooddiary">
						<tr>
							<td><input type="button" value="?????? ??????" onclick="add_textbox()"
								style="float: left"></td>
						</tr>
					</table>
				</div>

				<div class="form-group">
					?????? ??? ????????? : <span id="totalkcal"></span>kcal
				</div>
				<div class="image-upload" id="image-upload">

					<div class="button">
						<label for="chooseFile"> ???? CLICK HERE! ???? *?????? ????????? ???????????????*</label>
						<input type="file" id="chooseFile" name="chooseFile"
							accept="image/*" onchange="loadFile(this)">
					</div>
				</div>
				<div class="image-show" id="image-show"
					style="width: 50%; height: 30%">
					<img id="diaryphoto" src="">
				</div>
				<button type="submit" id="diarysave" class="btn btn-primary" onclick="calenderClick(event);" >????????????</button>
				<a id = "diarylist" href="/diet/${sessionScope.principal.id}/list" >?????????????????????</a> 
			</form>




			<div class="container">
				<form method="post" enctype="multipart/form-data"></form>
			</div>
		</div>
	</div>
	<footer>
		<div class="jumbotron text-center"
			style="position: absolute; left: 0; bottom: -20; width: 100%;">
			<p>2??? ????????????App 1557</p>
			<p>????010-1234-1557</p>
			<p>????????????? ????????????</p>
			<p>???????????????????: 051-****-1557</p>
		</div>
	</footer>





<script src="js/main.js"></script>
<script src="js/ko.js"></script>
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script>
let mealtime =  $("#mealtime input").on("click", function(event){
mealtime  = event.target.value;
});

let today = new Date();   

let year = today.getFullYear(); // ??????
let month = today.getMonth() + 1;  // ???
let date = today.getDate();  // ??????

$("#date").val(year+"-"+month+"-"+ date);

let foodin = 0;
// ?????? DB??? ?????? 
async function calenderClick(event) {
	event.preventDefault();
	let foodReqDto = {
			kcal : parseInt(document.querySelector('#totalkcal').textContent),
			mealtime : document.querySelector('input[name="mealtime"]:checked').value,
			date : document.querySelector('#date').value
	}
	for(let j = 1; j <= 5 ; j++) {
		let food = document.querySelector('#food'+j);
		if(food == null) {
			break;
		}
		foodin++;
	}
	if(foodin >= 1) foodReqDto.food1 = document.querySelector('#food1').textContent;
	if(foodin >= 2) foodReqDto.food2 = document.querySelector('#food2').textContent;
	if(foodin >= 3) foodReqDto.food3 = document.querySelector('#food3').textContent;
	if(foodin >= 4) foodReqDto.food4 = document.querySelector('#food4').textContent;
	if(foodin >= 5) foodReqDto.food5 = document.querySelector('#food5').textContent;
	
	console.log(foodReqDto);
    let response = await fetch("http://localhost:8080/food", {
        method: "post",
        body: JSON.stringify(foodReqDto),
        headers: {
           "Content-Type": "application/json; charset=utf-8"
        }
     });
     
     let parseResponse = await response.json();
     if(parseResponse.code == 1){
        alert("?????? ?????? ??????");
     }else{
        alert("?????? ?????? ?????? : "+parseResponse.msg);
     }
	
}
document.addEventListener('DOMContentLoaded', function() {
	var calendarEl = document.getElementById('calendar');
	

	var calendar = new FullCalendar.Calendar(calendarEl, {
		initialView : 'dayGridMonth',
		selectable : true,
		locale : 'ko',
		height: 650,
		dateClick : function(info) {
			calendar.on('dateClick', function(info) {
				console.log('clicked on ' + info.dateStr);
			});

			document.getElementById("date").value = info.dateStr;
			events: [ /* event data here */]
		},
	            
		initialDate : today,
		dayMaxEventRows : true, // for all non-TimeGrid views
		dayMaxEventRows : 3, // adjust to 6 only for timeGridWeek/timeGridDay

		eventClick : function(arg) {
			if (confirm('Are you sure you want to delete this event?')) {
				arg.event.remove()
			}
		},
		headerToolbar: { 
			start:'list',
			center: 'fooddiary'
		},
		customButtons: {
			list : {
				text: '???????????????',
				click: function() {
					$('#diarylist').get(0).click();
					$("#diarylist").trigger("click");
				}
			},
			fooddiary: {
				text: '????????????',
				click: function() {
					calendar.addEvent({
						title: mealtime + " " + document.querySelector("#totalkcal").textContent+"kcal",
						start: document.getElementById("date").value,
						allDay: true
					});
					$("#diarysave").trigger("click");
				}
			}
		}

	});

	calendar.render();
});

function diary_click() {

}

function loadFile(input) {
	var file = input.files[0]; //????????? ?????? ????????????

	//?????? ????????? ?????? div??? text(?????? ??????) ??????
	//????????? ????????? div ??????
	//document.getElementById('image-upload').style.visibility = 'hidden';
	var newImage = document.createElement("img");
	newImage.setAttribute("class", 'img');

	//????????? source ????????????
	newImage.src = URL.createObjectURL(file);

	newImage.style.width = "100px";
	newImage.style.height = "300px";
	newImage.style.objectFit = "contain";

	//???????????? image-show div??? ??????
	//var container = document.getElementById('image-show');

	$("#diaryphoto").attr("src", newImage.src);
	document.getElementById('diaryphoto').style.visibility = 'visible';
	//container.appendChild(newImage);
};


var i = 1;
// ?????? ?????? ??????
const add_textbox = () => {
    if (i >= 5) {
    	return alert("????????????????????? ?????????????????????");
      }
    var pop = window.open("/diet/foodAdd","pop","width=800,height=600, scrollbars=yes, resizable=yes");
}
// ????????? ????????? ????????????
function calorieCallBack(food){
	const box = document.getElementById('fooddiary');
	const newP = document.createElement('p');
	newP.setAttribute('id','foodinsert' + i);
	newP.innerHTML = '<span id="food' + i + '">' + food.name + '</span> ' + food.gram + '(g) - <span id="kcal' + i + '">' + food.kcal + '</span>(kcal)';
	box.appendChild(newP);
	i = i + 1;
	kcalcalc();
}
const remove = (obj) => {
	obj.parentNode.firstChild.value = '';
	kcalcalc();
}
// ??? ????????? ??????
function kcalcalc(){
	let totalkcal = 0;
	for(let j = 1 ; j < i ; j++){
		totalkcal += parseInt($('#kcal' + j).text());
	}
	$('#totalkcal').text(totalkcal);
}
kcalcalc();

// DB?????? ?????? ????????????
async function dietList(){
	let userIdReq = {
		userid : document.querySelector('#userId').value
	}
	
	let response = await fetch("http://localhost:8080/diet/diary", {
		method: "post",
		body: JSON.stringify(userIdReq),
		headers: {
			"Content-Type": "application/json; charset=utf-8"
		}
	});
	
	let parseResponse = await response.json();
	console.log(parseResponse);
	
	if(parseResponse.code == 1){
	//	alert("?????? ???????????? ??????"); 
	}else{
		alert("?????? ???????????? ?????? : "+parseResponse.msg);
	}
}
dietList();

</script>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html lang='en'>
<head>
<meta charset='utf-8' />
<script src="/js/fullcalender/main.min.js"></script>
<link rel="stylesheet" href="/css/fullcalender/main.min.css">


<script>
	document.addEventListener('DOMContentLoaded', function() {
		var calendarEl = document.getElementById('calendar');
		var calendar = new FullCalendar.Calendar(calendarEl, {
			initialView : 'dayGridMonth'
		});
		calendar.render();
	});
	
	var calendar = new FullCalendar.Calendar(calendarEl, {
		  // no plugin configuration required!
		});
</script>




<style>
.calendar{
	 width: 50%;
}
</style>
</head>
<body>
	<div id='calendar' class = 'calendar'></div>
	<button value="월별정리">월별정리</button>
</body>
</html>
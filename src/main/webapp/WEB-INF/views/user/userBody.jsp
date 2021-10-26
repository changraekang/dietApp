<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<%@ include file="../layout/header.jsp"%>
<div class="container m_tm_20" style="height: 140%;">
	<div style="float: left; width: 66%;">
		<img alt="" src="/image/userbody.jpg" style="width: 66%; height: auto;">
	</div>
	<div style="float: right; width: 34%; height: auto; ">
	<table class="table">
		<thead>
			<tr>
				<th>이름</th>
				<th>현재체중</th>
				<th>목표체중</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td>John</td>
				<td>86kg</td>
				<td>72kg</td>
			</tr>
		</tbody>
	</table>
	<table class="table">
		<thead>
			<tr>
				<th>현재소비   Kcal</th>
				<th>목표소비   Kcal</th>
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
    <div class="progress-bar" style="width:70%"></div>
  </div>
</div>
<%@ include file="../layout/footer.jsp"%>
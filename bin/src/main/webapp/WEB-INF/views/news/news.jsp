<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<%@ include file="../layout/header.jsp" %>
<%
	response.sendRedirect("http://localhost:5000/");
	//request.getRequestDispatcher("/board?page=0").forward(request, response);
%>


<%@ include file="../layout/footer.jsp" %>
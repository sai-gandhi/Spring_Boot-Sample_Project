<%@page import="com.example.demo.model.Customer" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%
   Customer c=(Customer)session.getAttribute("customer");
   %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Customer home</title>
</head>
<body>
<%@include file="customernavbar.jsp" %><br/><br/>

Welcome <%=c.getName() %>
</body>
</html>
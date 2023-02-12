<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String pizza = (String)request.getAttribute("pizza");
	String[] toppings = (String[])request.getAttribute("topping");
	String[] sides = (String[])request.getAttribute("side");
	int price = (int)request.getAttribute("price");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>주문내역</h2>
	<h3>
	피자는 
	<%= pizza %>, 
	토핑은 
	<% if(toppings == null){ %>
		없고, 
	<%}else { %>
		<%= String.join(", ", toppings) %>
	<%} %>
	 사이드는 
	<% if(sides == null){ %>
		없고, 
	<%}else { %>
		<%= String.join(", ", sides) %>
	<%} %>
	 주문하셨습니다.
	 <br><br>
	 총합 : <%= price %>원
	</h3>
</body>
</html>
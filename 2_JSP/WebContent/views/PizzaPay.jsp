<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String pizza = (String)request.getAttribute("pizza");
	String[] toppings = (String[])request.getAttribute("toppings");
	String[] sides = (String[])request.getAttribute("sides");
	int price = (int)request.getAttribute("price");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>주문 내역</h2>
	<h3>
	피자는
	<span style="color: red;"><%= pizza %></span>,
	토핑은
	<span style="color: green;">
		<% if(toppings == null){ %>
			없고
		<%} else {%>
			<%= String.join(", ", toppings) %>
		<%} %>, 
	</span>
	사이드는
	<span style="color: blue;">
		<% if(sides == null){ %>
			없고
		<%} else {%>
			<%= String.join(", ", sides) %>
		<%} %>, 
	</span>
	주문하셨습니다.
	<br><br>
	총합 : <%= price %>원
	</h3>
	
</body>
</html>
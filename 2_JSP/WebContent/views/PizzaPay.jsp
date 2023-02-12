<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String pizza = (String)request.getAttribute("pizza");
	String[] topping = (String[])request.getAttribute("side");
	String[] side = (String[])request.getAttribute("side");
	int price = (int)request.getAttribute("price");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>주문내역</h3>
	<h3>
		피자는 
		<span style="color:red;"><%= pizza %></span>, 
		토핑은 
		<span style="color:green;">
		<% if(topping == null) { %>
			없고, 
		<% } else { %>
			<%= String.join(",", topping) %>
		<% } %>
		</span>
		사이드는  
		<span style="color:blue;">
		<% if(side == null) { %>
			없고, 
		<% } else { %>
			<%= String.join(", ", side) %>
		<% } %>
		</span>
		 주문하셨습니다.
		<br><br>
		총합 : <%= price %>원
	</h3>
</body>
</html>
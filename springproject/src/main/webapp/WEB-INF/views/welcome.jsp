<%@page import="com.te.springproject.dto.Employee"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ include file="header.jsp"%>
<%
Employee employee = (Employee) request.getAttribute("details");
String msg = (String) request.getAttribute("msg");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
	if (msg != null) {
	%>
	<h1><%=msg%></h1>
	<%
	}
	%>

	<h1>
		welcome
		<%=employee.getUsername()%>
	</h1>

</body>
</html>
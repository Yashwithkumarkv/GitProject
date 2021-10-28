<%@page import="com.te.springproject.dto.Employee"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ include file="header.jsp"%>

<%
Employee employee = (Employee) request.getAttribute("emp");
String msg2 = (String) request.getAttribute("msg2");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
	if (msg2 != null) {
	%>
	<h1><%=msg2%></h1>
	<%
	}
	%>
	<form action="./search" method="post">
		<table>
			<tr>
				<td><input type="number" name="user"
					placeholder="enter the id to search"></td>
				<td><input type="submit" value="search"></td>
			</tr>
		</table>
	</form>
	<hr>
	<hr>
	<%
	if (employee != null) {
	%>
	<h1><%=employee.getId()%></h1>
	<h1><%=employee.getUsername()%></h1>
	<h1><%=employee.getPassword()%></h1>
	<h1><%=employee.getDate()%></h1>
	<%
	}
	%>

</body>
</html>
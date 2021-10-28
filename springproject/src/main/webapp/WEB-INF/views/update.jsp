<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@include file="header.jsp"%>
<%
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
	<form action="./update" method="post">
		<table>
			<tr>
				<td>Enter id</td>
				<td><input type="number" name="id"></td>
			</tr>

			<tr>
				<td>Enter date</td>
				<td><input type="date" name="date"></td>
			</tr>

			<tr>
				<td>Enter password</td>
				<td><input type="password" name="password"></td>
			</tr>

			<tr>
				<td>Enter username</td>
				<td><input type="text" name="username"></td>
			</tr>
		</table>
		<input type="submit" value="update">
	</form>
</body>
</html>
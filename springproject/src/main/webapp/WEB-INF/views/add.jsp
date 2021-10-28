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

	<form action="./add" method="post">
		<table>
			<tr>
				<td>ENTER THE ID</td>
				<td><input type="number" name="id"></td>
			</tr>

			<tr>
				<td>ENTER THE DATE</td>
				<td><input type="date" name="date"></td>
			</tr>

			<tr>
				<td>ENTER THE PASSWORD</td>
				<td><input type="password" name="password"></td>
			</tr>

			<tr>
				<td>ENTER THE USERNAME</td>
				<td><input type="text" name="username"></td>
			</tr>

		</table>
		<input type="submit" value="add">
	</form>
</body>
</html>
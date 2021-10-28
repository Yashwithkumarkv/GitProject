<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@include file="header.jsp" %>
<%
String msg = (String) request.getAttribute("msg");
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
	if (msg != null) {
	%>
	<h1><%=msg%></h1>
	<%
	}
	%>

	<%
	if (msg2 != null) {
	%>
	<h1><%=msg2%></h1>
	<%
	}
	%>
	<form action="./delete" method="post">
		<table>
			<tr>
				<td><input type="number" name="id"
					placeholder="enter the id to delete"></td>
				<td><input type="submit" value="delete"></td>
			</tr>
		</table>
	</form>
</body>
</html>
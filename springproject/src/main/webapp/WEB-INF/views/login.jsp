<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%
String msg = (String) request.getAttribute("msg");
String msg1 = (String) request.getAttribute("msg1");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% if(msg1!=null){%>
<%=msg1 %>
 <%} %>
 
 <% if(msg!=null){%>
<%=msg %>
 <%} %>
	<fieldset>
		<legend>login form</legend>
		<form action="./login" method="post">
			<table>
				<tr>
					<td><label>USER ID</label></td>
					<td><input type="number" name="user"
						placeholder="enter the id"></td>
				</tr>

				<tr>
					<td><label>PASSWORD</label></td>
					<td><input type="password" name="pwd"
						placeholder="enter password"></td>
				</tr>
			</table>
			<input type="submit" value="login">
		</form>
	</fieldset>
</body>
</html>
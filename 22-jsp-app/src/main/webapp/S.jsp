<%@page import="max.Emp"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="max.Emp"%><!-- data ko import krna -->
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<table border="3" bgcolor="cyan" align="center">
		<tr>
			<td>UID</td>
			<td>Address</td>
			<td>phone</td>
		</tr>
		<%
		Emp emp = (Emp) request.getAttribute("e");
		%>
		<tr>
			<td><%=emp.getUid()%></td>
			<td><%=emp.getAdd()%></td>
			<td><%=emp.getMob()%></td>
		</tr>

	</table>
</body>
</html>
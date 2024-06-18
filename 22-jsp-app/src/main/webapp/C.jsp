<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<%
	String uid = (String) session.getAttribute("uid");
	String id = (String) application.getAttribute("id");
	%>

	<%="C.jsp...! >" + uid + "Application ID " + id%>


</body>
</html>
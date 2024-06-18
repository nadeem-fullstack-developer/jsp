<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<jsp:useBean id="emp" class="max.Emp" />
<jsp:setProperty property="*" name="emp" />
<jsp:useBean id="empDAO" class="max.EmpDAO" />
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
	if (empDAO.getUserDetail(emp)) {
		request.setAttribute("e", emp);
		request.getRequestDispatcher("S.jsp").forward(request, response);
	} else {
		request.getRequestDispatcher("index.jsp").include(request, response);

	}
	%>
</body>
</html>
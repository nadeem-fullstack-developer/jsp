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
	String email = config.getInitParameter("email");
	String uid = request.getParameter("uid");
	String pass = request.getParameter("pass");

	if (!uid.equalsIgnoreCase(pass)) {
		pageContext.setAttribute("pcId", uid, pageContext.REQUEST_SCOPE);
		session.setAttribute("uid", uid);
		application.setAttribute("id", uid);
		request.getRequestDispatcher("C.jsp").include(request, response);
	} else {
		out.print("UID and PASS Same");
		request.getRequestDispatcher("index.jsp").include(request, response);
		//request.getRequestDispatcher("index.jsp").forward(request, response);

	}
	%>

	<%="WEB.xml config tag " + email%>

</body>
</html>
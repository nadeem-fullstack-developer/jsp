<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<jsp:useBean id="regDAO" class="max.reg.RegDAO"></jsp:useBean>
<%@ page import="max.reg.SHGMem"%>
<%@ page import="max.reg.SHGDTO"%>
<%@ page import="java.util.List"%>
<%@ page import="max.reg.MemDTO"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<table border="3" bgcolor="yellow">
		<tr>
			<td>SHG CODE</td>
			<td>Group Name</td>
			<td>State Name</td>
			<td>Account</td>
			<td>IFSC CODE</td>
		</tr>

		<%
		SHGMem b = regDAO.viewDeatil();
		List<SHGDTO> slist = b.getShgList();
		List<MemDTO> mlist = b.getMemList();

		for (SHGDTO p : slist) {
		%>
		<tr bgcolor="cyan">
			<td><%=p.getShgCode()%></td>
			<td><%=p.getGname()%></td>
			<td><%=p.getStCode()%></td>
			<td><%=p.getAcc()%></td>
			<td><%=p.getIfsc()%></td>
		</tr>
		<tr>
			<td colspan="5" bgcolor="red">CHILD DETAIL</td>
		</tr>


		<tr>
			<td>Member Code</td>
			<td>Name</td>
			<td>Age</td>
			<td>Adhar</td>
		</tr>

		<%
		for (MemDTO q : mlist) {
			if (p.getShgCode() == q.getShgCode()) {
		%>
		<tr>
			<td><%=q.getMemCode()%></td>
			<td><%=q.getCname()%></td>
			<td><%=q.getAge()%></td>
			<td><%=q.getCadhar()%></td>
		</tr>

		<%
		}
		}
		}
		%>



	</table>


</body>
</html>
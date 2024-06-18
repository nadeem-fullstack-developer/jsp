
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.*"%>
<%@ page import="java.util.*"%>

<jsp:useBean id="userdoa" class="com.in.Uid.Doa.Check_transit" />
<jsp:setProperty property="*" name="userdoa" />
<%
List<String> listtransit = userdoa.getranist();
Iterator it = listtransit.iterator();
%>
<form action="processinrequest.jsp">
	<h3>PASSPORT VERIFICATION</h3>
	<hr>
	<table>
		<tr>
			<td>Select Citizen ID</td>
			<td><select name=cid>
					<%
					while (it.hasNext()) {
						out.println("<option>" + it.next().toString() + "</option>");
					}
					%>
			</select></td>
		</tr>
		<tr></tr>
	</table>
	<p>
		<input type=submit value='Process'>
	</p>
</form>


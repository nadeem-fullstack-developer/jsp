
<%@ page import="java.sql.*"%>
<%@ page import="java.sql.*"%>
<%@ page import="java.util.*"%>
<%@ page import="com.in.Uid.Bean.Staff"%>

<jsp:useBean id="userdoa" class="com.in.Uid.Doa.Report" />
<jsp:setProperty property="*" name="userdoa" />
<%
List<Staff> listtransit = userdoa.getstaffdetails();
Iterator it = listtransit.iterator();
%>




<h3>REGISTERED AADHAAR STAFF</h3>
<table border>
	<tr>
		<td>Staff ID</td>
		<td>Staff Name</td>
		<td>Location</td>
		<td>Regn Date</td>
	</tr>
	<%
	while (it.hasNext()) {
		Staff staff = (Staff) it.next();
		out.println("<tr><td>" + staff.getSid() + "</td><td>" + staff.getSname() + "</td><td>" + staff.getLocation()
		+ "</td><td>" + staff.getDor() + "</td></tr>");
	}
	out.println("<table>");
	%>
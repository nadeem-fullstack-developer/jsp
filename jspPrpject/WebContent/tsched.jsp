
<%@ page import="java.sql.*"%>
<%
String t1, tpcode;
Connection con;
Statement stmt, stmt1;
ResultSet rs, rs1;
%>
<%
java.util.Date dt;
int dy, mn, yr;
String tdt, edt;
%>

<%
dt = new java.util.Date();
dy = dt.getDate();
mn = dt.getMonth() + 1;
yr = dt.getYear() + 1900;
tdt = dy + "/" + mn + "/" + yr;
edt = dy + "/" + mn + "/" + (yr + 10);
%>

<%
t1 = (String) session.getAttribute("logid");

try {
	rs = null;
	Class.forName("org.postgresql.Driver");
	con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Adhaar", "postgres", "postgres");
	stmt = con.createStatement();

	stmt1 = con.createStatement();
	rs1 = stmt1.executeQuery("select * from schedule where cid=" + t1);
	out.println("<h5>RTA TEST SCHEDULE</h5><hr>Citizen Id : " + t1 + "<table>");
	out.println("<table border><tr><td>Venue</td><td>Report To</td><td>Date</td><td>Time</td><td>Wheeler</td></tr>");
	while (rs1.next()) {
		out.println("<tr><td>" + rs1.getString(2) + "</td><td>" + rs1.getString(3) + "</td><td>" + rs1.getString(4)
		+ "</td><td>" + rs1.getString(5) + "</td><td>" + rs1.getString(7) + "</td></tr>");
	}
	out.println("</table><hr>");
} catch (Exception ee) {
	out.println(ee.getMessage());
}
%>

<%@ page import="java.sql.*"%>
<%
String t1, tpcode;
Connection con;
Statement stmt, stmt1;
ResultSet rs, rs1;
%>

<%
t1 = (String) session.getAttribute("logid");

try {
	rs = null;
	Class.forName("org.postgresql.Driver");
	con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Adhaar", "postgres", "postgres");
	stmt = con.createStatement();

	rs = stmt.executeQuery("select pinc from pinmast where sid='" + t1 + "'");

	if (rs.next()) {
		tpcode = rs.getString(1);
		rs.close();
		stmt1 = con.createStatement();
		rs1 = stmt1.executeQuery(
		"select pin,ano from cregn where ano in (select cid from passport where status='Processing')");
		out.println("<form method=post action=vpp2.jsp>");
		out.println("<h3>PASSPORT APPLICATIONS PENDING</h3><hr><table>");
		out.println("<tr><td>Select Citizen ID</td><td><select name=cid>");
		while (rs1.next()) {
	String cpin = rs1.getString(1);
	//
	int i = 0;
	String p1 = "";
	while (i < tpcode.length() - 1) {
		while (!tpcode.substring(i, i + 1).equals(":") && i < tpcode.length() - 1) {
			p1 = p1 + tpcode.substring(i, i + 1);
			i++;
			if (i == tpcode.length() - 1)
				p1 = p1 + tpcode.substring(i, i + 1);
		}
		if (p1.equals(cpin))
			out.println("<option>" + rs1.getString(2) + "</option>");
		//
		i = i + 1;
		p1 = "";
	}
		}
		out.println("</select></td></tr></table><p><input type=submit value='Process'></FORM>");
	} else
		out.println("<font color=red><b>Invalid Pincodes....");

} catch (Exception ee) {
	out.println(ee.getMessage());
}
%>
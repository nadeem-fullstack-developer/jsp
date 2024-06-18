
<%@ page import="java.util.*,java.sql.*"%>
<%
java.util.Date dt;
int dy, mn, yr;
String tdt, dist;
%>
<%
Connection con;
Statement stmt, stmt1;
ResultSet rs;
String tappno;
String st, sname;
%>
<%
tdt = "";
dt = new java.util.Date();
dy = dt.getDate();
mn = dt.getMonth() + 1;
yr = dt.getYear() + 1900;
tdt = dy + "/" + mn + "/" + yr;
%>


<%
System.out.println("hello");
tappno = request.getParameter("appno");

sname = request.getParameter("sname");
st = request.getParameter("r2");

try {
	out.println("<body background='light_blue1.bmp'>");

	Class.forName("org.postgresql.Driver");
	con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Adhaar", "postgres", "postgres");
	stmt1 = con.createStatement();
	if (!sname.equals("")) {
		if (st.equals("1")) {
	String no = tappno + "";
	session.setAttribute("sappno", no);
	session.setAttribute("sname", sname);
	response.sendRedirect("cprocess1.jsp");
		} else {
	stmt1.executeUpdate("update cregn set status='Rejected' where appno=" + tappno);
	out.println("<font color=red><b>Candidate Application Rejected.");
		}
	} else {
		out.println("Invalid Data! All fields are mandatory...<a href='sappno.jsp'>Try Again</a>");
	}
} catch (Exception ee) {
	out.println("Invalid Data! All fields are mandatory..." + ee.getMessage());
}
%>
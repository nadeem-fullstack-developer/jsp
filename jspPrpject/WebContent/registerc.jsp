
<%@ page import="java.util.*,java.sql.*"%>
<html>
<body>
<head>
<script type="text/javascript">
	function checkDetail() {
		var x = document.forms["r"]["name"].value;
		var add = document.forms["r"]["add"].value;

		if (x == "" || x == null) {
			alert("Name must be filled out");
			return false;
		}
		if (add == "" || add == null) {
			alert("Address must be filled out");
			return false;
		}

		var mob = document.forms["r"]["mob"].value;
		var phoneno = /^\d{10}$/;
		if ((mob.value.match(phoneno))) {
			return true;
		} else {
			alert("message");
			return false;
		}
	}
</script>

</head>


<%
java.util.Date dt;
int dy, mn, yr;
String tdt, dist;
%>
<%
Connection con;
Statement stmt, stmt1;
ResultSet rs;
%>
<%
tdt = "";
dt = new java.util.Date();
dy = dt.getDate();
mn = dt.getMonth() + 1;
yr = dt.getYear() + 1900;
tdt = dy + "/" + mn + "/" + yr;
%>



<body background='light_blue1.bmp'>
	<form name="r" action="register" onsubmit="return checkDetail();"
		method="get">
		<TH>CITIZEN REGISTRATION
			<hr>
			<table>
				<tr>
					<td><font size=1>Registration Date</font></td>
					<td><input type=text size=10 disabled value=" <%=tdt%> "></td>
				</tr>

				</select>
				</td>
				</tr>

				<tr>
					<td><font size=1>Citizen Name</font></td>
					<td><input type=text size=15 name=name id=name width=15
						height=15></td>
					<td><font size=1>Address</font></td>
					<td><input type=text size=15 name=address id="add"></td>
				</tr>

				<tr>
					<td><font size=1>Birth Date</font></td>
					<td><input type=text size=15 name=dob></td>
					<td><font size=1>Fathers Name</font></td>
					<td><input type=text size=15 name=fname></td>
				<tr>
					<td><font size=1>Contact No</font></td>
					<td><input type=text size=15 name=contactno id=mob></td>
					<td><font size=1>Occupation</font></td>
					<td><input type=text size=15 name=occupation></td>
				</tr>
				<tr>
					<td><font size=1>Gender</font></td>
					<td><font size=1>Male</font> <input type=radio name='gender'
						value='Male'> <font size=1> Female</font> <input
						type=radio name='gender' value='Female'></td>
				</tr>

			</table> <input type=submit value=Register22> <input type=reset>
	</form>
</body>
</html>
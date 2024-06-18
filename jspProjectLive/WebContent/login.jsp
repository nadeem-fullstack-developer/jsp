<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript">
 function getOtp()
 {
	var mob= document.getElementById("mob").value;
	
	var xmlhttp;
	if (window.XMLHttpRequest)
	{
	// code for IE7+, Firefox, Chrome, Opera, Safari
	     xmlhttp=new XMLHttpRequest();
	}
	else
	{// code for IE6, IE5
	 xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
	 }
	 
	 
	xmlhttp.onreadystatechange=function()
	{
	if (xmlhttp.status==200)
	{
	//document.getElementById("fname").value

	    document.getElementById("t").value=xmlhttp.responseText;
	    document.getElementById("tt").innerHTML=xmlhttp.responseText;
	   
	}
	 
	}
	 
	 xmlhttp.open("GET","LoginOtpServlet?mob="+mob,true);
	xmlhttp.send(); 
	
	
	
 }

</script>

</head>
<body>
<form action="LoginServlet" method="post">
<table border="3" bgcolor="yellow">
<tr><td>UID</td><td><input type="text" name="uid"></td></tr>
<tr><td>Pass</td><td><input type="password" name="pass"></td></tr>

<tr><td>Mobile</td><td><input type="text" name="mob" id="mob" onblur="getOtp()">

<input type="hidden" name="otp" readonly="readonly" id="t" size="6">
</td>

</tr>
<tr><td><input type="submit" value="Login">

</td><td><p id="tt"></p></td></tr>
</table>

</form>




</body>
</html>
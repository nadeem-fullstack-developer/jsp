<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>


<script type="text/javascript">
	function getSum() {
		var fn = document.getElementById("firstNum").value;
		var sn = document.getElementById("secNum").value;

		var h;
		if (window.XMLHttpRequest) {
			h = new XMLHttpRequest();
		} else {
			h = new ActiveXObject("Microsoft.XMLHTTP");
		}

		h.onreadystatechange = function() {
			if (h.readyState == 4 && h.status == 200) {
				document.getElementById("tt").innerHTML = h.responseText;
			}
		}
		h.open("GET", "add?fn=" + fn + "&sn=" + sn + "", true);
		h.send();
	}
</script>




<body>

	<form action="add">
		<table border="3" bgcolor="yellow">
			<tr>
				<td>FN</td>
				<td><input type="text" name="fn" id="firstNum"
					onblur=" getSum();"></td>
			</tr>
			<tr>
				<td>SN</td>
				<td><input type="text" name="sn" id="secNum" onblur=" getSum(); "></td>
			</tr>
			<tr>

				<td><input type="submit" name="SUM" onblur="getSum();"></td>
			</tr>
			<p id="tt"></p>
		</table>
	</form>
</body>
</html>
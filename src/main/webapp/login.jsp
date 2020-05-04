<%--
  Created by IntelliJ IDEA.
  User: bstacksp
  Date: 4/13/20
  Time: 12:34 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
	<title>Log In</title>
	<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
	<link href="/css/style.css" rel="stylesheet" type="text/css">
</head>

<body class="w3-light-grey">
<div class="w3-container w3-blue-grey w3-opacity w3-right-align">
	<h1 align="center">Flex</h1>
</div>

<div class="form-style-5">
	<div>
		<div>
			<h2>Log In</h2>
		</div>
		<%
			if (request.getAttribute("Fail") != null) {
				out.println("<div class=\"w3-panel w3-red w3-display-container w3-card-4 w3-round\">\n" +
						"   <span onclick=\"this.parentElement.style.display='none'\"\n" +
						"   class=\"w3-button w3-margin-right w3-display-right w3-round-large w3-hover-red w3-border w3-border-red w3-hover-border-grey\">×</span>\n" +
						"   <h5>Fail!\n" +
						"</div>");
			}
		%>
		<form method="post">
			<label>Name:
				<input type="text" name="name" ><br />
			</label>
			<label>Password:
				<input type="password" name="pass"><br />
			</label>
			<button type="submit">Submit</button>
		</form>
	</div>
</div>
<div class="w3-container w3-grey w3-opacity w3-right-align w3-padding">
	<button class="w3-btn w3-round-large" onclick="location.href='/'">Back to flex</button>
</div>
</body>
</html>

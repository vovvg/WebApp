<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: bstacksp
  Date: 5/4/20
  Time: 5:57 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
	<title>Home</title>
	<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
	<link href="/css/style.css" rel="stylesheet" type="text/css">
</head>

<body class="w3-light-grey">
<div class="w3-container w3-blue-grey w3-opacity w3-right-align">
	<h1 align="center">EZY</h1>
</div>
<%
	if (request.getAttribute("userName") != null) {
		out.println("<div class=\"w3-panel w3-green w3-display-container w3-card-4 w3-round\">\n" +
				"   <span onclick=\"this.parentElement.style.display='none'\"\n" +
				"   class=\"w3-button w3-margin-right w3-display-right w3-round-large w3-hover-green w3-border w3-border-green w3-hover-border-grey\">×</span>\n" +
				"   <h5>User '" + request.getAttribute("userName") + "' signed!</h5>\n" +
				"</div>");
	}
%>
<div class="form-style-5">
	<img src="../images/img.jpg" width="608" height="342">
</div>
<TABLE class="form-style-5">
	<tr>
		<th>Login</th>
	</tr>
	<c:forEach items="${usersFromServer}" var="users">
		<tr>
			<td>${users.login}</td>
		</tr>
	</c:forEach>
</TABLE>
<div class="w3-container w3-grey w3-opacity w3-right-align w3-padding">
	<form method="post">
		<button type="submit" name="exit" id="exit" class="w3-btn w3-round-large">Exit</button>
	</form>
</div>
</body>
</html>

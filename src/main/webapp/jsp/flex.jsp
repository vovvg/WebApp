<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: bstacksp
  Date: 4/17/20
  Time: 12:33 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
	<meta charset="UTF-8">
	<title>Flex</title>
	<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</head>

<body class="w3-light-grey">
<div class="w3-container w3-blue-grey w3-opacity w3-right-align">
	<h1 align="center">Flex</h1>
</div>

<div class="w3-container w3-center">
	<div class="w3-bar w3-padding-large w3-padding-24">
		<button class="w3-btn w3-hover-light-blue w3-round-large" onclick="location.href='login'">Log In</button>
		<button class="w3-btn w3-hover-green w3-round-large" onclick="location.href='signup'">Sign up</button>
	</div>
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
</body>
</html>

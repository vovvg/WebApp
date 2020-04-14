<%--
  Created by IntelliJ IDEA.
  User: bstacksp
  Date: 4/13/20
  Time: 12:34 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
	<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
	<title>Login</title>
</head>
<body>
<h2>Input your login/password</h2>
login: <form method="get">
	<input type="text" name="login" size="25"></form>
password: <form method="get">
	<input type="password" name="password" size="25"></form>
	<br>
	<input type="submit" value="Submit">
	<input type="reset" value="Reset">
		<%
String login = request.getParameter("login");
String password = request.getParameter("password");

%>

	<a href="test">Test page</a>
</body>
</html>

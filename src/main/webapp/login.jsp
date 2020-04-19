<%--
  Created by IntelliJ IDEA.
  User: bstacksp
  Date: 4/13/20
  Time: 12:34 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
	<title>Log In</title>
	<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</head>

<body class="w3-light-grey">
<div class="w3-container w3-blue-grey w3-opacity w3-right-align">
	<h1 align="center">EZY</h1>
</div>

<div class="w3-container w3-padding">
	<div class="w3-card-4">
		<div class="w3-container w3-center w3-green">
			<h2>Log In</h2>
		</div>
		<form method="post" class="w3-selection w3-light-grey w3-padding">
			<label>Name:
				<input type="text" name="name" class="w3-input w3-animate-input w3-border w3-round-large" style="width: 30%"><br />
			</label>
			<label>Password:
				<input type="password" name="pass" class="w3-input w3-animate-input w3-border w3-round-large" style="width: 30%"><br />
			</label>
			<button type="submit" class="w3-btn w3-green w3-round-large w3-margin-bottom">Submit</button>
		</form>
	</div>
</div>
<div class="w3-container w3-grey w3-opacity w3-right-align w3-padding">
	<button class="w3-btn w3-round-large" onclick="location.href='/WebApp'">Back to home</button>
</div>
</body>
</html>

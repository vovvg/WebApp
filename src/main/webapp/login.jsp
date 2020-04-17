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
	<title>Users</title>
</head>

<body>
<div>
	<h1>EZY</h1>
</div>

<div>
	<div>
		<div>
			<h2>Log In</h2>
		</div>
		<%
			List<String> names = (List<String>) request.getAttribute("userNames");

			if (names != null && !names.isEmpty()) {
				out.println("<ui>");
				for (String s : names) {
					out.println("<li>" + s + "</li>");
				}
				out.println("</ui>");
			} else out.println("<p>There are no users yet!</p>");
		%>
	</div>
</div>

<div>
	<button onclick="location.href=''">Back to home</button>
</div>
</body>
</html>
</body>
</html>

package ru.user.project.web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Login", urlPatterns = "/")
public class Login extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//request.getRequestDispatcher("/login.jsp").forward(request,response);
		String log = request.getParameter("log");
		String pass = request.getParameter("password");
		if (log.equals("1") && pass.equals("1")) {
			//request.getRequestDispatcher("/test.jsp").forward(request,response);
			System.out.println(log + pass);
			response.sendRedirect("/test");
		}
	}
}
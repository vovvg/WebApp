package ru.user.project.web;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Login", urlPatterns = "/login")
public class Login extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("/login.jsp");
		requestDispatcher.forward(req, resp);
//		String log = req.getParameter("login");
//		String pass = req.getParameter("password");
//		if (log.equals("1") && pass.equals("1")) {
//			System.out.println(log + pass + req.getContextPath());
//			resp.sendRedirect(req.getContextPath() + "/test");
//		}
	}
}
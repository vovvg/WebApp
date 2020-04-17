package ru.user.project.web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//@WebServlet(name = "Auth", urlPatterns = "/login")
public class Auth extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		String log = req.getParameter("login");
//		String pass = req.getParameter("password");
//		if (log.equals("1") && pass.equals("1")) {
//			System.out.println(log + pass + req.getContextPath());
//			resp.sendRedirect(req.getContextPath() + "/test");
//		}
	}
}

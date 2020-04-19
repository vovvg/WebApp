package app.servlets;

import app.entities.User;
import app.model.Model;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "login", urlPatterns = "/LogIn")
public class LogIn extends HttpServlet {
	public Boolean flag = false;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if (flag)
			resp.sendRedirect(req.getContextPath() + "/test");
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("login.jsp");
		requestDispatcher.forward(req, resp);

	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		String password = req.getParameter("pass");
		Model model = Model.getInstance();
		flag = false;
		doGet(req, resp);
		List<String> names = model.list();
		for(String user : names)
			if(model.password(name).equals(password) && user.equals(name))
				flag = true;
		doGet(req, resp);
	}
//	@Override
//	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		Model model = Model.getInstance();
//		List<String> names = model.list();
//		req.setAttribute("userNames", names);
//
//		RequestDispatcher requestDispatcher = req.getRequestDispatcher("login.jsp");
//		requestDispatcher.forward(req, resp);
//	}
}

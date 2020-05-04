package app.servlets;

import app.entities.User;
import app.model.Model;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "signup", urlPatterns = "/signup")
public class Signup extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getServletContext().getRequestDispatcher("/signup.jsp").forward(req,resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		String pass = req.getParameter("pass");
		Model model = Model.getInstance();
		if (!name.equals("") && !pass.equals("")){
			User user = new User(name, pass);
			model.add(user);
			req.setAttribute("userName", name);
		}
		else
			req.setAttribute("fail", "fail");
		doGet(req, resp);
	}
}

package app.controllers;

import app.models.User;
import app.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/home")
public class Home {

	@Autowired
	UserRepository userRepository;

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView filter(HttpServletRequest request){

		ModelAndView modelAndView = new ModelAndView("home");
		HttpSession session = request.getSession();
		if (session.getAttribute("user") == null) {
			modelAndView.addObject("fail", "fail");
			modelAndView.setViewName("login");
			return modelAndView;
		}
		List<User> users = userRepository.findAll();
		modelAndView.addObject("usersFromServer", users);
		return modelAndView;
	}

	@RequestMapping(method = RequestMethod.POST)
	public String exit (HttpServletRequest request) {
		if (request.getParameter("exit") != null) {
			HttpSession session = request.getSession();
			session.removeAttribute("user");
			return "redirect:/";
		}
		return "redirect:home";
	}
}

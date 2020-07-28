package app.controllers;


import app.models.User;
import app.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class Login {

	@Autowired
	UserRepository userRepository;

	@RequestMapping(path = "/login", method = RequestMethod.GET)
	public ModelAndView login() {
		ModelAndView modelAndView = new ModelAndView("login");
		return modelAndView;
	}

	@RequestMapping(path = "/login", method = RequestMethod.POST)
	public ModelAndView postLogin(@ModelAttribute("user") User user, HttpServletRequest request) {

		ModelAndView modelAndView = new ModelAndView();
		User authUser = userRepository.getUserByLoginAndPassword(user.getLogin(), user.getPassword());
		if (authUser == null) {
			modelAndView.addObject("fail", "fail");
			return modelAndView;
		}
		HttpSession session = request.getSession();
		session.setAttribute("user", authUser);
		RedirectView redirectView = new RedirectView("home");
		modelAndView.setView(redirectView);
		return modelAndView;
	}
}

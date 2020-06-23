package app.controllers;

import app.models.User;
import app.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


@Controller
public class Signup {

	@Autowired
	UserRepository userRepository;

	@RequestMapping(path = "/signup", method = RequestMethod.GET)
	public ModelAndView login(ModelAndView modelAndView) {
		return modelAndView;
	}

	@RequestMapping(path = "/signup", method = RequestMethod.POST)
	public ModelAndView addUser(User user, HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView("signup");
		try {
			if (user.getLogin() == null || user.getPassword() == null)
				return login(modelAndView);
			userRepository.save(user);
			modelAndView.addObject("userName", user.getLogin());
			HttpSession session = request.getSession();
			session.setAttribute("user", user);
			RedirectView redirectView = new RedirectView("home");
			modelAndView.setView(redirectView);
		} catch (Exception e) {
			modelAndView.addObject("fail", "fail");
			return modelAndView;
		}
		return modelAndView;
	}
}

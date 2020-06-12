package app.controllers;

import app.models.User;
import app.models.UserForm;
import app.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.util.List;

@Controller
public class Signup {

	@Autowired
	UserRepository userRepository;

	@RequestMapping(path = "/signup", method = RequestMethod.GET)
	public ModelAndView login() {
		List<User> users = userRepository.findAll();
		ModelAndView modelAndView = new ModelAndView("signup");
		modelAndView.addObject("usersFromServer", users);
		return modelAndView;
	}

	@RequestMapping(path = "/signup", method = RequestMethod.POST)
	public ModelAndView addUser(User user) {
		ModelAndView modelAndView = new ModelAndView("signup");
		if(user.getLogin().equals(null) || user.getPassword().equals(null))
			return login();
		try {
			userRepository.save(user);
		} catch (Exception e) {
			return login();
		}

		modelAndView.addObject("login", user.getLogin());
		return login();
	}
}

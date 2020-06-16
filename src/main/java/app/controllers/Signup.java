package app.controllers;

import app.models.User;
import app.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class Signup {

	@Autowired
	UserRepository userRepository;

	@RequestMapping(path = "/signup", method = RequestMethod.GET)
	public ModelAndView login(ModelAndView modelAndView) {
		List<User> users = userRepository.findAll();
		modelAndView.addObject("usersFromServer", users);
		return modelAndView;
	}

	@RequestMapping(path = "/signup", method = RequestMethod.POST)
	public ModelAndView addUser(User user) {
		ModelAndView modelAndView = new ModelAndView("signup");
		if (user.getLogin() == null || user.getPassword() == null)
			return login(modelAndView);
		try {
			userRepository.save(user);
			modelAndView.addObject("userName", user.getLogin());
		} catch (Exception e) {
			modelAndView.addObject("fail", "fail");
			return login(modelAndView);
		}
		return login(modelAndView);
	}
}

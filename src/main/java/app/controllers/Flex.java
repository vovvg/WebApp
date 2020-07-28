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
public class Flex {

	@Autowired
	UserRepository userRepository;

	@RequestMapping(path = "/", method = RequestMethod.GET)
	public ModelAndView getUsers() {
		ModelAndView modelAndView = new ModelAndView("flex");
		return modelAndView;
	}

}

package hu.elte.recipe.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import hu.elte.recipe.entities.User;
import hu.elte.recipe.exceptions.UserNotValidException;
import hu.elte.recipe.services.PopulateDatabaseService;
import hu.elte.recipe.services.UserService;

@RestController
public class LoginController {
	
	@Autowired private UserService userService;
	@Autowired private PopulateDatabaseService populateDatabaseService;
	private boolean isDatabasePopulated = false;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView showLoginPage() {
		if(!isDatabasePopulated) {
			populateDatabaseService.populateDatabase();
			isDatabasePopulated = true;
		}
		return new ModelAndView("login");
	}
	
	@RequestMapping(value = "login", method = RequestMethod.POST)
	public ModelAndView login(@ModelAttribute("user") User user, BindingResult result) {
		if(result.hasErrors()) {
			return new ModelAndView("jajj");
		}
		try {
			userService.login(user);
			return new ModelAndView("redirect:user/details.html");
		} catch(UserNotValidException u) {
			return new ModelAndView("redirect:/");
		}
	}
	
	@RequestMapping(value = "user/logout")
	public ModelAndView logout() {
		userService.logout();
		return new ModelAndView("redirect:/");
	}

}

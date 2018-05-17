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

// TODO: Auto-generated Javadoc
/**
 * The Class LoginController.
 */
@RestController
public class LoginController {
	
	/** The user service. */
	@Autowired private UserService userService;
	
	/** The populate database service. */
	@Autowired private PopulateDatabaseService populateDatabaseService;
	
	/** The is database populated. */
	private boolean isDatabasePopulated = false;
	
	/**
	 * Show login page.
	 *
	 * @return the model and view
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView showLoginPage() {
		if(!isDatabasePopulated) {
			populateDatabaseService.populateDatabase();
			isDatabasePopulated = true;
		}
		return new ModelAndView("login");
	}
	
	/**
	 * Login.
	 *
	 * @param user the user
	 * @param result the result
	 * @return the model and view
	 */
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
	
	/**
	 * Logout.
	 *
	 * @return the model and view
	 */
	@RequestMapping(value = "user/logout")
	public ModelAndView logout() {
		userService.logout();
		return new ModelAndView("redirect:/");
	}

}

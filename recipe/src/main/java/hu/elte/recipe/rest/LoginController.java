package hu.elte.recipe.rest;

import javax.servlet.ServletException;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class LoginController {
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView showLoginPage() {
		return new ModelAndView("login");
	}

}

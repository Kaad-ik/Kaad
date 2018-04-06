package hu.elte.recipe.rest;

import javax.servlet.ServletException;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class LoginController {

/*	public void init() throws ServletException {
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
	}
*/
	@RequestMapping("/")
	public ModelAndView showLoginPage() {
		return new ModelAndView("login");
	}

}

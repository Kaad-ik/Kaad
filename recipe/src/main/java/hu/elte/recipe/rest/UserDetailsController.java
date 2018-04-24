package hu.elte.recipe.rest;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import hu.elte.recipe.entities.Currency;
import hu.elte.recipe.entities.User;
import hu.elte.recipe.entities.httpentities.CurrencyModel;
import hu.elte.recipe.services.UserService;

@RestController
public class UserDetailsController {
	
	@Autowired private UserService userService;
	
	@ModelAttribute("currencyModel")
	public CurrencyModel getCurrencyModel() {
		return new CurrencyModel(Arrays.asList(Currency.values()));
	}
	
	@RequestMapping(value = "user/details.html", method = RequestMethod.GET)
	public ModelAndView showUserDetails(Model model) {
		User user = userService.getActualUser();
		model.addAttribute("user", user);
		return new ModelAndView("user");
	}
}

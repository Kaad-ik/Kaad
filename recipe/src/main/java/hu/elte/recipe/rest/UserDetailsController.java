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
import hu.elte.recipe.entities.httpentities.CurrencyModel;
import hu.elte.recipe.entities.httpentities.UserHttpEntity;
import hu.elte.recipe.entities.httpentities.transformers.UserTransformer;
import hu.elte.recipe.services.UserService;

@RestController
public class UserDetailsController {
	
	@Autowired private UserService userService;
	@Autowired private UserTransformer userTransformer;
	
	@ModelAttribute("currencyModel")
	public CurrencyModel getCurrencyModel() {
		return new CurrencyModel(Arrays.asList(Currency.values()));
	}
	
	@RequestMapping(value = "user/details.html", method = RequestMethod.GET)
	public ModelAndView showUserDetails(Model model) {
		UserHttpEntity user = userTransformer.transformUserToUserHttpEntity(userService.getActualUser());
		model.addAttribute("user", user);
		return new ModelAndView("user");
	}
	
	@RequestMapping(value = "user/updateUser", method = RequestMethod.POST)
	public ModelAndView updateUserDetails(@ModelAttribute("user") UserHttpEntity user) {
		userTransformer.transformUserToUserHttpEntity(userService.updateUser(user));
		return new ModelAndView("redirect:details.html");
	}
}

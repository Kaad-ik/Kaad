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
import hu.elte.recipe.entities.Role;
import hu.elte.recipe.entities.User;
import hu.elte.recipe.entities.httpentities.CurrencyModel;

@RestController
@RequestMapping("/user")
public class UserDetailsController {
	
	@ModelAttribute("currencyModel")
	public CurrencyModel getCurrencyModel() {
		return new CurrencyModel(Arrays.asList(Currency.values()));
	}
	
	@RequestMapping(value = "/details.html", method = RequestMethod.GET)
	public ModelAndView showUserDetails(Model model) {
		User user = getUser();
		model.addAttribute("user", user);
		return new ModelAndView("user");
	}

	private User getUser() {
		User user = new User();
		user.setId(1L);
		user.setUserName("kelecs08");
		user.setFullName("Anna Kelecsenyi");
		user.setEmail("kelecsenyi.anna@imagine.com");
		user.setRole(Role.ADMIN);
		user.setMoney(1000);
		user.setCurrency(Currency.HUF);
		return user;
	}
}

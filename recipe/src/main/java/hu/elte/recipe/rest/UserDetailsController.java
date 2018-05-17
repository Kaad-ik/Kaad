package hu.elte.recipe.rest;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import hu.elte.recipe.entities.Currency;
import hu.elte.recipe.entities.httpentities.CurrencyModel;
import hu.elte.recipe.entities.httpentities.UserHttpEntity;
import hu.elte.recipe.entities.httpentities.transformers.UserTransformer;
import hu.elte.recipe.services.UserService;

// TODO: Auto-generated Javadoc
/**
 * The Class UserDetailsController.
 */
@RestController
public class UserDetailsController {
	
	/** The user service. */
	@Autowired private UserService userService;
	
	/** The user transformer. */
	@Autowired private UserTransformer userTransformer;
	
	/**
	 * Gets the currency model.
	 *
	 * @return the currency model
	 */
	@ModelAttribute("currencyModel")
	public CurrencyModel getCurrencyModel() {
		return new CurrencyModel(Arrays.asList(Currency.values()));
	}
	
	/**
	 * Show user details.
	 *
	 * @param model the model
	 * @return the model and view
	 */
	@RequestMapping(value = "user/details.html", method = RequestMethod.GET)
	public ModelAndView showUserDetails(Model model) {
		UserHttpEntity user = userTransformer.transformUserToUserHttpEntity(userService.getActualUser());
		model.addAttribute("user", user);
		return new ModelAndView("user");
	}
	
	/**
	 * Update user details.
	 *
	 * @param user the user
	 * @param bindingResult the binding result
	 * @param redirectAttributes the redirect attributes
	 * @return the model and view
	 */
	@RequestMapping(value = "user/updateUser", method = RequestMethod.POST)
	public ModelAndView updateUserDetails(@ModelAttribute("user") UserHttpEntity user, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
		if(!bindingResult.hasErrors()) {
			userTransformer.transformUserToUserHttpEntity(userService.updateUser(user));
			redirectAttributes.addFlashAttribute("message", "User successfully updated.");
		} else {
			redirectAttributes.addFlashAttribute("message", "The data provided was not appropriate, so the update failed.");
		}
		return new ModelAndView("redirect:details.html");
	}
}

package hu.elte.recipe.rest;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import hu.elte.recipe.entities.Currency;
import hu.elte.recipe.entities.Ingredient;
import hu.elte.recipe.entities.IngredientUnitType;
import hu.elte.recipe.entities.httpentities.CurrencyModel;
import hu.elte.recipe.entities.httpentities.IngredientHttpEntity;
import hu.elte.recipe.entities.httpentities.IngredientTypeModel;
import hu.elte.recipe.entities.httpentities.UnitModel;
import hu.elte.recipe.entities.httpentities.transformers.IngredientTransformer;
import hu.elte.recipe.services.IngredientService;
import hu.elte.recipe.services.IngredientTypeService;
import hu.elte.recipe.services.UserService;

@RestController
public class MyIngredientsController {

	@Autowired private UserService userService;
	@Autowired private IngredientService ingredientService;
	@Autowired private IngredientTransformer ingredientTransformer;
	@Autowired private IngredientTypeService ingredientTypeService;

	@ModelAttribute("currencyModel")
	public CurrencyModel getCurrencyModel() {
		return new CurrencyModel(Arrays.asList(Currency.values()));
	}

	@ModelAttribute("unitModel")
	public UnitModel getUnitModel() {
		return new UnitModel(Arrays.asList(IngredientUnitType.values()));
	}

	@ModelAttribute("ingredientTypeModel")
	public IngredientTypeModel getIngredientTypeModel() {
		return new IngredientTypeModel(ingredientTypeService.getAllIngredientTypeName());
	}
	
	@RequestMapping(value = "user/my-ingredients.html", method = RequestMethod.GET)
	public ModelAndView showMyIngredients(Model model) {
		Hibernate.initialize(userService.getActualUser().getIngredients());
		List<IngredientHttpEntity> ingredients = ingredientTransformer.transformIngredientsToIngredientHttpEntities(userService.getActualUser().getIngredients());
		model.addAttribute("ingredients", ingredients);
		model.addAttribute("ingredient", new IngredientHttpEntity());
		return new ModelAndView("my_ingredients");
	}
	
	@RequestMapping(value = "user/deleteIngredient", method = RequestMethod.GET)
	public ModelAndView removeFood(@RequestParam("id") Long id) {
		System.out.println(id);
		userService.deleteIngredient(id);
		return new ModelAndView("redirect:details.html");
	}
	
	@RequestMapping(value = "user/saveIngredient", method = RequestMethod.POST)
	public ModelAndView saveIngredient(@ModelAttribute("ingredient") IngredientHttpEntity ingredient, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
		if(!bindingResult.hasErrors()) {
			ingredientService.addIngredientByHttpEntity(ingredient);
			redirectAttributes.addFlashAttribute("message", "Ingredient successfully saved.");
		} else {
			redirectAttributes.addFlashAttribute("message", "The data provided was not appropriate, so the update failed.");
		}
		return new ModelAndView("redirect:my-ingredients.html");
	}
}

package hu.elte.recipe.rest;

import java.util.List;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import hu.elte.recipe.entities.httpentities.IngredientHttpEntity;
import hu.elte.recipe.entities.httpentities.transformers.IngredientTransformer;
import hu.elte.recipe.services.UserService;

@RestController
public class MyIngredientsController {

	@Autowired private UserService userService;
	@Autowired private IngredientTransformer ingredientTransformer;

	@RequestMapping(value = "user/my-ingredients.html", method = RequestMethod.GET)
	public ModelAndView showMyIngredients(Model model) {
		Hibernate.initialize(userService.getActualUser().getIngredients());
		List<IngredientHttpEntity> ingredients = ingredientTransformer.transformIngredientsToIngredientHttpEntities(userService.getActualUser().getIngredients());
		model.addAttribute("ingredients", ingredients);
		return new ModelAndView("my_ingredients");
	}
	
	@RequestMapping("user/deleteIngredient")
	public ModelAndView removeFood(@RequestParam("id") Long id) {
		userService.deleteIngredient(id);
		return new ModelAndView("redirect:my-ingredients.html");
	}
}

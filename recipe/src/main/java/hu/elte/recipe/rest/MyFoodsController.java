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

import hu.elte.recipe.entities.httpentities.FoodHttpEntity;
import hu.elte.recipe.entities.httpentities.transformers.FoodTransformer;
import hu.elte.recipe.services.FoodService;
import hu.elte.recipe.services.UserService;

@RestController
public class MyFoodsController {

	@Autowired private FoodTransformer foodTransformer;
	@Autowired private FoodService foodService;
	@Autowired private UserService userService;
	
	@RequestMapping(value = "user/my-foods.html", method = RequestMethod.GET)
	public ModelAndView showMyFoods(Model model) {
		Hibernate.initialize(userService.getActualUser().getCooked());
		List<FoodHttpEntity> foods = foodTransformer.transformFoodsToFoodHttpEntities(userService.getActualUser().getCooked());
		model.addAttribute("foods", foods);
		return new ModelAndView("my_foods");
	}
	
	@RequestMapping("user/deleteFood")
	public ModelAndView removeMyFood(@RequestParam("id") Long id) {
		foodService.deleteFood(id);
		return new ModelAndView("redirect:my-foods.html");
	}
}

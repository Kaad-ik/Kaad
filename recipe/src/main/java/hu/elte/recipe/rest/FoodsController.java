package hu.elte.recipe.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import hu.elte.recipe.entities.httpentities.FoodHttpEntity;
import hu.elte.recipe.services.FoodService;

@RestController
public class FoodsController {

	@Autowired private FoodService foodService;
	
	@RequestMapping(value = "user/foods.html", method = RequestMethod.GET)
	public ModelAndView showFoods(Model model) {
		List<FoodHttpEntity> foods = foodService.getAllFood();
		model.addAttribute("foods", foods);
		return new ModelAndView("foods");
	}
}

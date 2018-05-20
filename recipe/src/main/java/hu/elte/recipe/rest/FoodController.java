package hu.elte.recipe.rest;

import hu.elte.recipe.entities.Food;
import hu.elte.recipe.services.FoodService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class FoodController {

  @Autowired private FoodService foodService;
  
  @RequestMapping(value = "user/food/{id}", method = RequestMethod.GET)
  public ModelAndView showFoods(@PathVariable Long id, Model model) {
    Food food = foodService.findOne(id);
    model.addAttribute("food", food);
    return new ModelAndView("food");
  }
}

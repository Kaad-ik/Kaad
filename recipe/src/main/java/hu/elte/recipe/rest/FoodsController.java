package hu.elte.recipe.rest;

import hu.elte.recipe.entities.httpentities.FoodHttpEntity;
import hu.elte.recipe.services.FoodService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * The Class FoodsController.
 */
@RestController
public class FoodsController {

  /** The food service. */
  @Autowired private FoodService foodService;

  /**
   * Show foods.
   *
   * @param model the model
   * @return the model and view
   */
  @RequestMapping(value = "user/foods.html", method = RequestMethod.GET)
  public ModelAndView showFoods(Model model) {
    List<FoodHttpEntity> foods = foodService.getAllFood();
    model.addAttribute("foods", foods);
    return new ModelAndView("foods");
  }
}

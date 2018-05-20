package hu.elte.recipe.rest;

import hu.elte.recipe.entities.httpentities.FoodHttpEntity;
import hu.elte.recipe.entities.httpentities.transformers.FoodTransformer;
import hu.elte.recipe.services.FoodService;
import hu.elte.recipe.services.UserService;

import java.util.List;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * The Class MyFoodsController.
 */
@RestController
public class MyFoodsController {

  /** The food transformer. */
  @Autowired private FoodTransformer foodTransformer;

  /** The food service. */
  @Autowired private FoodService foodService;

  /** The user service. */
  @Autowired private UserService userService;

  /**
   * Show my foods.
   *
   * @param model the model
   * @return the model and view
   */
  @RequestMapping(value = "user/my-foods.html", method = RequestMethod.GET)
  public ModelAndView showMyFoods(Model model) {
    //Hibernate.initialize(userService.getActualUser().getCooked());
    System.out.println(userService.getActualUser().getCooked().size());
    List<FoodHttpEntity> foods = foodTransformer
        .transformFoodsToFoodHttpEntities(userService.getActualUser().getCooked());
    model.addAttribute("foods", foods);
    return new ModelAndView("my_foods");
  }

  /**
   * Removes the my food.
   *
   * @param id the id
   * @return the model and view
   */
  @RequestMapping("user/deleteFood")
  public ModelAndView removeMyFood(@RequestParam("id") Long id) {
    foodService.deleteFood(id);
    return new ModelAndView("redirect:my-foods.html");
  }
}

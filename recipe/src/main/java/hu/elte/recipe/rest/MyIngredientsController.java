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

// TODO: Auto-generated Javadoc
/**
 * The Class MyIngredientsController.
 */
@RestController
public class MyIngredientsController {

  /** The user service. */
  @Autowired private UserService userService;

  /** The ingredient service. */
  @Autowired private IngredientService ingredientService;

  /** The ingredient transformer. */
  @Autowired private IngredientTransformer ingredientTransformer;

  /** The ingredient type service. */
  @Autowired private IngredientTypeService ingredientTypeService;

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
   * Gets the unit model.
   *
   * @return the unit model
   */
  @ModelAttribute("unitModel")
  public UnitModel getUnitModel() {
    return new UnitModel(Arrays.asList(IngredientUnitType.values()));
  }

  /**
   * Gets the ingredient type model.
   *
   * @return the ingredient type model
   */
  @ModelAttribute("ingredientTypeModel")
  public IngredientTypeModel getIngredientTypeModel() {
    return new IngredientTypeModel(ingredientTypeService.getAllIngredientTypeName());
  }

  /**
   * Show my ingredients.
   *
   * @param model the model
   * @return the model and view
   */
  @RequestMapping(value = "user/my-ingredients.html", method = RequestMethod.GET)
  public ModelAndView showMyIngredients(Model model) {
    Hibernate.initialize(userService.getActualUser().getIngredients());
    List<IngredientHttpEntity> ingredients =
        ingredientTransformer.transformIngredientsToIngredientHttpEntities(
            userService.getActualUser().getIngredients());
    model.addAttribute("ingredients", ingredients);
    model.addAttribute("ingredient", new IngredientHttpEntity());
    return new ModelAndView("my_ingredients");
  }

  /**
   * Removes the food.
   *
   * @param id the id
   * @return the model and view
   */
  @RequestMapping(value = "user/deleteIngredient", method = RequestMethod.GET)
  public ModelAndView removeIngredient(@RequestParam("id") Long id) {
    userService.deleteIngredient(id);
    return new ModelAndView("redirect:my-ingredients.html");
  }
  
  /**
   * Increase ingredient.
   *
   * @param id the id
   * @return the model and view
   */
  @RequestMapping(value = "user/increaseIngredient", method = RequestMethod.GET)
  public ModelAndView increaseIngredient(@RequestParam("id") Long id) {
    ingredientService.increaseIngredient(id);
    return new ModelAndView("redirect:my-ingredients.html");
  }

  /**
   * Save ingredient.
   *
   * @param ingredient the ingredient
   * @param bindingResult the binding result
   * @param redirectAttributes the redirect attributes
   * @return the model and view
   */
  @RequestMapping(value = "user/saveIngredient", method = RequestMethod.POST)
  public ModelAndView saveIngredient(@ModelAttribute("ingredient") IngredientHttpEntity ingredient,
      BindingResult bindingResult, RedirectAttributes redirectAttributes) {
    if (!bindingResult.hasErrors()) {
      ingredient.setUserId(userService.getActualUser().getId());
      ingredientService.addIngredientByHttpEntity(ingredient);
      redirectAttributes.addFlashAttribute("message", "Ingredient successfully saved.");
    } else {
      redirectAttributes.addFlashAttribute("message", 
          "The data provided was not appropriate, so the update failed.");
    }
    return new ModelAndView("redirect:my-ingredients.html");
  }
}

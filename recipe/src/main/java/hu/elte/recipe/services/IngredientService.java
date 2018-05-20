package hu.elte.recipe.services;

import hu.elte.recipe.entities.Ingredient;
import hu.elte.recipe.entities.IngredientType;
import hu.elte.recipe.entities.User;
import hu.elte.recipe.entities.httpentities.IngredientHttpEntity;
import hu.elte.recipe.repositories.IngredientRepository;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * The Class IngredientService.
 */
@Service
@Transactional
public class IngredientService {
    
  /** The ingredient repository. */
  @Autowired private IngredientRepository ingredientRepository;
    
  /** The ingredient type service. */
  @Autowired private IngredientTypeService ingredientTypeService;
    
  /** The user service. */
  @Autowired private UserService userService;

  /**
   * Adds the ingredient.
   *
   * @param ingredient the ingredient
   * @return the ingredient
   */
  private Ingredient addIngredient(Ingredient ingredient) {
    userService.updateUser(ingredient.getOwner());
    return ingredientRepository.save(ingredient);
  }

  /**
   * Adds the ingredient by http entity.
   *
   * @param entity the entity
   * @return the ingredient
   */
  public Ingredient addIngredientByHttpEntity(IngredientHttpEntity entity) {
    IngredientType type = ingredientTypeService.getByName(entity.getName()).get();
    User user = userService.getActualUser();
    Ingredient ingredient = new Ingredient(type, user, entity.getQuantity(), entity.getUnit());
    user.addIngredient(ingredient);
    return addIngredient(ingredient);
    //return addIngredient(new Ingredient(type, null, entity.getQuantity(), entity.getUnit()));
  }

  /**
   * Increase ingredient.
   *
   * @param id the id
   */
  public void increaseIngredient(Long id) {
    Ingredient ing = ingredientRepository.findOne(id);
    System.out.println(ing.toString());
    int q = ing.getQuantity() + 1;
    ing.setQuantity(q);
    System.out.println(ing.toString());
    ing.setOwner(userService.getActualUser());
    ingredientRepository.save(ing);
  }
  
  /**
   * Decrease ingredient.
   *
   * @param id the id
   */
  public void decreaseIngredient(Long id) {
    Ingredient ing = ingredientRepository.findOne(id);
    System.out.println(ing.toString());
    int q = ing.getQuantity() - 1;
    ing.setQuantity(q);
    System.out.println(ing.toString());
    ing.setOwner(userService.getActualUser());
    ingredientRepository.save(ing);
  }
}

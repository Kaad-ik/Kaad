package hu.elte.recipe.entities.httpentities.transformers;

import hu.elte.recipe.entities.Ingredient;
import hu.elte.recipe.entities.httpentities.IngredientHttpEntity;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

/**
 * The Class IngredientTransformer.
 */
@Component
public class IngredientTransformer {

  /**
   * Transform ingredient to ingredient http entity.
   *
   * @param ingredient the ingredient
   * @return the ingredient http entity
   */
  public IngredientHttpEntity transformIngredientToIngredientHttpEntity(Ingredient ingredient) {
    IngredientHttpEntity entity = new IngredientHttpEntity();
    entity.setId(ingredient.getId());
    entity.setQuantity(ingredient.getQuantity());
    entity.setUnit(ingredient.getUnit());
    entity.setPrice(ingredient.getType().getPricePerGramms());
    entity.setName(ingredient.getTypeName());
    entity.setCurrency(ingredient.getType().getCurrency());
    return entity;
  }

  /**
   * Transform ingredients to ingredient http entities.
   *
   * @param ingredients the ingredients
   * @return the list
   */
  public List<IngredientHttpEntity> transformIngredientsToIngredientHttpEntities(
      List<Ingredient> ingredients) {
    List<IngredientHttpEntity> entities = new ArrayList<>();
    for (Ingredient i: ingredients) {
      entities.add(transformIngredientToIngredientHttpEntity(i));
    }
    return entities;
  }
}

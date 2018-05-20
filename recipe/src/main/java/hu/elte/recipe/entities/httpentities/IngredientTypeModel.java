package hu.elte.recipe.entities.httpentities;

import java.util.List;

/**
 * The Class IngredientTypeModel.
 */
public class IngredientTypeModel {

  /** The ingredient types. */
  private List<String> ingredientTypes;

  /**
   * Instantiates a new ingredient type model.
   *
   * @param ingredients the ingredients
   */
  public IngredientTypeModel(List<String> ingredients) {
    this.ingredientTypes = ingredients;
  }

  /**
   * Gets the ingredient types.
   *
   * @return the ingredient types
   */
  public List<String> getIngredientTypes() {
    return ingredientTypes;
  }

}

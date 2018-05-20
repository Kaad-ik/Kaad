package hu.elte.recipe.entities.httpentities;

import java.util.Set;

// TODO: Auto-generated Javadoc
/**
 * The Class FoodHttpEntity.
 */
public class FoodHttpEntity {

  /** The id. */
  private Long id;
    
  /** The name. */
  private String name;
    
  /** The ingredients. */
  private Set<IngredientHttpEntity> ingredients;
    
  /** The img url. */
  private String imgUrl;
    
  /** The recipe. */
  private String recipe;
    
  /** The users. */
  private Set<UserHttpEntity> users;

  /**
   * Instantiates a new food http entity.
   */
  public FoodHttpEntity() {}

  /**
   * Gets the id.
   *
   * @return the id
   */
  public Long getId() {
    return id;
  }

  /**
   * Sets the id.
   *
   * @param id the new id
   */
  public void setId(Long id) {
    this.id = id;
  }

  /**
   * Gets the name.
   *
   * @return the name
   */
  public String getName() {
    return name;
  }

  /**
   * Sets the name.
   *
   * @param name the new name
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * Gets the ingredients.
   *
   * @return the ingredients
   */
  public Set<IngredientHttpEntity> getIngredients() {
    return ingredients;
  }

  /**
   * Sets the ingredients.
   *
   * @param ingredients the new ingredients
   */
  public void setIngredients(Set<IngredientHttpEntity> ingredients) {
    this.ingredients = ingredients;
  }

  /**
   * Gets the img url.
   *
   * @return the img url
   */
  public String getImgUrl() {
    return imgUrl;
  }

  /**
   * Sets the img url.
   *
   * @param imgUrl the new img url
   */
  public void setImgUrl(String imgUrl) {
    this.imgUrl = imgUrl;
  }
    
  /**
   * Gets the recipe.
   *
   * @return the recipe
   */
  public String getRecipe() {
    return recipe;
  }

  /**
   * Sets the recipe.
   *
   * @param recipe the new recipe
   */
  public void setRecipe(String recipe) {
    this.recipe = recipe;
  }

  /**
   * Gets the users.
   *
   * @return the users
   */
  public Set<UserHttpEntity> getUsers() {
    return users;
  }

  /**
   * Sets the users.
   *
   * @param users the new users
   */
  public void setUsers(Set<UserHttpEntity> users) {
    this.users = users;
  }
      
}

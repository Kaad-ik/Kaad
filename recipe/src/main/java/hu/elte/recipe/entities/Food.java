package hu.elte.recipe.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import hu.elte.recipe.entities.httpentities.IngredientHttpEntity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;


/**
 * The Class Food.
 */
@Entity
@Table(name = "foods")
public class Food {

  /** The id. */
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column
  private Long id;

  /** The name. */
  @Column(nullable = false, unique = true)
  private String name;

  /** The img url. */
  @Column
  private String imgUrl;

  /** The recipe. */
  @Column(length = 100000)
  private String recipe;

  /** The ingredients. */
  @JsonIgnore
  @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, targetEntity = Ingredient.class)
  private List<Ingredient> ingredients;
    
  /** The users. */
  @JsonIgnore
  @ManyToMany(fetch = FetchType.EAGER, targetEntity = User.class)
  private List<User> users;

  /**
   * Gets the name.
   *
   * @return the name
   */
  public String getName() {
    return name;
  }

  /**
   * Instantiates a new food.
   */
  public Food() { }

  /**
   * Instantiates a new food.
   *
   * @param name the name
   * @param imgurl the imgurl
   * @param ingredients the ingredients
   * @param recipe the recipe
   */
  public Food(String name, String imgurl, List<Ingredient> ingredients, String recipe) {
    this.name = name;
    this.imgUrl = imgurl;
    this.ingredients = ingredients;
    this.recipe = recipe;
  }

  /**
   * Gets the id.
   *
   * @return the id
   */
  public Long getId() {
    return id;
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
   * @param imgurl the new img url
   */
  public void setImgUrl(String imgurl) {
    this.imgUrl = imgurl;
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
   * Gets the ingredients.
   *
   * @return the ingredients
   */
  public List<Ingredient> getIngredients() {
    return ingredients;
  }

  /**
   * Sets the ingredients.
   *
   * @param ingredients the new ingredients
   */
  public void setIngredients(List<Ingredient> ingredients) {
    this.ingredients = ingredients;
  }

  /**
   * Gets the users.
   *
   * @return the users
   */
  public List<User> getUsers() {
    return users;
  }

  /**
   * Adds the users.
   *
   * @param user the user
   */
  public void addUsers(User user) {
    if (this.users == null) {
      this.users = new ArrayList<>();
    }
    this.users.add(user);
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
   * Ingredients.
   *
   * @return the list
   */
  @JsonProperty("ingredients")
  public List<IngredientHttpEntity> ingredients() {
    if (ingredients != null) {
      return ingredients.stream().map(IngredientHttpEntity::new).collect(Collectors.toList());
    }
    return Collections.emptyList();
  }

  /**
   * Adds the ingredient.
   *
   * @param ingredient the ingredient
   */
  public void addIngredient(Ingredient ingredient) {
    if (this.ingredients == null) {
      this.ingredients = new ArrayList<>();
    }
    this.ingredients.add(ingredient);
  }

}

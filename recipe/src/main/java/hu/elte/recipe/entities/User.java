package hu.elte.recipe.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import hu.elte.recipe.entities.httpentities.IngredientHttpEntity;
import hu.elte.recipe.entities.httpentities.UserHttpEntity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

// TODO: Auto-generated Javadoc
/**
 * The Class User.
 */
@Entity
@Table(name = "users")
public class User {

  /** The id. */
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column
  private Long id;

  /** The user name. */
  @Column(unique = true, nullable = false)
  private String userName;
  
  /** The full name. */
  @Column(nullable = false)
  private String fullName;
    
  /** The email. */
  @Column(nullable = false)
  private String email;

  /** The password. */
  @Column(nullable = false)
  private String password;

  /** The role. */
  @Column(nullable = false)
  @Enumerated(EnumType.STRING)
  private Role role;

  /** The money. */
  @Column(nullable = false)
  private Integer money;
    
  /** The currency. */
  @Column(nullable = false)
  private Currency currency;

  /** The cooked. */
  @JsonIgnore
  @ManyToMany(fetch = FetchType.EAGER, targetEntity = Food.class)
  private List<Food> cooked;

  /** The ingredients. */
  @JsonIgnore
  @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, targetEntity = Ingredient.class)
  private List<Ingredient> ingredients;

  /**
   * Gets the cooked.
   *
   * @return the cooked
   */
  public List<Food> getCooked() {
    return cooked;
  }
    
  /**
   * Adds the cooked.
   *
   * @param food the food
   */
  public void addCooked(Food food) {
    System.out.println("cook");
    cooked.add(food);
  }

  /**
   * Instantiates a new user.
   */
  public User() {
    this.cooked = new ArrayList<>();
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
   * Sets the id.
   *
   * @param id the new id
   */
  public void setId(Long id) {
    this.id = id;
  }

  /**
   * Gets the user name.
   *
   * @return the user name
   */
  public String getUserName() {
    return userName;
  }

  /**
   * Sets the user name.
   *
   * @param userName the new user name
   */
  public void setUserName(String userName) {
    this.userName = userName;
  }

  /**
   * Gets the full name.
   *
   * @return the full name
   */
  public String getFullName() {
    return fullName;
  }
    
  /**
   * Sets the full name.
   *
   * @param fullName the new full name
   */
  public void setFullName(String fullName) {
    this.fullName = fullName;
  }

  /**
   * Gets the email.
   *
   * @return the email
   */
  public String getEmail() {
    return email;
  }

  /**
   * Sets the email.
   *
   * @param email the new email
   */
  public void setEmail(String email) {
    this.email = email;
  }

  /**
   * Gets the password.
   *
   * @return the password
   */
  public String getPassword() {
    return password;
  }

  /**
   * Sets the password.
   *
   * @param password the new password
   */
  public void setPassword(String password) {
    this.password = password;
  }

  /**
   * Gets the role.
   *
   * @return the role
   */
  public Role getRole() {
    return role;
  }

  /**
   * Sets the role.
   *
   * @param role the new role
   */
  public void setRole(Role role) {
    this.role = role;
  }

  /**
   * Gets the money.
   *
   * @return the money
   */
  public Integer getMoney() {
    return money;
  }

  /**
   * Sets the money.
   *
   * @param money the new money
   */
  public void setMoney(Integer money) {
    this.money = money;
  }

  /**
   * Gets the currency.
   *
   * @return the currency
   */
  public Currency getCurrency() {
    return currency;
  }
    
  /**
   * Sets the currency.
   *
   * @param currency the new currency
   */
  public void setCurrency(Currency currency) {
    this.currency = currency;
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
   * Adds the ingredient.
   *
   * @param ingredient the ingredient
   */
  public void addIngredient(Ingredient ingredient) {
    if (ingredients == null) {
      ingredients = new ArrayList<>();
      ingredients.add(ingredient);
    } else {
      this.ingredients.add(ingredient);
    }
  }
    
  /**
   * Delete ingredient.
   *
   * @param ingredient the ingredient
   */
  public void deleteIngredient(Ingredient ingredient) {
    System.out.println("size: " + ingredients.size());
    this.ingredients.remove(ingredient);
    System.out.println("size: " + ingredients.size());
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
   * Instantiates a new user.
   *
   * @param entity the entity
   */
  public User(UserHttpEntity entity) {
    this.userName = entity.getUserName();
    this.password = entity.getPassword();
    this.cooked = new ArrayList<>();
  }

  /* (non-Javadoc)
   * @see java.lang.Object#toString()
   */
  @Override
  public String toString() {
    return "User [id=" + id + ", userName=" + userName + ", fullName=" + fullName + ", email="
        + email + ", password=" + password + ", role=" + role + ", money=" + money + ", currency="
        + currency + ", cooked=" + cooked + ", ingredients=" + ingredients + "]";
  }
  
  
  
}

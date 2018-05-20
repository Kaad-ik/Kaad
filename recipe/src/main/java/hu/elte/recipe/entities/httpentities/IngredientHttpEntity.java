package hu.elte.recipe.entities.httpentities;

import hu.elte.recipe.entities.Currency;
import hu.elte.recipe.entities.Ingredient;
import hu.elte.recipe.entities.IngredientUnitType;

/**
 * The Class IngredientHttpEntity.
 */
public class IngredientHttpEntity {

  /** The id. */
  private Long id;
    
  /** The name. */
  private String name;
    
  /** The price. */
  private int price;
   
  /** The quantity. */
  private int quantity;
    
  /** The unit. */
  private IngredientUnitType unit;
    
  /** The user id. */
  private Long userId;
    
  /** The currency. */
  private Currency currency;

  /**
   * Instantiates a new ingredient http entity.
   *
   * @param ingredient the ingredient
   */
  public IngredientHttpEntity(Ingredient ingredient) {
    this.id = ingredient.getId();
    this.quantity = ingredient.getQuantity();
    this.name = ingredient.getTypeName();
    this.unit = ingredient.getUnit();
  }

  /**
   * Instantiates a new ingredient http entity.
   *
   * @param type the type
   * @param quantity the quantity
   * @param unit the unit
   */
  public IngredientHttpEntity(String type, int quantity, IngredientUnitType unit) {
    this.name = type;
    this.quantity = quantity;
    this.unit = unit;
  }

  /**
   * Instantiates a new ingredient http entity.
   */
  public IngredientHttpEntity() { }
  
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
   * @param type the new name
   */
  public void setName(String type) {
    this.name = type;
  }

  /**
   * Gets the quantity.
   *
   * @return the quantity
   */
  public int getQuantity() {
    return quantity;
  }

  /**
   * Sets the quantity.
   *
   * @param quantity the new quantity
   */
  public void setQuantity(int quantity) {
    this.quantity = quantity;
  }
    
  /**
   * Gets the unit.
   *
   * @return the unit
   */
  public IngredientUnitType getUnit() {
    return unit;
  }

  /**
   * Sets the unit.
   *
   * @param unit the new unit
   */
  public void setUnit(IngredientUnitType unit) {
    this.unit = unit;
  }

  /**
   * Gets the price.
   *
   * @return the price
   */
  public int getPrice() {
    return price;
  }

  /**
   * Sets the price.
   *
   * @param price the new price
   */
  public void setPrice(int price) {
    this.price = price;
  }

  /**
   * Gets the user id.
   *
   * @return the user id
   */
  public Long getUserId() {
    return userId;
  }

  /**
   * Sets the user id.
   *
   * @param userId the new user id
   */
  public void setUserId(Long userId) {
    this.userId = userId;
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

  @Override
  public String toString() {
    return "IngredientHttpEntity [id=" + id + ", name=" + name + ", price=" + price + ", quantity="
        + quantity + ", unit=" + unit + ", userId=" + userId + ", currency=" + currency + "]";
  }
    
}

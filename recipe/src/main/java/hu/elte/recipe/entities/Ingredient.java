package hu.elte.recipe.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * The Class Ingredient.
 */
@Entity
@Table(name = "ingredients")
public class Ingredient {

  /** The id. */
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column
  private Long id;

  /** The type. */
  @ManyToOne
  @JoinColumn(name = "type_id", updatable = false)
  @JsonIgnore
  private IngredientType type;

  /** The owner. */
  @ManyToOne
  @JoinColumn(name = "owner_id", updatable = false)
  private User owner;

  /** The quantity. */
  @Column(nullable = false)
  private int quantity;

  /** The unit. */
  @Column(nullable = false)
  @Enumerated(EnumType.STRING)
  private IngredientUnitType unit;

  /**
   * Instantiates a new ingredient.
   *
   * @param type the type
   * @param owner the owner
   * @param quantity the quantity
   * @param unit the unit
   */
  public Ingredient(IngredientType type, User owner, int quantity, IngredientUnitType unit) {
    this.type = type;
    this.owner = owner;
    this.quantity = quantity;
    this.unit = unit;
  }

  /**
   * Instantiates a new ingredient.
   */
  public Ingredient() {
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
   * Gets the type.
   *
   * @return the type
   */
  public IngredientType getType() {
    return type;
  }

  /**
   * Sets the type.
   *
   * @param type the new type
   */
  public void setType(IngredientType type) {
    this.type = type;
  }

  /**
   * Gets the owner.
   *
   * @return the owner
   */
  public User getOwner() {
    return owner;
  }

  /**
   * Sets the owner.
   *
   * @param owner the new owner
   */
  public void setOwner(User owner) {
    this.owner = owner;
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
   * Gets the type name.
   *
   * @return the type name
   */
  @JsonProperty("typename")
  public String getTypeName() {
    if (type != null) {
      return type.getTypeName();
    }
    return null;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Ingredient that = (Ingredient) o;
    return quantity == that.quantity
        && Objects.equals(id, that.id)
        && Objects.equals(type, that.type)
        && Objects.equals(owner, that.owner)
        && unit == that.unit;
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, quantity, unit);
  }

  @Override
  public String toString() {
    return "Ingredient{" + "id=" + id + ", quantity=" + quantity
        + ", unit=" + unit + '}';
  }
}

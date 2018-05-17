package hu.elte.recipe.entities;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * The Class IngredientType.
 */
@Entity
@Table(name = "ingredient_types")
public class IngredientType {

  /** The id. */
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column
  private Long id;

  /** The type name. */
  @Column(unique = true, nullable = false)
  private String typeName;

  /** The price per gramms. */
  @Column
  private int pricePerGramms;
    
  /** The currency. */
  @Column
  @Enumerated(EnumType.STRING)
  private Currency currency;

  /**
   * Instantiates a new ingredient type.
   */
  public IngredientType(){}

  /**
   * Instantiates a new ingredient type.
   *
   * @param typeName the type name
   * @param pricePerGramms the price per gramms
   * @param currency the currency
   */
  public IngredientType(String typeName, int pricePerGramms, Currency currency) {
    this.typeName = typeName;
    this.pricePerGramms = pricePerGramms;
    this.currency = currency;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    IngredientType that = (IngredientType) o;
    return pricePerGramms == that.pricePerGramms
        && Objects.equals(id, that.id)
        && Objects.equals(typeName, that.typeName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, typeName, pricePerGramms);
  }

  /**
   * Gets the price per gramms.
   *
   * @return the price per gramms
   */
  public int getPricePerGramms() {
    return pricePerGramms;
  }

  /**
   * Sets the price per gramms.
   *
   * @param pricePergrams the new price per gramms
   */
  public void setPricePerGramms(int pricePergrams) {
    this.pricePerGramms = pricePergrams;
  }

  /**
   * Gets the type name.
   *
   * @return the type name
   */
  public String getTypeName() {
    return typeName;
  }

  /**
   * Sets the type name.
   *
   * @param typename the new type name
   */
  public void setTypeName(String typename) {
    this.typeName = typename;
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
    
}

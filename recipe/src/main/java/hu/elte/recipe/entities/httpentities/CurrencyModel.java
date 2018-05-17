package hu.elte.recipe.entities.httpentities;

import hu.elte.recipe.entities.Currency;

import java.util.List;

/**
 * The Class CurrencyModel.
 */
public class CurrencyModel {

  /** The available currencies. */
  private List<Currency> availableCurrencies;

  /**
   * Instantiates a new currency model.
   *
   * @param availableCurrencies the available currencies
   */
  public CurrencyModel(List<Currency> availableCurrencies) {
    this.availableCurrencies = availableCurrencies;
  }

  /**
   * Gets the available currencies.
   *
   * @return the available currencies
   */
  public List<Currency> getAvailableCurrencies() {
    return availableCurrencies;
  }
}

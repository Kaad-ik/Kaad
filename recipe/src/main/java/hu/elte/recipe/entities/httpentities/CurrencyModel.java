package hu.elte.recipe.entities.httpentities;

import java.util.List;

import hu.elte.recipe.entities.Currency;

public class CurrencyModel {
	
	private List<Currency> availableCurrencies;
	
	public CurrencyModel(List<Currency> availableCurrencies) {
		this.availableCurrencies = availableCurrencies;
	}

	public List<Currency> getAvailableCurrencies() {
		return availableCurrencies;
	}
}

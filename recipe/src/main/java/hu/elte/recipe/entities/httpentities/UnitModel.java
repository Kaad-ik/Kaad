package hu.elte.recipe.entities.httpentities;

import java.util.List;

import hu.elte.recipe.entities.IngredientUnitType;

public class UnitModel {

	private List<IngredientUnitType> availableUnits;

	public UnitModel(List<IngredientUnitType> availableUnits) {
		this.availableUnits = availableUnits;
	}
	
	public List<IngredientUnitType> getAvailableUnits() {
		return availableUnits;
	}
		
}

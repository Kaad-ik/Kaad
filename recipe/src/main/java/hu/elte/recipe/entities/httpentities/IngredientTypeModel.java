package hu.elte.recipe.entities.httpentities;

import java.util.List;

public class IngredientTypeModel {

	private List<String> ingredientTypes;
	
	public IngredientTypeModel(List<String> ingredients) {
		this.ingredientTypes = ingredients;
	}

	public List<String> getIngredientTypes() {
		return ingredientTypes;
	}
	
}

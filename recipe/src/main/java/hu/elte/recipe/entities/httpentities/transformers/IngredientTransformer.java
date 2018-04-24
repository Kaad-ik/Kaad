package hu.elte.recipe.entities.httpentities.transformers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import hu.elte.recipe.entities.Ingredient;
import hu.elte.recipe.entities.httpentities.IngredientHttpEntity;

@Component
public class IngredientTransformer {

	public IngredientHttpEntity transformIngredientToIngredientHttpEntity(Ingredient ingredient) {
		IngredientHttpEntity entity = new IngredientHttpEntity();
		entity.setId(ingredient.getId());
		entity.setQuantity(ingredient.getQuantity());
		entity.setUnit(ingredient.getUnit());
		entity.setPrice(ingredient.getType().getPricePerGramms());
		entity.setName(ingredient.getTypeName());
		entity.setCurrency(ingredient.getType().getCurrency());
		return entity;
	}
	
	public List<IngredientHttpEntity> transformIngredientsToIngredientHttpEntities(List<Ingredient> ingredients) {
		List<IngredientHttpEntity> entities = new ArrayList<>();
		for(Ingredient i: ingredients) {
			entities.add(transformIngredientToIngredientHttpEntity(i));
		}
		return entities;
	}
}

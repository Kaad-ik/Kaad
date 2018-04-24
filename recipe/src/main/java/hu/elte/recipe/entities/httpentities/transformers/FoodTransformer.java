package hu.elte.recipe.entities.httpentities.transformers;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import hu.elte.recipe.entities.Food;
import hu.elte.recipe.entities.httpentities.FoodHttpEntity;
import hu.elte.recipe.entities.httpentities.IngredientHttpEntity;

@Component
public class FoodTransformer {

    public FoodHttpEntity transformFoodToFoddHttpEntity(Food food) {
    	FoodHttpEntity foodHttpEntity = new FoodHttpEntity();
       	foodHttpEntity.setId(food.getId());
        foodHttpEntity.setName(food.getName());
        foodHttpEntity.setImgUrl(food.getImgurl());
        if(food.getIngredients() != null) {
            foodHttpEntity.setIngredients(food.getIngredients().stream().map(IngredientHttpEntity::new).collect(Collectors.toSet()));        	
        }
        return foodHttpEntity;
    }  
    
    public List<FoodHttpEntity> transformFoodsToFoodHttpEntities(List<Food> foods) {
    	List<FoodHttpEntity> foodHttpEntities = new ArrayList<>();
    	for(Food f: foods) {
    		foodHttpEntities.add(transformFoodToFoddHttpEntity(f));
    	}
    	return foodHttpEntities;
    }
}

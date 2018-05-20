package hu.elte.recipe.entities.httpentities.transformers;

import hu.elte.recipe.entities.Food;
import hu.elte.recipe.entities.httpentities.FoodHttpEntity;
import hu.elte.recipe.entities.httpentities.IngredientHttpEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

/**
 * The Class FoodTransformer.
 */
@Component
public class FoodTransformer {

  /**
   * Transform food to fodd http entity.
   *
   * @param food the food
   * @return the food http entity
   */
  public FoodHttpEntity transformFoodToFoddHttpEntity(Food food) {
    FoodHttpEntity foodHttpEntity = new FoodHttpEntity();
    foodHttpEntity.setId(food.getId());
    foodHttpEntity.setName(food.getName());
    foodHttpEntity.setImgUrl(food.getImgUrl());
    if (food.getIngredients() != null) {
      foodHttpEntity.setIngredients(food.getIngredients().stream()
          .map(IngredientHttpEntity::new).collect(Collectors.toSet()));
    }
    return foodHttpEntity;
  }
    
  /**
   * Transform foods to food http entities.
   *
   * @param foods the foods
   * @return the list
   */
  public List<FoodHttpEntity> transformFoodsToFoodHttpEntities(List<Food> foods) {
    List<FoodHttpEntity> foodHttpEntities = new ArrayList<>();
    List<Long> ids = foods.stream().map(f -> f.getId()).distinct().collect(Collectors.toList());
    System.out.println("IDS: " + ids.size());
    List<Food> distinctFoods = new ArrayList<>();
    for(Long id: ids) {
      distinctFoods.add(foods.stream().filter(f -> f.getId().equals(id)).findFirst().get());
    }
    for (Food f: distinctFoods) {
      foodHttpEntities.add(transformFoodToFoddHttpEntity(f));
    }
    return foodHttpEntities;
  }
}

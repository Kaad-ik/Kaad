package hu.elte.recipe.entities.httpentities;

import hu.elte.recipe.entities.Food;

import java.util.Set;
import java.util.stream.Collectors;

public class FoodHttpEntity {
    private String name;
    private Set<IngredientHttpEntity> ingredients;
    private String imgUrl;
    private String recipe;

    public FoodHttpEntity() {
    }

    public FoodHttpEntity(String name, Set<IngredientHttpEntity> ingredients, String imgUrl, String recipe) {
        this.name = name;
        this.ingredients = ingredients;
        this.imgUrl = imgUrl;
        this.recipe = recipe;
    }

    public FoodHttpEntity(Food food) {
        this.name = food.getName();
        this.ingredients = food.getIngredients().stream().map(IngredientHttpEntity::new).collect(Collectors.toSet());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<IngredientHttpEntity> getIngredients() {
        return ingredients;
    }

    public void setIngredients(Set<IngredientHttpEntity> ingredients) {
        this.ingredients = ingredients;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }
    
    public String getRecipe() {
        return recipe;
    }

    public void setRecipe(String recipe) {
        this.recipe = recipe;
    }
}

package hu.elte.recipe.entities.httpentities;

import hu.elte.recipe.entities.Ingredient;

public class IngredientHttpEntity {
    private String type;
    private int quantity;

    public IngredientHttpEntity(Ingredient ingredient) {
        this.quantity = ingredient.getQuantity();
        this.type = ingredient.getTypeName();
    }

    public IngredientHttpEntity(String type, int quantity) {
        this.type = type;
        this.quantity = quantity;
    }

    public IngredientHttpEntity() {
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}

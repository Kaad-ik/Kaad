package hu.elte.recipe.entities.httpentities;

import hu.elte.recipe.entities.Ingredient;

public class IngredientHttpEntity {
	
	private Long id;
    private String type;
    private int quantity;

    public IngredientHttpEntity(Ingredient ingredient) {
    	this.id = ingredient.getId();
        this.quantity = ingredient.getQuantity();
        this.type = ingredient.getTypeName();
    }

    public IngredientHttpEntity(String type, int quantity) {
        this.type = type;
        this.quantity = quantity;
    }

    public IngredientHttpEntity() { }

    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

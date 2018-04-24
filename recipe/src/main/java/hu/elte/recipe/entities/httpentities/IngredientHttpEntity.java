package hu.elte.recipe.entities.httpentities;

import hu.elte.recipe.entities.Ingredient;
import hu.elte.recipe.entities.IngredientUnitType;

public class IngredientHttpEntity {
	
	private Long id;
    private String type;
    private int quantity;
    private IngredientUnitType unit;

    public IngredientHttpEntity(Ingredient ingredient) {
    	this.id = ingredient.getId();
        this.quantity = ingredient.getQuantity();
        this.type = ingredient.getTypeName();
        this.unit = ingredient.getUnit();
    }

    public IngredientHttpEntity(String type, int quantity, IngredientUnitType unit) {
        this.type = type;
        this.quantity = quantity;
        this.unit = unit;
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
    
    public IngredientUnitType getUnit() {
        return unit;
    }

    public void setUnit(IngredientUnitType unit) {
        this.unit = unit;
    }
}

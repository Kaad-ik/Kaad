package hu.elte.recipe.entities.httpentities;

import hu.elte.recipe.entities.Currency;
import hu.elte.recipe.entities.Ingredient;
import hu.elte.recipe.entities.IngredientUnitType;

public class IngredientHttpEntity {
	
	private Long id;
    private String name;
    private int price;
    private int quantity;
    private IngredientUnitType unit;
    private Long userId;
    private Currency currency;

    public IngredientHttpEntity(Ingredient ingredient) {
    	this.id = ingredient.getId();
        this.quantity = ingredient.getQuantity();
        this.name = ingredient.getTypeName();
        this.unit = ingredient.getUnit();
    }

    public IngredientHttpEntity(String type, int quantity, IngredientUnitType unit) {
        this.name = type;
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

	public String getName() {
        return name;
    }

    public void setName(String type) {
        this.name = type;
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

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Currency getCurrency() {
		return currency;
	}

	public void setCurrency(Currency currency) {
		this.currency = currency;
	}
	
    
}

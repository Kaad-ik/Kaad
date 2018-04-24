package hu.elte.recipe.entities.httpentities;

import java.util.Set;

public class FoodHttpEntity {
	
	private Long id;
    private String name;
    private Set<IngredientHttpEntity> ingredients;
    private String imgUrl;
    private String recipe;
    private Set<UserHttpEntity> users;

    public FoodHttpEntity() {}

    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Set<UserHttpEntity> getUsers() {
		return users;
	}

	public void setUsers(Set<UserHttpEntity> users) {
		this.users = users;
	}
    
    
}

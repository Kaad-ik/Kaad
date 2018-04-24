package hu.elte.recipe.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import hu.elte.recipe.entities.httpentities.IngredientHttpEntity;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name = "foods")
public class Food {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    @Column
    private String imgUrl;

    @Column(length = 100000)
    private String recipe;

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, targetEntity = Ingredient.class)
    private List<Ingredient> ingredients;
    
    @JsonIgnore
    @ManyToMany(fetch = FetchType.LAZY, targetEntity = User.class)
    private List<User> users;

    public String getName() {
        return name;
    }

    public Food() { }

    public Food(String name, String imgurl, List<Ingredient> ingredients, String recipe) {
        this.name = name;
        this.imgUrl = imgurl;
        this.ingredients = ingredients;
        this.recipe = recipe;
    }

    public Long getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgurl) {
        this.imgUrl = imgurl;
    }
    
    public String getRecipe() {
        return recipe;
    }

    public void setRecipe(String recipe) {
        this.recipe = recipe;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public List<User> getUsers() {
		return users;
	}

	public void addUsers(User user) {
		if(this.users == null) {
			this.users = new ArrayList<>();
		}
		this.users.add(user);
	}

	public void setId(Long id) {
		this.id = id;
	}

	@JsonProperty("ingredients")
    public List<IngredientHttpEntity> ingredients(){
        if(ingredients != null){
            return ingredients.stream().map(IngredientHttpEntity::new).collect(Collectors.toList());
        }
        return Collections.emptyList();
    }

    public void addIngredient(Ingredient ingredient){
    	if(this.ingredients == null) {
    		this.ingredients = new ArrayList<>();
    	}
        this.ingredients.add(ingredient);
    }

}

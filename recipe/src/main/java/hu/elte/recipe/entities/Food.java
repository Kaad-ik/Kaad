package hu.elte.recipe.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import hu.elte.recipe.entities.httpentities.IngredientHttpEntity;

import javax.persistence.*;
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
    private String imgurl;

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, targetEntity = Ingredient.class)
    private List<Ingredient> ingredients;

    public String getName() {
        return name;
    }

    public Food() {
    }

    public Food(String name, String imgurl, List<Ingredient> ingredients) {
        this.name = name;
        this.imgurl = imgurl;
        this.ingredients = ingredients;
    }

    public Long getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImgurl() {
        return imgurl;
    }

    public void setImgurl(String imgurl) {
        this.imgurl = imgurl;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    @JsonProperty("ingredients")
    public List<IngredientHttpEntity> ingredients(){
        if(ingredients != null){
            return ingredients.stream().map(IngredientHttpEntity::new).collect(Collectors.toList());
        }
        return Collections.emptyList();
    }

}

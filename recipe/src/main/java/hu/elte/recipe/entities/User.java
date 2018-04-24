package hu.elte.recipe.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang3.ObjectUtils;
import hu.elte.recipe.entities.httpentities.IngredientHttpEntity;
import hu.elte.recipe.entities.httpentities.UserHttpEntity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column
    private Long id;

    @Column(unique = true, nullable = false)
    private String userName;
    
    @Column(nullable = false)
    private String fullName;
    
    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column( nullable = false)
    @Enumerated(EnumType.STRING)
    private Role role;

    @Column(nullable = false)
    private Integer money;
    
    @Column(nullable = false)
    private Currency currency;

    @JsonIgnore
    @ManyToMany(fetch = FetchType.EAGER, targetEntity = Food.class)
    private List<Food> cooked;

    @JsonIgnore
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, targetEntity = Ingredient.class)
    private List<Ingredient> ingredients;

    public List<Food> getCooked() {
        return cooked;
    }
    public void addCooked(Food food){
        if (cooked != null) {
            cooked.add(food);
        }
        else{
            cooked = new ArrayList<>();
            cooked.add(food);
        }
    }

    public User() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getFullName() {
		return fullName;
	}
    
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Integer getMoney() {
        return money;
    }

    public void setMoney(Integer money) {
        this.money = money;
    }

    public Currency getCurrency() {
		return currency;
	}
    
	public void setCurrency(Currency currency) {
		this.currency = currency;
	}
	
	public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public void addIngredient(Ingredient ingredient) {
        if(ingredients == null){
            ingredients = new ArrayList<>();
            ingredients.add(ingredient);
        }else{
            this.ingredients.add(ingredient);
        }
    }
    
    public void deleteIngredient(Ingredient ingredient) {
    	this.ingredients.remove(ingredient);
    }

    @JsonProperty("ingredients")
    public List<IngredientHttpEntity> ingredients(){
        if(ingredients != null){
            return ingredients.stream().map(IngredientHttpEntity::new).collect(Collectors.toList());
        }
        return Collections.emptyList();
    }

    public User(UserHttpEntity entity) {
        this.userName = entity.getUserName();
        this.password = entity.getPassword();
    }
  
}

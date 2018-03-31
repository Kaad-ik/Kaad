package hu.elte.recipe.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import groovy.transform.EqualsAndHashCode;

import javax.persistence.*;

@Entity
@EqualsAndHashCode(callSuper = true)
@Table(name = "ingredients")
public class Ingredient {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column
    private Long id;

    @ManyToOne
    @JoinColumn(name = "type_id", updatable = false)
    @JsonIgnore
    private IngredientType type;

    @ManyToOne
    @JoinColumn(name = "owner_id", updatable = false)
    private User owner;

    @Column(nullable = false)
    private int quantity;

    public Ingredient(IngredientType type, User owner, int quantity) {
        this.type = type;
        this.owner = owner;
        this.quantity = quantity;
    }

    public Ingredient() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public IngredientType getType() {
        return type;
    }

    public void setType(IngredientType type) {
        this.type = type;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @JsonProperty("typename")
    public String getTypeName(){
        if(type != null){
            return type.getTypename();
        }
        return null;
    }
}

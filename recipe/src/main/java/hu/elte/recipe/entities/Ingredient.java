package hu.elte.recipe.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

@Entity
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

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private IngredientUnitType unit;

    public Ingredient(IngredientType type, User owner, int quantity, IngredientUnitType unit) {
        this.type = type;
        this.owner = owner;
        this.quantity = quantity;
        this.unit = unit;
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

    public IngredientUnitType getUnit() {
        return unit;
    }

    public void setUnit(IngredientUnitType unit) {
        this.unit = unit;
    }

    @JsonProperty("typename")
    public String getTypeName(){
        if(type != null){
            return type.getTypeName();
        }
        return null;
    }
}

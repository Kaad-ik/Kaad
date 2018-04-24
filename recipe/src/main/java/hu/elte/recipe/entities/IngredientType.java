package hu.elte.recipe.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "ingredient_types")
public class IngredientType {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column
    private Long id;

    @Column(unique = true, nullable = false)
    private String typename;

    @Column
    private int pricePergrams;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IngredientType that = (IngredientType) o;
        return pricePergrams == that.pricePergrams &&
                Objects.equals(id, that.id) &&
                Objects.equals(typename, that.typename);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, typename, pricePergrams);
    }

    public int getPricePergrams() {
        return pricePergrams;
    }

    public void setPricePergrams(int pricePergrams) {
        this.pricePergrams = pricePergrams;
    }

    public String getTypename() {
        return typename;
    }

    public void setTypename(String typename) {
        this.typename = typename;
    }
}

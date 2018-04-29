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
    private String typeName;

    @Column
    private int pricePerGramms;
    
    @Column
    @Enumerated(EnumType.STRING)
    private Currency currency;

    public IngredientType(){}

    public IngredientType(String typeName, int pricePerGramms, Currency currency) {
        this.typeName = typeName;
        this.pricePerGramms = pricePerGramms;
        this.currency = currency;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IngredientType that = (IngredientType) o;
        return pricePerGramms == that.pricePerGramms &&
                Objects.equals(id, that.id) &&
                Objects.equals(typeName, that.typeName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, typeName, pricePerGramms);
    }

    public int getPricePerGramms() {
        return pricePerGramms;
    }

    public void setPricePerGramms(int pricePergrams) {
        this.pricePerGramms = pricePergrams;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typename) {
        this.typeName = typename;
    }

	public Currency getCurrency() {
		return currency;
	}

	public void setCurrency(Currency currency) {
		this.currency = currency;
	}
    
}

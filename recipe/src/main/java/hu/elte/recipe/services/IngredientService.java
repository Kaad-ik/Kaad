package hu.elte.recipe.services;

import hu.elte.recipe.entities.Ingredient;
import hu.elte.recipe.entities.IngredientType;
import hu.elte.recipe.entities.User;
import hu.elte.recipe.entities.httpentities.IngredientHttpEntity;
import hu.elte.recipe.repositories.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

// TODO: Auto-generated Javadoc
/**
 * The Class IngredientService.
 */
@Service
public class IngredientService {
    
    /** The ingredient repository. */
    private IngredientRepository ingredientRepository;
    
    /** The ingredient type service. */
    private IngredientTypeService ingredientTypeService;

    /**
     * Instantiates a new ingredient service.
     *
     * @param ingredientRepository the ingredient repository
     * @param ingredientTypeService the ingredient type service
     */
    @Autowired
    public IngredientService(IngredientRepository ingredientRepository, IngredientTypeService ingredientTypeService) {
        this.ingredientRepository = ingredientRepository;
        this.ingredientTypeService = ingredientTypeService;
    }

    /**
     * Adds the ingredient.
     *
     * @param ingredient the ingredient
     * @return the ingredient
     */
    private Ingredient addIngredient(Ingredient ingredient){
        return ingredientRepository.save(ingredient);
    }

    /**
     * Adds the ingredient by http entity.
     *
     * @param entity the entity
     * @return the ingredient
     */
    public Ingredient addIngredientByHttpEntity(IngredientHttpEntity entity){
        IngredientType type = ingredientTypeService.getByName(entity.getName()).get();
        return addIngredient(new Ingredient(type, null, entity.getQuantity(), entity.getUnit()));
    }
}

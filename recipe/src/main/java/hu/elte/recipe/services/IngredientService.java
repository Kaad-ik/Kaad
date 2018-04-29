package hu.elte.recipe.services;

import hu.elte.recipe.entities.Ingredient;
import hu.elte.recipe.entities.IngredientType;
import hu.elte.recipe.entities.User;
import hu.elte.recipe.entities.httpentities.IngredientHttpEntity;
import hu.elte.recipe.repositories.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IngredientService {
    private IngredientRepository ingredientRepository;
    private IngredientTypeService ingredientTypeService;

    @Autowired
    public IngredientService(IngredientRepository ingredientRepository, IngredientTypeService ingredientTypeService) {
        this.ingredientRepository = ingredientRepository;
        this.ingredientTypeService = ingredientTypeService;
    }

    private Ingredient addIngredient(Ingredient ingredient){
        return ingredientRepository.save(ingredient);
    }

    public Ingredient addIngredientByHttpEntity(IngredientHttpEntity entity){
        IngredientType type = ingredientTypeService.getByName(entity.getName()).get();
        return addIngredient(new Ingredient(type, null, entity.getQuantity(), entity.getUnit()));
    }
}

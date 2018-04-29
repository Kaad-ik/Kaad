package hu.elte.recipe.services;

import hu.elte.recipe.entities.IngredientType;
import hu.elte.recipe.exceptions.DuplicationException;
import hu.elte.recipe.repositories.IngredientTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class IngredientTypeService {
    private IngredientTypeRepository ingredientTypeRepository;

    @Autowired
    public IngredientTypeService(IngredientTypeRepository ingredientTypeRepository) {
        this.ingredientTypeRepository = ingredientTypeRepository;
    }

    public Iterable<IngredientType> getAllIngredientType(){
        return ingredientTypeRepository.findAll();
    }

    public IngredientType addIngredientType(IngredientType ingredientType){
        try{
            return ingredientTypeRepository.save(ingredientType);
        }catch (RuntimeException e){
            throw new DuplicationException("Unique key duplicated");
        }
    }

    public IngredientType updateIngredientType(Long id, IngredientType ingredientType){
        try{
            IngredientType current = ingredientTypeRepository.findOne(id);
            current.setTypeName(ingredientType.getTypeName());
            return ingredientTypeRepository.save(current);
        }catch (RuntimeException e){
            throw new DuplicationException("Unique key duplicated");
        }
    }

    public void deleteIngredientType(Long id){
        ingredientTypeRepository.delete(id);
    }

    public IngredientType findOne(Long id) {
        return ingredientTypeRepository.findOne(id);
    }

    public Optional<IngredientType> getByName(String type) {
        return ingredientTypeRepository.findOneByTypeName(type);
    }
}

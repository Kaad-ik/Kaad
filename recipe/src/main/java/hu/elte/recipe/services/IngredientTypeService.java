package hu.elte.recipe.services;

import hu.elte.recipe.entities.IngredientType;
import hu.elte.recipe.exceptions.DuplicationException;
import hu.elte.recipe.repositories.IngredientTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

// TODO: Auto-generated Javadoc
/**
 * The Class IngredientTypeService.
 */
@Service
@Transactional
public class IngredientTypeService {
    
    /** The ingredient type repository. */
    private IngredientTypeRepository ingredientTypeRepository;

    /**
     * Instantiates a new ingredient type service.
     *
     * @param ingredientTypeRepository the ingredient type repository
     */
    @Autowired
    public IngredientTypeService(IngredientTypeRepository ingredientTypeRepository) {
        this.ingredientTypeRepository = ingredientTypeRepository;
    }

    /**
     * Gets the all ingredient type.
     *
     * @return the all ingredient type
     */
    public Iterable<IngredientType> getAllIngredientType(){
        return ingredientTypeRepository.findAll();
    }

    /**
     * Adds the ingredient type.
     *
     * @param ingredientType the ingredient type
     * @return the ingredient type
     */
    public IngredientType addIngredientType(IngredientType ingredientType){
        try{
            return ingredientTypeRepository.save(ingredientType);
        }catch (DuplicateKeyException e){
            throw new DuplicationException("Unique key duplicated");
        }
    }

    /**
     * Update ingredient type.
     *
     * @param id the id
     * @param ingredientType the ingredient type
     * @return the ingredient type
     */
    public IngredientType updateIngredientType(Long id, IngredientType ingredientType){
        try{
            IngredientType current = ingredientTypeRepository.findOne(id);
            current.setTypeName(ingredientType.getTypeName());
            return ingredientTypeRepository.save(current);
        }catch (DuplicateKeyException e){
            throw new DuplicationException("Unique key duplicated");
        }
    }

    /**
     * Delete ingredient type.
     *
     * @param id the id
     */
    public void deleteIngredientType(Long id){
        ingredientTypeRepository.delete(id);
    }

    /**
     * Find one.
     *
     * @param id the id
     * @return the ingredient type
     */
    public IngredientType findOne(Long id) {
        return ingredientTypeRepository.findOne(id);
    }

    /**
     * Gets the by name.
     *
     * @param type the type
     * @return the by name
     */
    public Optional<IngredientType> getByName(String type) {
        return ingredientTypeRepository.findOneByTypeName(type);
    }
    
    /**
     * Gets the all ingredient type name.
     *
     * @return the all ingredient type name
     */
    public List<String> getAllIngredientTypeName() {
    	List<String> result = new ArrayList<>();
    	for(IngredientType i: getAllIngredientType()) {
    		result.add(i.getTypeName());
    	}
    	return result;
    }
}

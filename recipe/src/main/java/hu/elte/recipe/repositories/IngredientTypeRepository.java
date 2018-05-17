package hu.elte.recipe.repositories;

import hu.elte.recipe.entities.IngredientType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

// TODO: Auto-generated Javadoc
/**
 * The Interface IngredientTypeRepository.
 */
@Repository
public interface IngredientTypeRepository extends CrudRepository<IngredientType, Long>{
    
    /**
     * Find one by type name.
     *
     * @param type the type
     * @return the optional
     */
    Optional<IngredientType> findOneByTypeName(String type);
}

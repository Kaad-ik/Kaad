package hu.elte.recipe.repositories;

import hu.elte.recipe.entities.IngredientType;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * The Interface IngredientTypeRepository.
 */
@Repository
public interface IngredientTypeRepository extends CrudRepository<IngredientType, Long> {
    
  /**
   * Find one by type name.
   *
   * @param type the type
   * @return the optional
   */
  Optional<IngredientType> findOneByTypeName(String type);
}

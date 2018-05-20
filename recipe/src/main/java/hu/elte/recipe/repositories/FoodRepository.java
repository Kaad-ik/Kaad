package hu.elte.recipe.repositories;

import hu.elte.recipe.entities.Food;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * The Interface FoodRepository.
 */
@Repository
public interface FoodRepository extends CrudRepository<Food, Long> {
    
  /**
   * Find by name.
   *
   * @param name the name
   * @return the optional
   */
  Optional<Food> findByName(String name);
}

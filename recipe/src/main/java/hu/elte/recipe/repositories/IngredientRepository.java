package hu.elte.recipe.repositories;

import hu.elte.recipe.entities.Ingredient;
import hu.elte.recipe.entities.IngredientType;
import hu.elte.recipe.entities.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

// TODO: Auto-generated Javadoc
/**
 * The Interface IngredientRepository.
 */
@Repository
public interface IngredientRepository extends CrudRepository<Ingredient, Long> {
    
    /**
     * Find all by owner.
     *
     * @param id the id
     * @return the iterable
     */
    Iterable<Ingredient> findAllByOwner(Long id);

    /**
     * Find by type and owner.
     *
     * @param type the type
     * @param owner the owner
     * @return the iterable
     */
    Iterable<Ingredient> findByTypeAndOwner(IngredientType type, User owner);
}

package hu.elte.recipe.repositories;

import hu.elte.recipe.entities.Ingredient;
import hu.elte.recipe.entities.IngredientType;
import hu.elte.recipe.entities.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by doma on 2017.10.18..
 */

@Repository
public interface IngredientRepository extends CrudRepository<Ingredient, Long> {
    Iterable<Ingredient> findAllByOwner(Long id);

    Iterable<Ingredient> findByTypeAndOwner(IngredientType type, User owner);
}
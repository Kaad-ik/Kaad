package hu.elte.recipe.repositories;

import hu.elte.recipe.entities.IngredientType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Created by doma on 2017.10.18..
 */
@Repository
public interface IngredientTypeRepository extends CrudRepository<IngredientType, Long>{
    Optional<IngredientType> findOneByTypename(String type);
}

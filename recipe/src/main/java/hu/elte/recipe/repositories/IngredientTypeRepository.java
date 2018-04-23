package hu.elte.recipe.repositories;

import hu.elte.recipe.entities.IngredientType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IngredientTypeRepository extends CrudRepository<IngredientType, Long>{
    Optional<IngredientType> findOneByTypename(String type);
}

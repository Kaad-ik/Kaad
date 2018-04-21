package hu.elte.recipe.repositories;

import hu.elte.recipe.entities.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Created by doma on 2017.10.18..
 */

@Repository
public interface UserRepository extends CrudRepository<User, Long>{
    Optional<User> findByUserName(String userName);

    Optional<User> findByUserNameAndPassword(String userName, String password);
}
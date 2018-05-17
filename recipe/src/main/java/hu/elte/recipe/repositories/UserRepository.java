package hu.elte.recipe.repositories;

import hu.elte.recipe.entities.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

// TODO: Auto-generated Javadoc
/**
 * The Interface UserRepository.
 */
@Repository
public interface UserRepository extends CrudRepository<User, Long>{
    
    /**
     * Find by user name.
     *
     * @param userName the user name
     * @return the optional
     */
    Optional<User> findByUserName(String userName);

    /**
     * Find by user name and password.
     *
     * @param userName the user name
     * @param password the password
     * @return the optional
     */
    Optional<User> findByUserNameAndPassword(String userName, String password);
}

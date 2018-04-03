package hu.elte.recipe.services;


import hu.elte.recipe.entities.User;
import hu.elte.recipe.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

/**
 * Created by doma on 2017.10.18..
 */
@SessionScope
@Service
public class UserService {

    private UserRepository userRepository;

    private User actualUser;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    private boolean isValid(User user) {
        return userRepository.findByUsernameAndPassword(user.getUsername(), user.getPassword()).isPresent();
    }

    public boolean logout(){
        if(actualUser == null){
            return false;
        }
        actualUser = null;
        return true;
    }

    public boolean isLoggedIn() {
        return actualUser != null;
    }

    public User getActualUser() {
        return actualUser;
    }

}

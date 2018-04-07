package hu.elte.recipe.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import hu.elte.recipe.entities.User;
import hu.elte.recipe.repositories.UserRepository;
import hu.elte.recipe.entities.Food;
import hu.elte.recipe.entities.Ingredient;
import hu.elte.recipe.entities.Role;
import hu.elte.recipe.entities.httpentities.UserHttpEntity;

import hu.elte.recipe.exceptions.UserNotValidException;
import hu.elte.recipe.exceptions.DuplicationException;

import java.util.List;

@SessionScope
@Service
public class UserService {

    private static final String USERNAME_DUPLICATED_MESSAGE = "The user with that username is already exist.";

    private UserRepository userRepository;

	private User actualUser;

	@Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Iterable<User> getAllUser(){
        return userRepository.findAll();
    }

    public Iterable<User> findAllUser(){
        return userRepository.findAll();
    }

    public User updateUser(Long id, User user){
        User current = userRepository.findOne(id);
        current.setUsername(user.getUsername());
        current.setMoney(user.getMoney());
        current.setIngredients(user.getIngredients());
        current.setPassword(user.getPassword());
        current.setRole(user.getRole());
        try{
            return userRepository.save(current);
        }catch (Exception e){
            throw new DuplicationException(USERNAME_DUPLICATED_MESSAGE);
        }
    }

    public User updateUser(User user){
        actualUser.setUsername(user.getUsername());
        actualUser.setMoney(user.getMoney());
        actualUser.setIngredients(user.getIngredients());
        actualUser.setPassword(user.getPassword());
        actualUser.setRole(user.getRole());
        try{
            return userRepository.save(actualUser);
        }catch (Exception e){
            throw new DuplicationException(USERNAME_DUPLICATED_MESSAGE);
        }
    }

    public void deleteUser(Long id){
        if(!isAdmin(id)){
            userRepository.delete(id);
        }
    }

    private boolean isAdmin(Long id) {
       return userRepository.findOne(id).getRole() == Role.ADMIN;
    }

    public User login(User user) throws UserNotValidException {
        if (isValid(user)) {
            return this.actualUser = userRepository.findByUsername(user.getUsername()).get();
        }
        throw new UserNotValidException();
    }

    public User register(UserHttpEntity entity) {
        User user = new User(entity);
        try{
            user.setRole(Role.USER);
            user.setMoney(0);
            this.actualUser = userRepository.save(user);
            return user;
        }catch (Exception e){
            throw new DuplicationException(USERNAME_DUPLICATED_MESSAGE);
        }
    }

    private boolean isValid(User user) {
        return userRepository.findByUsernameAndPassword(user.getUsername(), user.getPassword()).isPresent();
    }

	public boolean logout() {
		if (actualUser == null) {
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
	
	void cook(Food food) {
       for(Ingredient ingredient : actualUser.getIngredients()){
           if(food.getIngredients().stream().anyMatch(i -> i.getType().equals(ingredient.getType()))){
               int quantity = food.getIngredients().stream().filter(ing -> ing.getType().equals(ingredient.getType()))
                       .findFirst().get().getQuantity();
               ingredient.setQuantity(ingredient.getQuantity()-quantity);
               actualUser.addCooked(food);
           }
       }
       updateUser(getActualUser());
    }

    public User add(User user) {
        try{
            user.setRole(Role.USER);
            return userRepository.save(user);
        }catch (Exception e){
            throw new DuplicationException(USERNAME_DUPLICATED_MESSAGE);
        }
    }

    public void changepassword(String newpassword) {
        actualUser.setPassword(newpassword);
        userRepository.save(actualUser);
    }
}

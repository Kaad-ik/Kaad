package hu.elte.recipe.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import hu.elte.recipe.entities.User;
import hu.elte.recipe.repositories.IngredientRepository;
import hu.elte.recipe.repositories.UserRepository;
import hu.elte.recipe.entities.Currency;
import hu.elte.recipe.entities.Food;
import hu.elte.recipe.entities.Ingredient;
import hu.elte.recipe.entities.Role;
import hu.elte.recipe.entities.httpentities.UserHttpEntity;
import hu.elte.recipe.exceptions.UserNotValidException;
import hu.elte.recipe.exceptions.DuplicationException;

// TODO: Auto-generated Javadoc
/**
 * The Class UserService.
 */
@Service
@Transactional
public class UserService {

    /** The Constant USERNAME_DUPLICATED_MESSAGE. */
    private static final String USERNAME_DUPLICATED_MESSAGE = "The user with that username already exists.";

    /** The user repository. */
    @Autowired private UserRepository userRepository;
    
    /** The ingredient repository. */
    @Autowired private IngredientRepository ingredientRepository;

	/** The actual user. */
	private User actualUser;

	/**
	 * Instantiates a new user service.
	 */
	public UserService() {}

    /**
     * Gets the all user.
     *
     * @return the all user
     */
    public Iterable<User> getAllUser(){
        return userRepository.findAll();
    }

    /**
     * Update user.
     *
     * @param user the user
     * @return the user
     */
    public User updateUser(UserHttpEntity user){
        User current = userRepository.findOne(user.getId());
        current.setUserName(user.getUserName());
        current.setMoney(user.getMoney());
        current.setRole(user.getRole());
        current.setCurrency(user.getCurrency());
        current.setEmail(user.getEmail());
        current.setFullName(user.getFullName());
        try{
        	actualUser = current;
            return userRepository.save(current);
        }catch (DuplicateKeyException e){
            throw new DuplicationException(USERNAME_DUPLICATED_MESSAGE);
        }
    }

    /**
     * Update user.
     *
     * @param user the user
     * @return the user
     */
    public User updateUser(User user){
        actualUser.setUserName(user.getUserName());
        actualUser.setMoney(user.getMoney());
        actualUser.setIngredients(user.getIngredients());
        actualUser.setPassword(user.getPassword());
        actualUser.setRole(user.getRole());
        try{
            return userRepository.save(actualUser);
        }catch (DuplicateKeyException e){
            throw new DuplicationException(USERNAME_DUPLICATED_MESSAGE);
        }
    }

    /**
     * Login.
     *
     * @param user the user
     * @return the user
     * @throws UserNotValidException the user not valid exception
     */
    public User login(User user) throws UserNotValidException {
        if (isValid(user)) {
            return this.actualUser = userRepository.findByUserName(user.getUserName()).get();
        }
        throw new UserNotValidException();
    }

    /**
     * Register.
     *
     * @param entity the entity
     * @return the user
     */
    public User register(UserHttpEntity entity) {
        User user = new User(entity);
        try{
            user.setRole(Role.USER);
            user.setMoney(0);
            user.setCurrency(Currency.HUF);
            user.setFullName(entity.getFullName());
            user.setEmail(entity.getEmail());
            this.actualUser = userRepository.save(user);
            return user;
        }catch (DuplicateKeyException e){
            throw new DuplicationException(USERNAME_DUPLICATED_MESSAGE);
        }
    }

    /**
     * Checks if is valid.
     *
     * @param user the user
     * @return true, if is valid
     */
    private boolean isValid(User user) {
        return userRepository.findByUserNameAndPassword(user.getUserName(), user.getPassword()).isPresent();
    }

	/**
	 * Logout.
	 *
	 * @return true, if successful
	 */
	public boolean logout() {
		if (actualUser == null) {
			return false;
		}
		actualUser = null;
		return true;
	}

	/**
	 * Checks if is logged in.
	 *
	 * @return true, if is logged in
	 */
	public boolean isLoggedIn() {
		return actualUser != null;
	}

	/**
	 * Gets the actual user.
	 *
	 * @return the actual user
	 */
	public User getActualUser() {
		return actualUser;
	}
	
	/**
	 * Cook.
	 *
	 * @param food the food
	 */
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

  /**
   * Delete ingredient.
   *
   * @param id the id
   */
  public void deleteIngredient(Long id) {
    System.out.println("ID IN DELETE: " + id);
    Ingredient ingredient = ingredientRepository.findOne(id);
    System.out.println(ingredient.toString());
    System.out.println(actualUser.toString());
    actualUser.getIngredients().remove(ingredient);
    System.out.println(actualUser.toString());
    ingredientRepository.delete(ingredient);
    userRepository.save(actualUser);
  }
}

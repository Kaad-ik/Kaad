package hu.elte.recipe.services;

import hu.elte.recipe.entities.Ingredient;
import hu.elte.recipe.entities.IngredientType;
import hu.elte.recipe.entities.User;
import hu.elte.recipe.entities.httpentities.IngredientHttpEntity;
import hu.elte.recipe.repositories.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IngredientService {
    private IngredientRepository ingredientRepository;
    private UserService userService;
    private IngredientTypeService ingredientTypeService;

    @Autowired
    public IngredientService(UserService userService, IngredientRepository ingredientRepository, IngredientTypeService ingredientTypeService) {
        this.userService = userService;
        this.ingredientRepository = ingredientRepository;
        this.ingredientTypeService = ingredientTypeService;
    }

    public Iterable<Ingredient> getAllIngredient(){
        return ingredientRepository.findAll();
    }

    public Ingredient addIngredient(Ingredient ingredient){
        return ingredientRepository.save(ingredient);
    }

    Ingredient addIngredientByHttpEntity(IngredientHttpEntity entity){
        IngredientType type = ingredientTypeService.getByName(entity.getType()).get();
        return addIngredient(new Ingredient(type, null, entity.getQuantity(), entity.getUnit()));
    }

    public Iterable<Ingredient> findAllIngredient(){
        return ingredientRepository.findAll();
    }

    private Ingredient updateIngredient(Long id, Ingredient ingredient){
        Ingredient current = ingredientRepository.findOne(id);
        current.setQuantity(ingredient.getQuantity());
        return ingredientRepository.save(ingredient);
    }

    public void deleteIngredient(Long id){
        ingredientRepository.delete(id);
    }

    public Ingredient findOne(Long id) {
        return ingredientRepository.findOne(id);
    }

    public Iterable<Ingredient>  findUsersIndredients(Long id) {
        return ingredientRepository.findAllByOwner(id);
    }

    /* public Ingredient buyIngredient(IngredientHttpEntity entity) {
        User user = userService.getActualUser();
        IngredientType type = ingredientTypeService.getByName(entity.getType()).get();
        user.buySomething(entity.getQuantity() * type.getPricePergrams());
        if(userAlreadyHaveThisType(user,type)){
            return stackIngredient(type,entity,user);
        }

        Ingredient ingredient = new Ingredient(type,user,entity.getQuantity());
        user.addIngredient(ingredient);
        userService.updateUser(user);
        return ingredientRepository.save(ingredient);
    }*/

    private boolean userAlreadyHaveThisType(User user, IngredientType type){
        return user.getIngredients().stream().anyMatch(ing -> ing.getType().equals(type));
    }

    private Ingredient stackIngredient(IngredientType type, IngredientHttpEntity entity, User user){
        List<Ingredient> ingredients = (List<Ingredient>) ingredientRepository.findByTypeAndOwner(type,user);
        Ingredient ingredient = ingredients.stream().findFirst().get();
        ingredient.setQuantity(ingredient.getQuantity()+entity.getQuantity());
        return updateIngredient(ingredient.getId(), ingredient);
    }
}

package hu.elte.recipe.services;

import hu.elte.recipe.entities.Food;
import hu.elte.recipe.entities.Ingredient;
import hu.elte.recipe.entities.httpentities.FoodHttpEntity;
import hu.elte.recipe.entities.httpentities.IngredientHttpEntity;
import hu.elte.recipe.entities.httpentities.transformers.FoodTransformer;
import hu.elte.recipe.exceptions.DuplicationException;
import hu.elte.recipe.exceptions.NoEnoughPropertyException;
import hu.elte.recipe.exceptions.NotFoundException;

import hu.elte.recipe.repositories.FoodRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;

import java.util.Collection;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

// TODO: Auto-generated Javadoc
/**
 * The Class FoodService.
 */
@Service
public class FoodService {
	
    /** The food repository. */
    @Autowired private FoodRepository foodRepository;
    
    /** The ingredient service. */
    @Autowired private IngredientService ingredientService;
    
    /** The ingredient type service. */
    @Autowired private IngredientTypeService ingredientTypeService;
    
    /** The user service. */
    @Autowired private UserService userService;
    
    /** The food transformer. */
    @Autowired private FoodTransformer foodTransformer;

    /**
     * Gets the all food.
     *
     * @return the all food
     */
    public List<FoodHttpEntity> getAllFood(){
        List<Food> foods = Lists.newArrayList(foodRepository.findAll());
        return foodTransformer.transformFoodsToFoodHttpEntities(foods);
    }

    /**
     * Adds the food.
     *
     * @param entity the entity
     * @return the food
     */
    public Food addFood(FoodHttpEntity entity){
        try{
            Food food = new Food(entity.getName(), entity.getImgUrl(), validateIngredients(entity.getIngredients()), entity.getRecipe());
            return foodRepository.save(food);
        }catch (DuplicateKeyException e){
            throw new DuplicationException("Unique key duplicated");
        }
    }

    /**
     * Find one.
     *
     * @param id the id
     * @return the food
     */
    public Food findOne(Long id){
        return foodRepository.findOne(id);
    }

    /**
     * Find all food.
     *
     * @return the iterable
     */
    public Iterable<Food> findAllFood(){
        return foodRepository.findAll();
    }

    /**
     * Update food.
     *
     * @param id the id
     * @param entity the entity
     * @return the food
     */
    public Food updateFood(Long id, FoodHttpEntity entity){
        try{
        Food current = foodRepository.findOne(id);
        current.setName(entity.getName());
        current.setImgUrl(entity.getImgUrl());
        current.setRecipe(entity.getRecipe());
        current.setIngredients(mapHttpEntities(entity.getIngredients()));
            return foodRepository.save(current);
        }catch (DuplicateKeyException e){
            throw new DuplicationException("Unique key duplicated");
        }
    }

    /**
     * Delete food.
     *
     * @param id the id
     */
    public void deleteFood(Long id){
        foodRepository.delete(id);
    }


    /**
     * Gets the foods by ingredient https entities.
     *
     * @param ingredients the ingredients
     * @return the foods by ingredient https entities
     */
    public Iterable<Food> getFoodsByIngredientHttpsEntities(List<IngredientHttpEntity> ingredients){
        return getFoodsByIngredients(mapHttpEntities(ingredients));
    }

    /**
     * Gets the foods by ingredients.
     *
     * @return the foods by ingredients
     */
    public Iterable<Food> getFoodsByIngredients(){
        return getFoodsByIngredients(userService.getActualUser().getIngredients());
    }

    /**
     * Gets the foods by ingredients.
     *
     * @param ingredients the ingredients
     * @return the foods by ingredients
     */
    private Iterable<Food> getFoodsByIngredients(List<Ingredient> ingredients){
        List<Food> allFood = (List<Food>) findAllFood();
        return allFood.stream().filter(findItersectionIn(ingredients)).collect(Collectors.toList());
    }

    /**
     * Find itersection in.
     *
     * @param ingredients the ingredients
     * @return the predicate<? super food>
     */
    private Predicate<? super Food> findItersectionIn(List<Ingredient> ingredients) {
        return food -> food.getIngredients().stream().allMatch(haveTypeWithMoreOrEqualQuantity(ingredients));
    }

    /**
     * Have type with more or equal quantity.
     *
     * @param ingredients the ingredients
     * @return the predicate<? super ingredient>
     */
    private Predicate<? super Ingredient> haveTypeWithMoreOrEqualQuantity(List<Ingredient> ingredients) {
        return foodIngredient -> ingredients.stream()
                .anyMatch(ingredient -> ingredient.getType().equals(foodIngredient.getType())
                                        && ingredient.getQuantity() >= foodIngredient.getQuantity());
    }

    /**
     * Validate ingredients.
     *
     * @param entities the entities
     * @return the list
     */
    private List<Ingredient> validateIngredients(Collection<IngredientHttpEntity> entities){
        List<Ingredient> result = mapHttpEntities(entities);
        if(result.stream().allMatch(ingredient -> ingredientTypeService.getByName(ingredient.getTypeName()).isPresent())){
            return result;
        }
        throw new NotFoundException("Szar!");
    }

    /**
     * Map http entities.
     *
     * @param entities the entities
     * @return the list
     */
    private List<Ingredient> mapHttpEntities(Collection<IngredientHttpEntity> entities){
        return entities.stream()
                .map(ing -> ingredientService.addIngredientByHttpEntity(ing)).collect(Collectors.toList());
    }

    /**
     * Cook.
     *
     * @param name the name
     */
    public void cook(String name){
        cook(foodRepository.findByName(name).get().getId());
    }

    /**
     * Cook.
     *
     * @param id the id
     */
    public void cook(Long id) {
        List<Food> availableFoods = (List<Food>) getFoodsByIngredients();
        Food cookable = findOne(id);

        if(cookable == null){
            throw new NotFoundException("Food with that identifier doesn't exist");
        }

        if(!availableFoods.contains(cookable)){
            throw new NoEnoughPropertyException("No enough ingredients for that food");
        }

        userService.cook(findOne(id));
    }
}

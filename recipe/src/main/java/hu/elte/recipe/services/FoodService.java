package hu.elte.recipe.services;

import hu.elte.recipe.entities.Food;
import hu.elte.recipe.entities.Ingredient;
import hu.elte.recipe.entities.httpentities.FoodHttpEntity;
import hu.elte.recipe.entities.httpentities.IngredientHttpEntity;

import hu.elte.recipe.exceptions.DuplicationException;
import hu.elte.recipe.exceptions.NoEnoughPropertyException;
import hu.elte.recipe.exceptions.NotFoundException;

import hu.elte.recipe.repositories.FoodRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Service
public class FoodService {
    private FoodRepository foodRepository;
    private IngredientService ingredientService;
    private IngredientTypeService ingredientTypeService;
    private UserService userService;

    @Autowired
    public FoodService(FoodRepository foodRepository, IngredientService ingredientService, UserService userService) {
        this.foodRepository = foodRepository;
        this.ingredientService = ingredientService;
        this.userService = userService;
    }

    public Iterable<Food> getAllFood(){
        return foodRepository.findAll();
    }

    public Food addFood(FoodHttpEntity entity){
        try{
            Food food = new Food(entity.getName(), entity.getImgUrl(), validateIngredients(entity.getIngredients()), entity.getRecipe());
            return foodRepository.save(food);
        }catch (Exception e){
            throw new DuplicationException("Unique key duplicated");
        }
    }

    public Food findOne(Long id){
        return foodRepository.findOne(id);
    }

    public Iterable<Food> findAllFood(){
        return foodRepository.findAll();
    }

    public Food updateFood(Long id, FoodHttpEntity entity){
        try{
        Food current = foodRepository.findOne(id);
        current.setName(entity.getName());
        current.setImgurl(entity.getImgUrl());
        current.setRecipe(entity.getRecipe());
        current.setIngredients(mapHttpEntities(entity.getIngredients()));
            return foodRepository.save(current);
        }catch (Exception e){
            throw new DuplicationException("Unique key duplicated");
        }
    }

    public void deleteFood(Long id){
        foodRepository.delete(id);
    }


    public Iterable<Food> getFoodsByIngredientHttpsEntities(List<IngredientHttpEntity> ingredients){
        return getFoodsByIngredients(mapHttpEntities(ingredients));
    }

    public Iterable<Food> getFoodsByIngredients(){
        return getFoodsByIngredients(userService.getActualUser().getIngredients());
    }

    private Iterable<Food> getFoodsByIngredients(List<Ingredient> ingredients){
        List<Food> allFood = (List<Food>) findAllFood();
        return allFood.stream().filter(findItersectionIn(ingredients)).collect(Collectors.toList());
    }

    private Predicate<? super Food> findItersectionIn(List<Ingredient> ingredients) {
        return food -> food.getIngredients().stream().allMatch(haveTypeWithMoreOrEqualQuantity(ingredients));
    }

    private Predicate<? super Ingredient> haveTypeWithMoreOrEqualQuantity(List<Ingredient> ingredients) {
        return foodIngredient -> ingredients.stream()
                .anyMatch(ingredient -> ingredient.getType().equals(foodIngredient.getType())
                                        && ingredient.getQuantity() >= foodIngredient.getQuantity());
    }

    private List<Ingredient> validateIngredients(Collection<IngredientHttpEntity> entities){
        List<Ingredient> result = mapHttpEntities(entities);
        if(result.stream().allMatch(ingredient -> ingredientTypeService.getByName(ingredient.getTypeName()).isPresent())){
            return result;
        }
        throw new NotFoundException("Szar!");
    }

    private List<Ingredient> mapHttpEntities(Collection<IngredientHttpEntity> entities){
        return entities.stream()
                .map(ing -> ingredientService.addIngredientByHttpEntity(ing)).collect(Collectors.toList());
    }

    public void cook(String name){
        cook(foodRepository.findByName(name).get().getId());
    }

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

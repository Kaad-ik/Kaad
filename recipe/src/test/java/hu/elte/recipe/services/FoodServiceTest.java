package hu.elte.recipe.services;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;

import hu.elte.recipe.entities.Food;
import hu.elte.recipe.entities.Ingredient;
import hu.elte.recipe.entities.IngredientType;
import static hu.elte.recipe.entities.IngredientUnitType.DB;
import hu.elte.recipe.entities.User;
import hu.elte.recipe.entities.httpentities.FoodHttpEntity;
import hu.elte.recipe.entities.httpentities.IngredientHttpEntity;
import hu.elte.recipe.entities.httpentities.transformers.FoodTransformer;
import hu.elte.recipe.exceptions.DuplicationException;
import hu.elte.recipe.exceptions.NotFoundException;
import hu.elte.recipe.repositories.FoodRepository;

@RunWith(MockitoJUnitRunner.class)
public class FoodServiceTest {

	private static final User USER = new User();
	private static final IngredientType TYPE_1 = new IngredientType();
	private static final IngredientType TYPE_2 = new IngredientType();
	private static final IngredientType TYPE_3 = new IngredientType();
	private static final IngredientType TYPE_4 = new IngredientType();
	private static final IngredientType TYPE_5 = new IngredientType();
	private static final IngredientType TYPE_6 = new IngredientType();

    private static final List<Ingredient> INGREDIENTS_1 = new ArrayList<>();
    private static final List<Ingredient> INGREDIENTS_2 = new ArrayList<>();    
    
    private static final List<Food> FOODS = new ArrayList<>();
    private static final List<FoodHttpEntity> FOODHTTPENTITIES = new ArrayList<>();
    
    static {
    	INGREDIENTS_1.add(new Ingredient(TYPE_1, USER, 69, DB));
    	INGREDIENTS_1.add(new Ingredient(TYPE_2, USER, 69, DB));
    	INGREDIENTS_1.add(new Ingredient(TYPE_3, USER, 69, DB));
    	FOODS.add(new Food("kaja1", "kaja1.jpg", INGREDIENTS_1, "longdecription1"));
    	
    	INGREDIENTS_2.add(new Ingredient(TYPE_4, USER, 69, DB));
    	INGREDIENTS_2.add(new Ingredient(TYPE_5, USER, 69, DB));
    	INGREDIENTS_2.add(new Ingredient(TYPE_6, USER, 69, DB));
    	FOODS.add(new Food("kaja2", "kaja2.jpg", INGREDIENTS_2, "longdecription2"));
    	
    	FOODHTTPENTITIES.add(getHttpEntity("kaja1", "kaja1.jpg", INGREDIENTS_1));
    	FOODHTTPENTITIES.add(getHttpEntity("kaja1", "kaja1.jpg", INGREDIENTS_1));
    }
    
        private final MocksCollector mocksCollector = new MocksCollector();

    @Mock
    private FoodRepository foodRepositoryMock;
    
    @Mock
    private FoodTransformer foodTransformerMock;
    
    @InjectMocks
    private FoodService foodService;
    
    @Before 
    public void initMocks() {
        MockitoAnnotations.initMocks(this);
    }
    
	@After
    public void tearDown() {
    	verifyNoMoreInteractions(mocksCollector.getMocks());
    }
    
    @Test
    public void shouldReturnAllFoods() {
    	when(foodRepositoryMock.findAll()).thenReturn(FOODS);
    	when(foodTransformerMock.transformFoodsToFoodHttpEntities(FOODS)).thenReturn(FOODHTTPENTITIES);
    	
    	List<FoodHttpEntity> actual = foodService.getAllFood();
    	assertEquals(FOODHTTPENTITIES, actual);
    	
    	verify(foodRepositoryMock).findAll();
    	verify(foodTransformerMock).transformFoodsToFoodHttpEntities(FOODS);
    }
    
  /*  @Test(expected = DuplicationException.class)
    public void shouldThrowDuplicationExceptionWhenSomeErrorOccursOnInsertion() {
    	FoodHttpEntity request = getHttpEntity("kaja1", "kaja1.jpg", INGREDIENTS_1);
        Food food = new Food(request.getName(), request.getImgUrl(), mapHttpEntities(request.getIngredients()), request.getRecipe());

    	when(foodRepositoryMock.save(food)).thenThrow(new Exception());
    	try {
    		foodService.addFood(request);
    	}catch(DuplicationException e) {
    		assertEquals("Unique key duplicated", e.getMessage());
    		verify(foodRepositoryMock).save(food);
    		throw e;
    	}
    }*/
    
    private static FoodHttpEntity getHttpEntity(String name, String imgurl, List<Ingredient> ingredients) {
    	FoodHttpEntity foodHttpEntity = new FoodHttpEntity();
        foodHttpEntity.setName(name);
        foodHttpEntity.setImgUrl(imgurl);
        if(ingredients != null) {
            foodHttpEntity.setIngredients(ingredients.stream().map(IngredientHttpEntity::new).collect(Collectors.toSet()));        	
        }
        return foodHttpEntity;
	}
}

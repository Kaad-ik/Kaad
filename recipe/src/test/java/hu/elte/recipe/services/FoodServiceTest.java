package hu.elte.recipe.services;

import static org.junit.Assert.assertEquals;

import java.util.*;
import java.util.stream.Collectors;

import junit.framework.Assert;
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
import static org.mockito.Mockito.*;

import hu.elte.recipe.entities.User;
import hu.elte.recipe.entities.httpentities.FoodHttpEntity;
import hu.elte.recipe.entities.httpentities.IngredientHttpEntity;
import hu.elte.recipe.entities.httpentities.transformers.FoodTransformer;
import hu.elte.recipe.exceptions.DuplicationException;
import hu.elte.recipe.exceptions.NotFoundException;
import hu.elte.recipe.repositories.FoodRepository;
import org.springframework.dao.DuplicateKeyException;

// TODO: Auto-generated Javadoc
/**
 * The Class FoodServiceTest.
 */
@RunWith(MockitoJUnitRunner.class)
public class FoodServiceTest {

	/** The Constant USER. */
	private static final User USER = new User();
	
	/** The Constant TYPE_1. */
	private static final IngredientType TYPE_1 = new IngredientType();
	
	/** The Constant TYPE_2. */
	private static final IngredientType TYPE_2 = new IngredientType();
	
	/** The Constant TYPE_3. */
	private static final IngredientType TYPE_3 = new IngredientType();
	
	/** The Constant TYPE_4. */
	private static final IngredientType TYPE_4 = new IngredientType();
	
	/** The Constant TYPE_5. */
	private static final IngredientType TYPE_5 = new IngredientType();
	
	/** The Constant TYPE_6. */
	private static final IngredientType TYPE_6 = new IngredientType();

    /** The Constant INGREDIENTS_1. */
    private static final List<Ingredient> INGREDIENTS_1 = new ArrayList<>();
    
    /** The Constant INGREDIENTS_2. */
    private static final List<Ingredient> INGREDIENTS_2 = new ArrayList<>();    

    /** The Constant FOOD_1. */
    private static final Food FOOD_1 = new Food("kaja1", "kaja1.jpg", null, "longdecription1");
    
    /** The Constant FOOD_2. */
    private static final Food FOOD_2 = new Food("kaja2", "kaja2.jpg", null, "longdecription2");

    /** The Constant FOODS. */
    private static final List<Food> FOODS = new ArrayList<>();
    
    /** The Constant FOODHTTPENTITIES. */
    private static final List<FoodHttpEntity> FOODHTTPENTITIES = new ArrayList<>();
	
	/** The Constant ID. */
	private static final Long ID = 1L;

	static {
    	INGREDIENTS_1.add(new Ingredient(TYPE_1, USER, 69, DB));
    	INGREDIENTS_1.add(new Ingredient(TYPE_2, USER, 69, DB));
    	INGREDIENTS_1.add(new Ingredient(TYPE_3, USER, 69, DB));
    	FOOD_1.setIngredients(INGREDIENTS_1);
    	FOODS.add(FOOD_1);
    	
    	INGREDIENTS_2.add(new Ingredient(TYPE_4, USER, 69, DB));
    	INGREDIENTS_2.add(new Ingredient(TYPE_5, USER, 69, DB));
    	INGREDIENTS_2.add(new Ingredient(TYPE_6, USER, 69, DB));
    	FOOD_2.setIngredients(INGREDIENTS_2);
    	FOODS.add(FOOD_2);
    	
    	FOODHTTPENTITIES.add(getHttpEntity("kaja1", "kaja1.jpg", INGREDIENTS_1));
    	FOODHTTPENTITIES.add(getHttpEntity("kaja1", "kaja1.jpg", INGREDIENTS_1));
    }
    
    /** The mocks collector. */
    private final MocksCollector mocksCollector = new MocksCollector();

    /** The food repository mock. */
    @Mock
    private FoodRepository foodRepositoryMock;
    
    /** The food transformer mock. */
    @Mock
    private FoodTransformer foodTransformerMock;

    /** The user service mock. */
    @Mock
	  private UserService userServiceMock;

    @Mock
	  private IngredientService ingredientServiceMock;
    
    /** The food service. */
    @InjectMocks
    private FoodService foodService;
    
    /**
     * Setup.
     */
    @Before 
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }
    
	/**
	 * Tear down.
	 */
	@After
    public void tearDown() {
    	verifyNoMoreInteractions(mocksCollector.getMocks());
    }
    
    /**
     * Should return all foods.
     */
    @Test
    public void shouldReturnAllFoods() {
    	when(foodRepositoryMock.findAll()).thenReturn(FOODS);
    	when(foodTransformerMock.transformFoodsToFoodHttpEntities(FOODS)).thenReturn(FOODHTTPENTITIES);
    	
    	List<FoodHttpEntity> actual = foodService.getAllFood();
    	assertEquals(FOODHTTPENTITIES, actual);
    	
    	verify(foodRepositoryMock).findAll();
    	verify(foodTransformerMock).transformFoodsToFoodHttpEntities(FOODS);
    }

	/**
	 * Should find one food by ID.
	 */
	@Test
	public void shouldFindOneFoodByID(){
		when(foodRepositoryMock.findOne(ID)).thenReturn(FOOD_1);
		Food actual = foodService.findOne(ID);
		Assert.assertEquals(FOOD_1, actual);
		verify(foodRepositoryMock).findOne(ID);
	}

	/**
	 * Should delete food.
	 */
	@Test
	public void shouldDeleteFood(){
		doNothing().when(foodRepositoryMock).delete(ID);
		foodService.deleteFood(ID);
		verify(foodRepositoryMock).delete(ID);
	}

	/*@Test
	public void shouldUpdateExistingFood(){
		when(foodRepositoryMock.findOne(ID)).thenReturn(FOOD_1);
		when(foodRepositoryMock.save(FOOD_1)).thenReturn(FOOD_1);
		when(ingredientServiceMock.addIngredientByHttpEntity(
				new IngredientHttpEntity(new Ingredient(TYPE_1, null, 69, DB))))
				.thenReturn(new Ingredient(TYPE_1, null, 69, DB));
		Food actual = foodService.updateFood(ID,
				getHttpEntity("kaja1", "kaja1.jpg",
						Arrays.asList(new Ingredient(TYPE_1, null, 69, DB))));
		Assert.assertEquals(FOOD_1, actual);
		verify(foodRepositoryMock).findOne(ID);
		verify(foodRepositoryMock).save(FOOD_1);
		verify(ingredientServiceMock).addIngredientByHttpEntity(
				new IngredientHttpEntity(new Ingredient(TYPE_1, null, 69, DB)));
	}

	@Test(expected = DuplicationException.class)
	public void shouldThrowDuplicationExceptionWhenSOmeErrorOccursOnUpdate(){
		when(foodRepositoryMock.findOne(ID)).thenReturn(FOOD_1);
		when(FOOD_1.s)
		when(foodRepositoryMock.save(FOOD_1)).thenThrow(new DuplicateKeyException(""));
		try {
			foodService.updateFood(ID, getHttpEntity("kaja1", "kaja1.jpg", INGREDIENTS_1));
		}catch (DuplicationException e){
			Assert.assertEquals("Unique key duplicated", e.getMessage());
			verify(foodRepositoryMock).findOne(ID);
			verify(foodRepositoryMock).save(FOOD_1);
			throw e;
		}
	}*/

    /**
	 * Gets the http entity.
	 *
	 * @param name the name
	 * @param imgurl the imgurl
	 * @param ingredients the ingredients
	 * @return the http entity
	 */
	private static FoodHttpEntity getHttpEntity(String name, String imgurl, List<Ingredient> ingredients) {
    	FoodHttpEntity foodHttpEntity = new FoodHttpEntity();
        foodHttpEntity.setName(name);
        foodHttpEntity.setImgUrl(imgurl);
        if(ingredients != null) {
            foodHttpEntity.setIngredients(toHttpEntity(ingredients));
        }
        return foodHttpEntity;
	}

	private static Set<IngredientHttpEntity> toHttpEntity(List<Ingredient> ingredients){
    	return ingredients.stream().map(IngredientHttpEntity::new).collect(Collectors.toSet());
	}
}

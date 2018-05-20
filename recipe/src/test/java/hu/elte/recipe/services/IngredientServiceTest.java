package hu.elte.recipe.services;

import hu.elte.recipe.entities.*;
import hu.elte.recipe.entities.httpentities.IngredientHttpEntity;
import hu.elte.recipe.repositories.IngredientRepository;
import jdk.nashorn.internal.ir.annotations.Ignore;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Optional;

import static junit.framework.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

// TODO: Auto-generated Javadoc
/**
 * The Class IngredientServiceTest.
 */
@RunWith(MockitoJUnitRunner.class)
public class IngredientServiceTest {

    /** The Constant TYPE_1. */
    private static final IngredientType TYPE_1 = new IngredientType("cukor",1, Currency.HUF);
    private static final long ID = 1L;
    /** The Constant REQUEST_ENTITY. */
    private static final IngredientHttpEntity REQUEST_ENTITY =
            new IngredientHttpEntity("cukor", 4, IngredientUnitType.CSIPET);
    private static final User USER = new User();
    private static final Ingredient INGREDIENT = new Ingredient(TYPE_1,USER, 4, IngredientUnitType.CSIPET);
    private static final Ingredient INGREDIENT_INC = new Ingredient(TYPE_1,USER, 5, IngredientUnitType.CSIPET);
    private static final Ingredient INGREDIENT_DEC = new Ingredient(TYPE_1,USER, 3, IngredientUnitType.CSIPET);
    static {
        USER.setUserName("usename");
        USER.addIngredient(INGREDIENT);
    }

    /** The mocks collector. */
    private final MocksCollector mocksCollector = new MocksCollector();

    /** The ingredient repository mock. */
    @Mock
    private IngredientRepository ingredientRepositoryMock;

    /** The ingredient type service mock. */
    @Mock
    private IngredientTypeService ingredientTypeServiceMock;

    @Mock
    private UserService userServiceMock;

    /** The ingredient service. */
    @InjectMocks
    private IngredientService ingredientService;

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
    
    @Test
    public void dummy() {}

    /**
     * Should add ingredient by http entity.
     */
    @Test
    public void shouldAddIngredientByHttpEntity() {
       when(ingredientTypeServiceMock.getByName(REQUEST_ENTITY.getName())).thenReturn(Optional.of(TYPE_1));
       when(userServiceMock.getActualUser()).thenReturn(USER);
       when(userServiceMock.updateUser(USER)).thenReturn(USER);
       when(ingredientRepositoryMock.save(INGREDIENT)).thenReturn(INGREDIENT);
       Ingredient actual = ingredientService.addIngredientByHttpEntity(REQUEST_ENTITY);
       assertEquals(INGREDIENT, actual);
       verify(ingredientTypeServiceMock).getByName(REQUEST_ENTITY.getName());
       verify(userServiceMock).getActualUser();
       verify(userServiceMock).updateUser(USER);
       verify(ingredientRepositoryMock).save(INGREDIENT);
    }

    @Test
    public void shouldIncreaseIngredient(){
        when(ingredientRepositoryMock.findOne(ID)).thenReturn(INGREDIENT);
        when(userServiceMock.getActualUser()).thenReturn(USER);
        when(ingredientRepositoryMock.save(INGREDIENT_INC)).thenReturn(INGREDIENT_INC);
        ingredientService.increaseIngredient(ID);
        assertEquals(INGREDIENT_INC, INGREDIENT);
        verify(ingredientRepositoryMock).findOne(ID);
        verify(userServiceMock).getActualUser();
        verify(ingredientRepositoryMock).save(INGREDIENT_INC);
        INGREDIENT.setQuantity(4);
    }


    @Test
    public void shouldDecreaseIngredient(){
        when(ingredientRepositoryMock.findOne(ID)).thenReturn(INGREDIENT);
        when(userServiceMock.getActualUser()).thenReturn(USER);
        when(ingredientRepositoryMock.save(INGREDIENT_DEC)).thenReturn(INGREDIENT_DEC);
        ingredientService.decreaseIngredient(ID);
        assertEquals(INGREDIENT_DEC, INGREDIENT);
        verify(ingredientRepositoryMock).findOne(ID);
        verify(userServiceMock).getActualUser();
        verify(ingredientRepositoryMock).save(INGREDIENT_DEC);
        INGREDIENT.setQuantity(4);
    }
}

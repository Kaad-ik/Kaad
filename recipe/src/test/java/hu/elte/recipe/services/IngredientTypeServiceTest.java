package hu.elte.recipe.services;

import hu.elte.recipe.entities.Currency;
import hu.elte.recipe.entities.Ingredient;
import hu.elte.recipe.entities.IngredientType;
import hu.elte.recipe.exceptions.DuplicationException;
import hu.elte.recipe.repositories.IngredientTypeRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.dao.DuplicateKeyException;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static junit.framework.Assert.assertEquals;
import static org.mockito.Mockito.*;

// TODO: Auto-generated Javadoc
/**
 * The Class IngredientTypeServiceTest.
 */
@RunWith(MockitoJUnitRunner.class)
public class IngredientTypeServiceTest {

    /** The mocks collector. */
    private final MocksCollector mocksCollector = new MocksCollector();

    /** The Constant ID. */
    private static final Long ID = 1L;
    
    /** The Constant TYPE_1. */
    private static final IngredientType TYPE_1 = new IngredientType("cukor",1, Currency.HUF);
    
    /** The Constant TYPE_2. */
    private static final IngredientType TYPE_2 = new IngredientType("sór",2, Currency.HUF);
    
    /** The Constant TYPE_3. */
    private static final IngredientType TYPE_3 = new IngredientType("és minden mi jó",3, Currency.HUF);
    
    /** The Constant INGREDIENT_TYPE_LIST. */
    private static final List<IngredientType> INGREDIENT_TYPE_LIST = Arrays.asList(TYPE_1, TYPE_2, TYPE_3);

    /** The ingredient type repository mock. */
    @Mock
    private IngredientTypeRepository ingredientTypeRepositoryMock;

    /** The ingredient type service. */
    @InjectMocks
    private IngredientTypeService ingredientTypeService;

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
     * Should get all ingredient tpe.
     */
    @Test
    public void shouldGetAllIngredientTpe(){
        when(ingredientTypeRepositoryMock.findAll()).thenReturn(INGREDIENT_TYPE_LIST);
        Iterable<IngredientType> actual = ingredientTypeService.getAllIngredientType();
        assertEquals(INGREDIENT_TYPE_LIST, actual);
        verify(ingredientTypeRepositoryMock).findAll();
    }

    /**
     * Should find one ingredient tpe by ID.
     */
    @Test
    public void shouldFindOneIngredientTpeByID(){
        when(ingredientTypeRepositoryMock.findOne(ID)).thenReturn(TYPE_1);
        IngredientType actal = ingredientTypeService.findOne(ID);
        assertEquals(TYPE_1, actal);
        verify(ingredientTypeRepositoryMock).findOne(ID);
    }

    /**
     * Should find one ingredient tpe by name.
     */
    @Test
    public void shouldFindOneIngredientTpeByName(){
        when(ingredientTypeRepositoryMock.findOneByTypeName("cukor")).thenReturn(Optional.of(TYPE_1));
        Optional<IngredientType> actual = ingredientTypeService.getByName("cukor");
        assertEquals(TYPE_1, actual.get());
        verify(ingredientTypeRepositoryMock).findOneByTypeName("cukor");
    }

    /**
     * Should add ingredient type.
     */
    @Test
    public void shouldAddIngredientType(){
        when(ingredientTypeRepositoryMock.save(TYPE_1)).thenReturn(TYPE_1);
        IngredientType actual = ingredientTypeService.addIngredientType(TYPE_1);
        assertEquals(TYPE_1, actual);
        verify(ingredientTypeRepositoryMock).save(TYPE_1);
    }

    /**
     * Should throw duplication exception when S ome error occurs on insert.
     */
    @Test(expected = DuplicationException.class)
    public void shouldThrowDuplicationExceptionWhenSOmeErrorOccursOnInsert(){
        when(ingredientTypeRepositoryMock.save(TYPE_1)).thenThrow(new DuplicateKeyException(""));
        try{
            ingredientTypeService.addIngredientType(TYPE_1);
        }catch (DuplicationException e){
            assertEquals("Unique key duplicated", e.getMessage());
            verify(ingredientTypeRepositoryMock).save(TYPE_1);
            throw e;
        }
    }

    /**
     * Should update existing ingredient tpe.
     */
    @Test
    public void shouldUpdateExistingIngredientTpe(){
        when(ingredientTypeRepositoryMock.findOne(ID)).thenReturn(TYPE_1);
        when(ingredientTypeRepositoryMock.save(TYPE_1)).thenReturn(TYPE_1);
        IngredientType actual = ingredientTypeService.updateIngredientType(ID, TYPE_1);
        assertEquals(TYPE_1, actual);
        verify(ingredientTypeRepositoryMock).findOne(ID);
        verify(ingredientTypeRepositoryMock).save(TYPE_1);
    }

    /**
     * Should throw duplication exception when S ome error occurs on update.
     */
    @Test(expected = DuplicationException.class)
    public void shouldThrowDuplicationExceptionWhenSOmeErrorOccursOnUpdate(){
        when(ingredientTypeRepositoryMock.findOne(ID)).thenReturn(TYPE_1);
        when(ingredientTypeRepositoryMock.save(TYPE_1)).thenThrow(new DuplicateKeyException(""));
        try {
            ingredientTypeService.updateIngredientType(ID, TYPE_1);
        }catch (DuplicationException e){
            assertEquals("Unique key duplicated", e.getMessage());
            verify(ingredientTypeRepositoryMock).findOne(ID);
            verify(ingredientTypeRepositoryMock).save(TYPE_1);
            throw e;
        }
    }

    /**
     * Should delete ingredient type.
     */
    @Test
    public void shouldDeleteIngredientType(){
        doNothing().when(ingredientTypeRepositoryMock).delete(ID);
        ingredientTypeService.deleteIngredientType(ID);
        verify(ingredientTypeRepositoryMock).delete(ID);
    }
}

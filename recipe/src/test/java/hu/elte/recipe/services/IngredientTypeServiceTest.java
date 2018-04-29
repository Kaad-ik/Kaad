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

@RunWith(MockitoJUnitRunner.class)
public class IngredientTypeServiceTest {

    private final MocksCollector mocksCollector = new MocksCollector();

    private static final Long ID = 1L;
    private static final IngredientType TYPE_1 = new IngredientType("cukor",1, Currency.HUF);
    private static final IngredientType TYPE_2 = new IngredientType("sór",2, Currency.HUF);
    private static final IngredientType TYPE_3 = new IngredientType("és minden mi jó",3, Currency.HUF);
    private static final List<IngredientType> INGREDIENT_TYPE_LIST = Arrays.asList(TYPE_1, TYPE_2, TYPE_3);

    @Mock
    private IngredientTypeRepository ingredientTypeRepositoryMock;

    @InjectMocks
    private IngredientTypeService ingredientTypeService;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @After
    public void tearDown() {
        verifyNoMoreInteractions(mocksCollector.getMocks());
    }

    @Test
    public void shouldGetAllIngredientTpe(){
        when(ingredientTypeRepositoryMock.findAll()).thenReturn(INGREDIENT_TYPE_LIST);
        Iterable<IngredientType> actual = ingredientTypeService.getAllIngredientType();
        assertEquals(INGREDIENT_TYPE_LIST, actual);
        verify(ingredientTypeRepositoryMock).findAll();
    }

    @Test
    public void shouldFindOneIngredientTpeByID(){
        when(ingredientTypeRepositoryMock.findOne(ID)).thenReturn(TYPE_1);
        IngredientType actal = ingredientTypeService.findOne(ID);
        assertEquals(TYPE_1, actal);
        verify(ingredientTypeRepositoryMock).findOne(ID);
    }

    @Test
    public void shouldFindOneIngredientTpeByName(){
        when(ingredientTypeRepositoryMock.findOneByTypeName("cukor")).thenReturn(Optional.of(TYPE_1));
        Optional<IngredientType> actual = ingredientTypeService.getByName("cukor");
        assertEquals(TYPE_1, actual.get());
        verify(ingredientTypeRepositoryMock).findOneByTypeName("cukor");
    }

    @Test
    public void shouldAddIngredientType(){
        when(ingredientTypeRepositoryMock.save(TYPE_1)).thenReturn(TYPE_1);
        IngredientType actual = ingredientTypeService.addIngredientType(TYPE_1);
        assertEquals(TYPE_1, actual);
        verify(ingredientTypeRepositoryMock).save(TYPE_1);
    }

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

    @Test
    public void shouldUpdateExistingIngredientTpe(){
        when(ingredientTypeRepositoryMock.findOne(ID)).thenReturn(TYPE_1);
        when(ingredientTypeRepositoryMock.save(TYPE_1)).thenReturn(TYPE_1);
        IngredientType actual = ingredientTypeService.updateIngredientType(ID, TYPE_1);
        assertEquals(TYPE_1, actual);
        verify(ingredientTypeRepositoryMock).findOne(ID);
        verify(ingredientTypeRepositoryMock).save(TYPE_1);
    }

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

    @Test
    public void shouldDeleteIngredientType(){
        doNothing().when(ingredientTypeRepositoryMock).delete(ID);
        ingredientTypeService.deleteIngredientType(ID);
        verify(ingredientTypeRepositoryMock).delete(ID);
    }
}

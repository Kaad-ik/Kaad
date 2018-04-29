package hu.elte.recipe.services;

import hu.elte.recipe.entities.*;
import hu.elte.recipe.entities.httpentities.IngredientHttpEntity;
import hu.elte.recipe.repositories.IngredientRepository;
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

@RunWith(MockitoJUnitRunner.class)
public class IngredientServiceTest {

    private static final IngredientType TYPE_1 = new IngredientType("cukor",1, Currency.HUF);
    private static final IngredientHttpEntity REQUEST_ENTITY =
            new IngredientHttpEntity("cukor", 4, IngredientUnitType.CSIPET);

    private final MocksCollector mocksCollector = new MocksCollector();

    @Mock
    private IngredientRepository ingredientRepositoryMock;

    @Mock
    private IngredientTypeService ingredientTypeServiceMock;

    @InjectMocks
    private IngredientService ingredientService;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @After
    public void tearDown() {
        verifyNoMoreInteractions(mocksCollector.getMocks());
    }

    @Test
    public void shouldAddIngredientByHttpEntity(){
       Ingredient expected = new Ingredient(TYPE_1,null, 4, IngredientUnitType.CSIPET);
       when(ingredientTypeServiceMock.getByName(REQUEST_ENTITY.getName())).thenReturn(Optional.of(TYPE_1));
       when(ingredientRepositoryMock.save(expected)).thenReturn(expected);
       Ingredient actual = ingredientService.addIngredientByHttpEntity(REQUEST_ENTITY);
       assertEquals(expected, actual);
       verify(ingredientTypeServiceMock).getByName(REQUEST_ENTITY.getName());
       verify(ingredientRepositoryMock).save(expected);
    }
}

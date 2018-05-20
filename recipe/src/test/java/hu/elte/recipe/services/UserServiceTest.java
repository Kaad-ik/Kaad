package hu.elte.recipe.services;

import hu.elte.recipe.entities.*;
import hu.elte.recipe.entities.httpentities.UserHttpEntity;
import hu.elte.recipe.exceptions.DuplicationException;
import hu.elte.recipe.repositories.IngredientRepository;
import hu.elte.recipe.repositories.UserRepository;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.dao.DuplicateKeyException;

import java.util.Arrays;
import java.util.Collections;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

// TODO: Auto-generated Javadoc
/**
 * The Class UserServiceTest.
 */
@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {

    /** The Constant USERNAME_DUPLICATED_MESSAGE. */
    private static final String USERNAME_DUPLICATED_MESSAGE = "The user with that username already exists.";
    
    /** The Constant ID. */
    private static final long ID = 1L;
    
    /** The Constant USERNAME. */
    private static final String USERNAME = "username";
    
    /** The Constant PASSWORD. */
    private static final String PASSWORD = "password";
    
    /** The Constant USER. */
    private static final User USER = new User();
    
    /** The Constant USER_HTTP_ENTITY. */
    private static final UserHttpEntity USER_HTTP_ENTITY = new UserHttpEntity();
    
    /** The Constant TYPE_1. */
    private static final IngredientType TYPE_1 = new IngredientType("cukor",1, Currency.HUF);
    
    /** The Constant INGREDIENT. */
    private static final Ingredient INGREDIENT = new Ingredient(TYPE_1,USER, 4, IngredientUnitType.CSIPET);

    static{
        USER.setUserName(USERNAME);
        USER.setPassword(PASSWORD);
        USER.setRole(Role.USER);
        USER.setMoney(0);
        USER.setCurrency(Currency.HUF);
        USER.addIngredient(INGREDIENT);

        USER_HTTP_ENTITY.setUserName(USERNAME);
        USER_HTTP_ENTITY.setPassword(PASSWORD);
    }

    /** The user service. */
    @InjectMocks
    private UserService userService;

    /** The user repository mock. */
    @Mock
    private UserRepository userRepositoryMock;

    /** The ingredient repository mock. */
    @Mock
    private IngredientRepository ingredientRepositoryMock;

    /** The mocks collector. */
    private final MocksCollector mocksCollector = new MocksCollector();

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
     * Should login.
     */
    @Test
    public void shouldLogin(){
        mockLogin();
        User actual = userService.login(USER);
        assertEquals(USER, actual);
        assertEquals(USER, userService.getActualUser());
        verifyLogin();
    }

    /**
     * Should return all users.
     */
    @Test
    public void shouldReturnAllUsers(){
        when(userRepositoryMock.findAll()).thenReturn(Arrays.asList(USER));
        Iterable<User> actual = userService.getAllUser();
        assertEquals(Arrays.asList(USER), actual);
        verify(userRepositoryMock).findAll();
    }

    /**
     * Should update user.
     */
    @Test
    public void shouldUpdateUser(){
        mockLogin();
        when(userRepositoryMock.save(USER)).thenReturn(USER);
        login();
        User actual = userService.updateUser(USER);
        assertEquals(USER, actual);
        verify(userRepositoryMock).save(USER);
        verifyLogin();
    }

    /**
     * Should throw duplication exception when user duplicated on update.
     */
    @Test(expected = DuplicationException.class)
    public void shouldThrowDuplicationExceptionWhenUserDuplicatedOnUpdate(){
        mockLogin();
        when(userRepositoryMock.save(USER)).thenThrow(new DuplicateKeyException(""));
        login();
        try{
            userService.updateUser(USER);
        }catch (DuplicationException e){
            verify(userRepositoryMock).save(USER);
            verifyLogin();
            throw e;
        }
    }

    /**
     * Should delete ingredients.
     */
    @Test
    public void shouldDeleteIngredients(){
        mockLogin();
        when(ingredientRepositoryMock.findOne(ID)).thenReturn(INGREDIENT);
        when(userRepositoryMock.save(USER)).thenReturn(USER);
        doNothing().when(ingredientRepositoryMock).delete(INGREDIENT);
        login();
        userService.deleteIngredient(ID);
        assertEquals(Collections.emptyList(), USER.getIngredients());
        verify(ingredientRepositoryMock).findOne(ID);
        verify(userRepositoryMock).save(USER);
        verify(ingredientRepositoryMock).delete(INGREDIENT);
        verifyLogin();
    }

    /**
     * Mock login.
     */
    private void mockLogin(){
        when(userRepositoryMock.findByUserNameAndPassword(USERNAME, PASSWORD)).thenReturn(Optional.of(USER));
        when(userRepositoryMock.findByUserName(USERNAME)).thenReturn(Optional.of(USER));
    }

    /**
     * Login.
     */
    private void login(){
        userService.login(USER);
    }

    /**
     * Verify login.
     */
    private void verifyLogin(){
        verify(userRepositoryMock).findByUserNameAndPassword(USERNAME, PASSWORD);
        verify(userRepositoryMock).findByUserName(USERNAME);
    }
}

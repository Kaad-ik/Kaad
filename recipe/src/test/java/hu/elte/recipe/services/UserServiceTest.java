package hu.elte.recipe.services;

import hu.elte.recipe.entities.Currency;
import hu.elte.recipe.entities.Role;
import hu.elte.recipe.entities.User;
import hu.elte.recipe.entities.httpentities.UserHttpEntity;
import hu.elte.recipe.exceptions.DuplicationException;
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
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;
@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {

    private static final String USERNAME_DUPLICATED_MESSAGE = "The user with that username already exists.";
    private static final long ID = 1L;
    private static final String USERNAME = "username";
    private static final String PASSWORD = "password";
    private static final User USER = new User();
    private static final UserHttpEntity USER_HTTP_ENTITY = new UserHttpEntity();
    static{
        USER.setUserName(USERNAME);
        USER.setPassword(PASSWORD);
        USER.setRole(Role.USER);
        USER.setMoney(0);
        USER.setCurrency(Currency.HUF);

        USER_HTTP_ENTITY.setUserName(USERNAME);
        USER_HTTP_ENTITY.setPassword(PASSWORD);
    }

    @InjectMocks
    private UserService userService;

    @Mock
    private UserRepository userRepositoryMock;

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

    @Test
    public void shouldLogin(){
        when(userRepositoryMock.findByUserNameAndPassword(USERNAME, PASSWORD)).thenReturn(Optional.of(USER));
        when(userRepositoryMock.findByUserName(USERNAME)).thenReturn(Optional.of(USER));
        User actual = userService.login(USER);
        assertEquals(USER, actual);
        assertEquals(USER, userService.getActualUser());
        verify(userRepositoryMock).findByUserNameAndPassword(USERNAME, PASSWORD);
        verify(userRepositoryMock).findByUserName(USERNAME);
    }

    @Test
    public void shouldReturnAllUsers(){
        when(userRepositoryMock.findAll()).thenReturn(Arrays.asList(USER));
        Iterable<User> actual = userService.getAllUser();
        assertEquals(Arrays.asList(USER), actual);
        verify(userRepositoryMock).findAll();
    }

    @Test
    public void shouldUpdateUser(){
        when(userRepositoryMock.findByUserNameAndPassword(USERNAME, PASSWORD)).thenReturn(Optional.of(USER));
        when(userRepositoryMock.findByUserName(USERNAME)).thenReturn(Optional.of(USER));
        when(userRepositoryMock.save(USER)).thenReturn(USER);
        userService.login(USER);
        User actual = userService.updateUser(USER);
        assertEquals(USER, actual);
        verify(userRepositoryMock).save(USER);
        verify(userRepositoryMock).findByUserNameAndPassword(USERNAME, PASSWORD);
        verify(userRepositoryMock).findByUserName(USERNAME);
    }

    @Test(expected = DuplicationException.class)
    public void shouldThrowDuplicationExceptionWhenUserDuplicatedOnUpdate(){
        when(userRepositoryMock.findByUserNameAndPassword(USERNAME, PASSWORD)).thenReturn(Optional.of(USER));
        when(userRepositoryMock.findByUserName(USERNAME)).thenReturn(Optional.of(USER));
        when(userRepositoryMock.save(USER)).thenThrow(new DuplicateKeyException(""));
        userService.login(USER);
        try{
            userService.updateUser(USER);
        }catch (DuplicationException e){
            verify(userRepositoryMock).save(USER);
            verify(userRepositoryMock).findByUserNameAndPassword(USERNAME, PASSWORD);
            verify(userRepositoryMock).findByUserName(USERNAME);
            throw e;
        }
    }
}

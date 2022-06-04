package service;

import models.User;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import org.mockito.Mockito;
import repository.UserRepositoryImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;

class UserServiceTest {

    private final UserRepositoryImpl userRepository = Mockito.mock(UserRepositoryImpl.class);
    private final UserService userService = new UserService(userRepository);

    private User getUserAl(){
        return User.builder()
                .companyName("NorthStar")
                .firstName("A")
                .lastName("K")
                .build();
    }

    private User getUserAnn(){
        return User.builder()
                .companyName("NorthStar")
                .firstName("Ann")
                .lastName("Tailor")
                .build();
    }
    private User getUserDian(){
        return User.builder()
                .companyName("NorthStar")
                .firstName("Dian")
                .lastName("Princes")
                .build();
    }

    @Test
    void create_createsUser_whenInputIsCorrect() {
        //given
        //when
        userService.createUser(any());
        //then
        verify(userRepository, times(1)).createUser(any());
    }
    @Test
    void create_throwsException_whenInputIsIncorrect() {
        //given
        //when
        //then
        assertThrows(IllegalStateException.class, ()-> userService.createUser(null));
    }

    @Test
    void readAllUsers_returnUserList_whenIsNotEmpty() {
        //given
        List<User> userList = new ArrayList<>();
        userList.add(getUserAl());
        //when
        when(userRepository.readAllUsers()).thenReturn(userList);
        List<User> userListfromDB = userService.readAllUsers();
        //than
        assertEquals(userList, userListfromDB);
    }

    @Test
    void getById() {
        //given
        Optional<User> user = Optional.of(getUserAnn());
        //when
        when(userRepository.getById(any())).thenReturn(user);
        User result = userService.getById(1);
        //then
        assertEquals(user.get(), result);
    }

    @Test
    void update() {
    }

    @Test
    void removeUser() {
    }
}
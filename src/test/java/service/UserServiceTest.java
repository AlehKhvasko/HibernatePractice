package service;

import models.User;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import org.mockito.Mockito;
import repository.UserRepositoryImpl;

import java.util.ArrayList;
import java.util.List;
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
    void createUser() {
        //given
        //when
        userService.createUser(any());
        //then
        verify(userRepository, times(1)).createUser(any());
    }

    @Test
    void readAllUsers() {
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
    }

    @Test
    void update() {
    }

    @Test
    void removeUser() {
    }
}
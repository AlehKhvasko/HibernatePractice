package repository;

import models.User;

import java.util.List;

public interface UserRepositoryIT {

    void createUser(User user);

    List readAllUsers();

    User getById(Integer id);

    User update(Integer id, User user);

    void removeUser(Integer id);
}

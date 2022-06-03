package repository;

import models.User;

import java.util.List;
import java.util.Optional;

public interface UserRepositoryIT {

    void createUser(User user);

    List<User> readAllUsers();

    Optional<User> getById(Integer id);

    User update(Integer id, User user);

    void removeUser(Integer id);
}

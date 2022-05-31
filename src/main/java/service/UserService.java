package service;

import models.User;
import repository.UserRepositoryIT;
import repository.UserRepositoryImpl;

import java.util.List;
import java.util.Optional;

public class UserService {
    private final UserRepositoryIT repository;

    public UserService(UserRepositoryIT repository){
        this.repository = repository;
    }

    public void createUser(User user) {
        
        //TODO nullable doesnt work on objects?
        Optional.ofNullable(user).orElseThrow(NullPointerException::new);
        repository.createUser(user);
    }

    public List readAllUsers() {
        return repository.readAllUsers();
    }

    public User getById(Integer id) {
        boolean exists = Optional.ofNullable(repository.getById(id)).isEmpty();
        if (!exists){
            throw new IllegalStateException("Such user with id = " + id + "doesn't exist");
        }
        return repository.getById(id);
    }

    public User update(Integer id, User user) {
        boolean exists = Optional.ofNullable(repository.getById(id)).isEmpty();
        if (!exists){
            throw new IllegalStateException("Such user with id = " + id +"doesn't exist");
        }
        return repository.update(id, user);
    }

    public void removeUser(Integer id) {
        boolean exists = Optional.ofNullable(repository.getById(id)).isEmpty();
        if (!exists){
            throw new IllegalStateException("Such user with id = " + id +"doesn't exist");
        }
        repository.removeUser(id);
    }
}

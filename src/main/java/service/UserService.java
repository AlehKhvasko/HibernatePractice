package service;

import models.User;
import repository.UserRepositoryIT;

import java.util.List;

public class UserService {
    private final UserRepositoryIT repository;

    public UserService(UserRepositoryIT repository){
        this.repository = repository;
    }

    public void createUser(User user) {
        repository.createUser(user);
    }

    public List<User> readAllUsers() {
        return repository.readAllUsers();
    }

    public User getById(Integer id) {
        return repository.getById(id)
                .orElseThrow(()-> new IllegalStateException("Such user with id = " + id + "doesn't exist"));
    }

    public User update(Integer id, User updateWith) {
        if (repository.getById(id).isEmpty()){
            throw new IllegalStateException("Such user with id = " + id + "doesn't exist");
        }
        return repository.update(id, updateWith);
    }

    public void removeUser(Integer id) {
        if (repository.getById(id).isEmpty()){
            throw new IllegalStateException("Such user with id = " + id +"doesn't exist");
        }
        repository.removeUser(id);
    }
}

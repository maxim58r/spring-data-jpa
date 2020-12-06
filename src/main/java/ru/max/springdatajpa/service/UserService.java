package ru.max.springdatajpa.service;


import ru.max.springdatajpa.models.User;

import java.util.List;

public interface UserService {
    void saveUser(User user);

    User findById(long id);

    void deleteUser(long id);

    List<User> findAll();

    public List<User> findAllByUsername(String username);

}


package ru.max.springdatajpa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.max.springdatajpa.exeption_handing.NoSuchUserException;
import ru.max.springdatajpa.models.User;
import ru.max.springdatajpa.service.UserService;

import java.util.List;

/**
 * @author Serov Maxim
 */

@RestController
@RequestMapping("/api")
public class REstController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public List<User> showAllUsers() {
        return userService.findAll();
    }

    @GetMapping("/users/{id}")
    public User showUser(@PathVariable long id) {
        User user = userService.findById(id);
        if (user == null) {
            throw new NoSuchUserException("There is no user with id = " + id + " in DataBase");
        }
        return userService.findById(id);
    }

    @PostMapping("/users")
    public User addUser(@RequestBody User user) {
        userService.saveUser(user);
        return user;
    }

    @PutMapping("/users")
    public User updateUser(@RequestBody User user) {
        userService.saveUser(user);
        return user;
    }

    @DeleteMapping("/users/{id}")
    public String deleteUser(@PathVariable long id) {
        User user = userService.findById(id);
        if (user == null) {
            throw new NoSuchUserException("There is no user with id = " + id + " in DataBase");
        }
        userService.deleteUser(id);
        return "User with id = " + id + " was deleted";
    }

    @GetMapping("/users/username/{username}")
    public List<User> addUserByName(@PathVariable String username) {
        List<User> users =  userService.findAllByUsername(username);
        if (users.size() == 0) {
            throw new NoSuchUserException("There is no user with username = " + username + " in DataBase");
        }
        return users;
    }
}
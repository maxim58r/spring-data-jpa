package ru.max.springdatajpa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.max.springdatajpa.dao.UserRepository;
import ru.max.springdatajpa.models.User;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImp implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void saveUser(User user) {
        userRepository.save(user);
    }

    @Override
    public List<User> findAllByUsername(String username) {
       return userRepository.findAllByUsername(username);
    }

    @Override
    public User findById(long id) {
        User user = null;
        Optional<User> usr =  userRepository.findById(id);
        if (usr.isPresent()) {
            user = usr.get();
        }
        return user;
    }

    @Override
    public void deleteUser(long id) {
        userRepository.deleteById(id);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }
}

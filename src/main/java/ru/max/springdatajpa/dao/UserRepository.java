package ru.max.springdatajpa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.max.springdatajpa.models.User;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    public List<User> findAllByUsername(String username);
}

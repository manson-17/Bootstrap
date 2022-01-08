package com.example.bootstrap.service;

import com.example.bootstrap.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    public List<User> getAllUsers();

    public User getUserById(Long id);

    public void save(User user);

    public void update(User user);

    public void delete(Long id);

    public User getUserByName(String name);

    public Optional<User> findUserByID(Long id);

}

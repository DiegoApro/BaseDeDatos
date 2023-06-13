package com.example.BBVA2.Repositories;

import com.example.BBVA2.DoMain.User;

import java.util.Optional;

public interface UserRepository {
    Optional<User> findByNameAndPassword(String name, String pass);

    User create(User user);
}

package com.jayklef.ricetta.service;

import com.jayklef.ricetta.model.User;

import java.util.List;

public interface UserService {
    List<User> findUsersList();

    User saveUser(User user);
}

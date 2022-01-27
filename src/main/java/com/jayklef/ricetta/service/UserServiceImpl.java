package com.jayklef.ricetta.service;

import com.jayklef.ricetta.model.User;
import com.jayklef.ricetta.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> findUsersList() {
        return userRepository.findAll();
    }

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }
}

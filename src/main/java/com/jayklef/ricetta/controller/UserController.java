package com.jayklef.ricetta.controller;

import com.jayklef.ricetta.model.User;
import com.jayklef.ricetta.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/userlist")
    public ResponseEntity<List<User>> getusersList(){
        log.info("Inside getUsersList of UserController");
        List<User> userList = userService.findUsersList();
        return  new ResponseEntity<>(userList, HttpStatus.OK);
    }

    @PostMapping("/newuser")
    public ResponseEntity<User> saveUser(@RequestBody User user){
        log.info("Inside saveUser of UserController");
        User newUser = userService.saveUser(user);
        return new ResponseEntity<>(newUser, HttpStatus.CREATED);
    }
}

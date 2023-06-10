package com.apekking.fullstackbackend.controller;

import com.apekking.fullstackbackend.exception.UserNotFoundException;
import com.apekking.fullstackbackend.model.User;
import com.apekking.fullstackbackend.repository.UserRepository;
import com.apekking.fullstackbackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @PostMapping("/user")
    User newUser(@RequestBody User newUser){
        return userService.addUser(newUser);
    }

    @GetMapping("/users")
    List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @GetMapping("/user/{id}")
    User getUserById(@PathVariable Long id){
        return userService.getUserDetail(id);
    }

    @PutMapping("/user/{id}")
    User updateUser(@RequestBody User newUser,@PathVariable Long id){
        return userService.updateUser(id,newUser);
    }

    @DeleteMapping("/user/{id}")
    String deleteUser(@PathVariable Long id){
        return userService.deleteUser(id);
    }

}

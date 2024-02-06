package com.example.restfulapi.controller;

import com.example.restfulapi.entity.User;
import com.example.restfulapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
public class UserController {

    @Autowired
    private UserService userService;
    @GetMapping({"/getUser/{id}"})
    public ResponseEntity<User> getUser(@PathVariable Long id){
        User user = userService.getUserById(id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
    @PostMapping({"/save"})
    public ResponseEntity<String> createUser(@RequestBody User user){
        String status = userService.createNewUser(user);
        return new ResponseEntity<>(status, HttpStatus.CREATED);
    }

    @DeleteMapping({"/delete/{id}"})
    public ResponseEntity<String> deleteUser(@PathVariable Long id){
        String status = userService.deleteUser(id);
        return new ResponseEntity<>(status, HttpStatus.OK);
    }

    @PutMapping({"/updateUser/{id}"})
    public ResponseEntity<String> updateUserById(@PathVariable Long id , @RequestBody User updateUser){
        String status =  userService.updateUserById(id, updateUser);
        return new ResponseEntity<>(status,HttpStatus.OK);
    }
}
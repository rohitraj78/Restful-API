package com.example.restfulapi.service;

import com.example.restfulapi.entity.User;
import com.example.restfulapi.exception.UserNotFoundException;
import com.example.restfulapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User getUserById(Long id){
       Optional<User> findById  = userRepository.findById(id);
       if (findById.isPresent()){
           return findById.get();
       }
       return null;
    }

    public String createNewUser(User user){
        userRepository.save(user);
        return "User Created Suceessfully";
    }

    public String updateUserById(Long id, User updateUser){
        if (userRepository.existsById(id)){
            updateUser.setId(id);
            userRepository.save(updateUser);
            return "User is updated Successfully";
        } else {
            return "User not Found";
        }
    }

    public String deleteUser(Long id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
            return "Record is deleted successfully";
        } else {
            return "No Record is Found";
        }
    }
}

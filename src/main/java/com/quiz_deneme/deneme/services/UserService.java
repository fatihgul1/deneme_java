package com.quiz_deneme.deneme.services;

import com.quiz_deneme.deneme.entities.User;
import com.quiz_deneme.deneme.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepo userRepo;

    public List<User> getAllUsers() {
        return userRepo.findAll();
    }

    public User saveOneUser(User newUser) {
        return userRepo.save(newUser);
    }

    public User getOneUserById(Long userId) {
        return userRepo.findById(userId).orElse(null);
    }

    public User updateOneUser(Long userId, User newUser) {
        Optional<User> user = userRepo.findById(userId);
        if (user.isPresent()) {
            User foundUser = user.get();
            foundUser.setUser_name(newUser.getUser_name());
            foundUser.setPassword(newUser.getPassword());
            userRepo.save(foundUser);
            return foundUser;
        } else {
            throw new RuntimeException("User not found with id: " + userId);
        }
    }
    public void deleteOneUser(Long userId) {
        userRepo.deleteById(userId);
    }
}

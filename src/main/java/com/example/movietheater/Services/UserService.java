package com.example.movietheater.Services;

import com.example.movietheater.Models.User;
import com.example.movietheater.Repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService implements IUserService{
    @Autowired
    private UserRepo userRepo;

    @Override
    public User newUser(User user) {
        Optional<User> user1 = userRepo.findById(user.getId());
        if (user1.isPresent()){
            return null;
        }
        user1.get().s
    }
}

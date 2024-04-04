package com.example.movietheater.Services;

import com.example.movietheater.Models.User;
import com.example.movietheater.Models.UserCustomDetail;
import com.example.movietheater.Repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UserRepo userRepo;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> allUserByUserName = userRepo.findAllByUserName(username);
        return UserCustomDetail.builder().user(allUserByUserName.get()).build();
    }
}

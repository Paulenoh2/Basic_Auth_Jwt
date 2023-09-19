package com.example.securityJwt.service;

import com.example.securityJwt.entities.User;
import com.example.securityJwt.entities.UserDetailsImp;
import com.example.securityJwt.respositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {



    @Autowired
    private UserRepo repo;
    @Autowired
   private PasswordEncoder passwordEncoder;
    public void createUser(User user) {
     user.setPassword(passwordEncoder.encode(user.getPassword()));
     repo.save(user);
    }

    public void updateUser(User user) {
        repo.save(user);
    }


    public void deleteUserById(Long id) {
        repo.deleteById(id);
    }

    public Optional<User> getUserById(Long id) {
        Optional <User> getById = repo.findById(id);
        return getById;
    }

    public List<User> getAllUsers() {
        List <User> allUsers = repo.findAll();
        return allUsers;
    }


}


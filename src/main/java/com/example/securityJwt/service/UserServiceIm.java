package com.example.securityJwt.service;

import com.example.securityJwt.entities.User;
import com.example.securityJwt.entities.UserDetailsImp;
import com.example.securityJwt.respositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceIm  implements UserDetailsService {

    @Autowired
    private UserRepo repo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<User> user = repo.findUserByUsername(username);

        return user.map(UserDetailsImp::new).orElseThrow(()-> new UsernameNotFoundException("username not found")


        );
    }





}

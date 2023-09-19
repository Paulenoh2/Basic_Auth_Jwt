package com.example.securityJwt.controller;

import com.example.securityJwt.entities.Auth;
import com.example.securityJwt.entities.User;
import com.example.securityJwt.service.JwtService;
import com.example.securityJwt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService service;
    @Autowired
    private JwtService jwtService;
    @Autowired
    private AuthenticationManager authenticationManager;



    @PostMapping("/authenticate")
    public  String authenti(@RequestBody Auth auth) {
        Authentication authentication = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(auth.getPassword(), auth.getUsername()));
        if (authentication.isAuthenticated()) {
            return jwtService.generateToken(auth.getUsername());
        } else {
            throw new UsernameNotFoundException("username not found");
        }
    }

    @PostMapping("/create")
    public String create (@RequestBody User user){
        service.createUser(user);
        return  "create user successfull";

    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public Optional <User> getById(@PathVariable Long id){
        Optional<User> getById = service.getUserById(id);
        return getById;
    }

    @GetMapping("/all")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public List<User> getAll(){
        List<User> getAll = service.getAllUsers();
        return getAll;
    }




}

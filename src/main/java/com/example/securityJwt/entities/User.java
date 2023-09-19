package com.example.securityJwt.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")

public class User {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_name")
    private String username;


    @Column(name = "password")
    private String password;

    @Column(name = "Roles")
    private String roles;





    public String getUsername(){
        return this.username;
    }
    public void setUsername(String username){
        this.username = username;
    }


    public String getPassword(){
        return this.password;
    }
    public void setPassword(String password){
        this.password = password;
    }


    public String getRoles(){
        return this.roles;
    }
    public void setRoles(String roles){
        this.roles = roles;
    }

}

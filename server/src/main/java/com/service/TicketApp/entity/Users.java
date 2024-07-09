package com.service.TicketApp.entity;

import jakarta.persistence.*;

@Entity
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    private String username;//todo make unique
    private String email;//todo make unique
    private String password;
    @Enumerated(EnumType.STRING)
    private UserTypes userType;

    public Users(){}
    public Users(Long userId, String username, String email, String password, UserTypes userType) {
        this.userId = userId;
        this.username = username;
        this.email = email;
        this.password = password;
        this.userType = userType;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserTypes getUserType() {
        return userType;
    }

    public void setUserType(UserTypes userType) {
        this.userType = userType;
    }

    public Long getUserId(){
        return userId;
    }
    public void setUserId(Long id){
        this.userId = userId;
    }
    public String getUsername(){
        return username;
    }
    public void setUsername(String username){
        this.username=username;
    }

}

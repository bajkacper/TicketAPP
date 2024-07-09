package com.service.TicketApp.controllers;

import com.service.TicketApp.entity.Users;
import com.service.TicketApp.services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

//todo add preauthorization
@RestController
@RequestMapping("/admin")
public class AdminController {
    private final AdminService adminService;
    @Autowired
    public AdminController(AdminService adminService){
        this.adminService=adminService;
    }
    @GetMapping("/users")
    public List<Users> getUsers(){
        return adminService.getUserList();
    }
    @GetMapping("/users/{id}")
    public Optional<Users> getUser(@PathVariable Long id){
        return adminService.getUser(id);
    }
    @PutMapping("/users/{id}")
    public Users putUser(@PathVariable Long id, @RequestBody Users userDetails) {
        return adminService.putUser(id, userDetails);
    }

    @PostMapping("/users")
    public Users postUser(@RequestBody Users user) {
        return adminService.postUser(user);
    }

    @DeleteMapping("/users/{id}")
    public void deleteAccount(@PathVariable Long id) {
        adminService.deleteAccount(id);
    }
}

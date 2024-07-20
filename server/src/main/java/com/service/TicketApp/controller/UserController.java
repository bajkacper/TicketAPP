package com.service.TicketApp.controller;

import com.service.TicketApp.entity.Booking;
import com.service.TicketApp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/panel")
public class UserController {
    private final UserService userService;
    @Autowired
    public UserController(UserService userService){this.userService=userService;}
    @GetMapping("/{id}")
    public List<Booking> getUserTickets(@PathVariable Long id){
        return userService.getTickets(id);
    }
}
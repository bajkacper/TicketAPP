package com.service.TicketApp.controller;

import com.itextpdf.text.DocumentException;
import com.service.TicketApp.entity.Booking;
import com.service.TicketApp.entity.Users;
import com.service.TicketApp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.ByteArrayInputStream;
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


    @GetMapping("accinfo/{id}")
    public Users getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @PutMapping("/{id}")
    public Users updateUser(@PathVariable Long id, @RequestBody Users user) {
        return userService.updateUser(id, user);
    }

    @GetMapping("/tickets/{bookingId}/pdf")
    public ResponseEntity<InputStreamResource> generateTicketPdf(@PathVariable Long bookingId) throws DocumentException {
        ByteArrayInputStream bis = userService.generateTicketPdf(bookingId);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "inline; filename=ticket.pdf");

        return ResponseEntity
                .ok()
                .headers(headers)
                .contentType(MediaType.APPLICATION_PDF)
                .body(new InputStreamResource(bis));
    }

}

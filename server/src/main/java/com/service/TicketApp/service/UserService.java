package com.service.TicketApp.service;

import com.service.TicketApp.entity.Booking;
import com.service.TicketApp.entity.Users;
import com.service.TicketApp.repository.BookingRepository;
import com.service.TicketApp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BookingRepository bookingRepository;
    public List<Booking> getTickets(Long id){
        Users user = userRepository.findById(id).orElse(null);
        return bookingRepository.findAllByUser(user);
    }
}

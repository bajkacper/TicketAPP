package com.service.TicketApp.repository;

import com.service.TicketApp.entity.Booking;
import com.service.TicketApp.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
public interface BookingRepository extends JpaRepository<Booking,Long> {
    List<Booking> findAllByUser(Users user);
}

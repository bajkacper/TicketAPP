package com.service.TicketApp.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "RESERVED_SEATS")
public class ReservedSeats {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "bookingId", nullable = false)
    private Booking booking;

    @ManyToOne
    @JoinColumn(name = "seatId", nullable = false)
    private Seats seat;
}

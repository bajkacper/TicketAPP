package com.service.TicketApp.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "SCREENING_ROOM")
public class ScreeningRoom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false, length = 45)
    private String name;

    @Column(name = "no_seats", nullable = false)
    private Integer noSeats;

    @ManyToOne
    @JoinColumn(name = "branchId", nullable = false)
    private Branch branch;
}

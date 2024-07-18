package com.service.TicketApp.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "SEATS")
public class Seats {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "row", nullable = false, length = 45)
    private String row;

    @Column(name = "number", nullable = false)
    private Integer number;

    @ManyToOne
    @JoinColumn(name = "screeningRoomId", nullable = false)
    private ScreeningRoom screeningRoom;
}

package com.service.TicketApp.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "MOVIE")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false, length = 45)
    private String name;

    @Column(name = "length", nullable = false)
    private Integer length;

    @Column(name = "description", nullable = false, length = 255)
    private String description;

    @Column(name = "ageAllowed", nullable = false)
    private Integer ageAllowed;

    @Column(name = "year", nullable = false)
    private Integer year;

    @Column(name = "subtitles", nullable = false)
    private Boolean subtitles;
}

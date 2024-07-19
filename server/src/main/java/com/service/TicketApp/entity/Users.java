package com.service.TicketApp.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "USERS")
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "userName", nullable = false, length = 45)
    private String userName;

    @Column(name = "email", nullable = false, unique = true, length = 45)
    private String email;

    @Column(name = "lastName", nullable = false, length = 45)
    private String lastName;

    @Column(name = "password", nullable = false, length = 45)
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(name = "userType", nullable = false, length = 10)
    private UserTypes userType;

    @Column(name = "activated", nullable = false)
    private Boolean activated = false;

    @Column(name = "verification", nullable = false, length = 45)
    private String verification;
}

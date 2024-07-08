package com.service.TicketApp.entity;

import jakarta.persistence.*;
import java.sql.Timestamp;
import java.util.Set;

@Entity
@Table(name = "Screenings")
public class Screenings {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long screeningId;

    private Timestamp screeningDatetime;

    private String cinemaHall;
    private Integer availableSeats;

    @ManyToOne
    @JoinColumn(name = "movie_id")
    private Movies movie;

    @OneToMany(mappedBy = "screening")
    private Set<Tickets> tickets;

    @OneToMany(mappedBy = "screening")
    private Set<Reservations> reservations;

    public Screenings() {}

    // Gettery i Settery
    public Long getScreeningId() {
        return screeningId;
    }

    public void setScreeningId(Long screeningId) {
        this.screeningId = screeningId;
    }

    public Timestamp getScreeningDatetime() {
        return screeningDatetime;
    }

    public void setScreeningDatetime(Timestamp screeningDatetime) {
        this.screeningDatetime = screeningDatetime;
    }

    public String getCinemaHall() {
        return cinemaHall;
    }

    public void setCinemaHall(String cinemaHall) {
        this.cinemaHall = cinemaHall;
    }

    public Integer getAvailableSeats() {
        return availableSeats;
    }

    public void setAvailableSeats(Integer availableSeats) {
        this.availableSeats = availableSeats;
    }

    public Movies getMovie() {
        return movie;
    }

    public void setMovie(Movies movie) {
        this.movie = movie;
    }

    public Set<Tickets> getTickets() {
        return tickets;
    }

    public void setTickets(Set<Tickets> tickets) {
        this.tickets = tickets;
    }

    public Set<Reservations> getReservations() {
        return reservations;
    }

    public void setReservations(Set<Reservations> reservations) {
        this.reservations = reservations;
    }
}

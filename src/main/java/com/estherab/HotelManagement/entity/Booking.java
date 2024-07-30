package com.estherab.HotelManagement.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "bookings")
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Fecha de check-in es obligatoria")
    private LocalDate checkInDate;
    @Future(message = "La fecha de check-out debe ser posterior a la de check-in")
    private LocalDate checkOutDate;

    @Min(value = 1, message = "El número de adultos debe ser superior o igual a 1")
    private int numOfAdults;
    @Min(value = 0, message = "El número de niños debe ser superior o igual a 0")
    private int numOfChildren;
    private int totalGuests;
    private String confirmationCode;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "room_id")
    private Room room;

    public void calculateTotalGuests() {
        this.totalGuests = this.numOfAdults + this.numOfChildren;
    }

    public void setNumOfAdults() {
        this.numOfAdults = numOfAdults;
        calculateTotalGuests();
    }

    public void setNumOfChildren() {
        this.numOfChildren = numOfChildren;
        calculateTotalGuests();
    }

    @Override
    public String toString() {
        return "Booking{" +
                "id=" + id +
                ", checkInDate=" + checkInDate +
                ", checkOutDate=" + checkOutDate +
                ", numOfAdults=" + numOfAdults +
                ", numOfChildren=" + numOfChildren +
                ", totalGuests=" + totalGuests +
                ", confirmationCode='" + confirmationCode + '\'' +
                '}';
    }
}

package com.estherab.HotelManagement.dto;

import com.estherab.HotelManagement.entity.Room;
import com.estherab.HotelManagement.entity.User;
import jakarta.persistence.*;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public class BookingDTO {
    private Long id;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;
    private int numOfAdults;
    private int numOfChildren;
    private int totalGuests;
    private String confirmationCode;
    private UserDTO user;
    private RoomDTO room;
}

package com.estherab.HotelManagement.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.awt.print.Book;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "rooms")
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String type;
    private BigDecimal price;
    private String photoUrl;
    private String description;
    private List<Booking> bookings = new ArrayList<>();

    @Override
    public String toString() {
        return "Room{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", price=" + price +
                ", photoUrl='" + photoUrl + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}

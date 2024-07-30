package com.estherab.HotelManagement.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Response {
    private int statusCode;
    private String message;
    private String token;
    private String role;
    private String expirationDate;
    private String confirmationCode;
    private UserDTO user;
    private RoomDTO room;
    private BookingDTO booking;
    private List<UserDTO> usersList;
    private List<RoomDTO> roomsList;
    private List<BookingDTO> bookingsList;
}

package com.estherab.HotelManagement.repo;

import com.estherab.HotelManagement.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface RoomRepository extends JpaRepository<Room, Long> {

    @Query("SELECT DISTINCT r.roomType FROM Room r")
    List<String> findDistinctRoomTypes();

    @Query("SELECT r FROM Room r WHERE r.type LIKE %:type% AND r.id NOT IN (SELECT bk.room.id FROM Booking bk WHERE" +
            "(bk.checkInDate <= :checkOutDate) AND (bk.checkOutDate >= :checkInDate))")
    List<Room> getAvailableRoomsByDatesAndTypes(LocalDate checkInDate, LocalDate checkOutDate, String type);

    @Query("SELECT r FROM r WHERE r.id NOT IN (SELECT b.room.id FROM Booking b)")
    List<Room> getAvailableRooms();
}

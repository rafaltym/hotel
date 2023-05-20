package pl.rafalprogramuje.hotel.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import pl.rafalprogramuje.hotel.repository.GuestRepository;

import java.util.*;

@Entity
@Table(name = "tbl_bookings")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date startDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date endDate;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "room_id", referencedColumnName = "id")
    private Room room;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "guest_id", referencedColumnName = "id")
    private Guest guest;

    public void setRoom(Room room) {
        this.room = room;
    }

    public void setGuest(Guest guest) {
                this.guest = guest;



    }

    @Transient
    private Long guestId;
    @Transient
    private Long roomId;


    private boolean paid;

    public Room getRoom() {
        return room;
    }



}

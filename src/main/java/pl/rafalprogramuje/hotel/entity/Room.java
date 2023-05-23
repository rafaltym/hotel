package pl.rafalprogramuje.hotel.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tbl_rooms")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int roomNumber;
    private int numberOfGuests;
    private int price;
    //facilities
    private boolean kitchenette;
    private boolean terrace;
    private boolean airConditioning;

    @OneToMany(mappedBy = "room", cascade = CascadeType.PERSIST)
    private Set<Booking> bookingSet = new HashSet<>();

    @Override
    public String toString() {
        return roomNumber+ "";
    }
}

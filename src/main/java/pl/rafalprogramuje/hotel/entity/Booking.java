package pl.rafalprogramuje.hotel.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

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
    private Date startDate = new Date(System.currentTimeMillis());
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date endDate = new Date(System.currentTimeMillis()+86400000);


    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "room_id", referencedColumnName = "id")
    private Room room;
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "guest_id", referencedColumnName = "id")
    private Guest guest;

    @Transient
    private Long guestId;
    @Transient
    private Long roomId;

    private boolean paid;
    private int price;


    //Total price for booking based on number of booking days
    public void setPrice() {
        int roomPrice = room.getPrice();
        int numberOfDays = (int)((endDate.getTime() - startDate.getTime())/86400000);
        if(numberOfDays == 0) {
            numberOfDays = 1;
        } else if (numberOfDays < 0) {
            numberOfDays = 0;
        }
        this.price = numberOfDays * roomPrice;
    }

}

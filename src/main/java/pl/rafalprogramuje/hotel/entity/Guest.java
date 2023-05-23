package pl.rafalprogramuje.hotel.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tbl_guests")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Guest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String surname;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthDate;
    private String city;
    private String phone;
    private String email;


    @OneToMany(mappedBy = "guest", cascade = CascadeType.PERSIST)
    private Set<Booking> bookingSet = new HashSet<>();

    @Override
    public String toString() {
        return  name + " " +
                surname + "  " +
                birthDate.toString().substring(0,10);
    }
}

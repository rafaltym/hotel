package pl.rafalprogramuje.hotel.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
@Table(name = "tbl_guest")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Guest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String surname;
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private Date birthDate;
    private String city;
    private String phone;
    private String email;

}

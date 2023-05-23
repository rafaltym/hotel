package pl.rafalprogramuje.hotel.service;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.rafalprogramuje.hotel.repository.BookingRepository;
import pl.rafalprogramuje.hotel.repository.GuestRepository;
import pl.rafalprogramuje.hotel.repository.RoomRepository;

@Getter
@Service

public class BookingService {
    @Autowired
    private GuestRepository guestRepository;
    @Autowired
    private RoomRepository roomRepository;
    @Autowired
    private BookingRepository bookingRepository;


}

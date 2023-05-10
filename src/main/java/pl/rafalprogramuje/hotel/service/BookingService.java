package pl.rafalprogramuje.hotel.service;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.rafalprogramuje.hotel.repository.GuestRepository;
import pl.rafalprogramuje.hotel.repository.RoomRepository;

@Getter
@Service
public class BookingService {

    private GuestRepository guestRepository;
    private RoomRepository roomRepository;


}

package pl.rafalprogramuje.hotel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.rafalprogramuje.hotel.entity.Booking;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {



}

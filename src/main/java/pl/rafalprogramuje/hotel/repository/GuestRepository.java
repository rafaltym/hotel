package pl.rafalprogramuje.hotel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.rafalprogramuje.hotel.entity.Guest;

public interface GuestRepository extends JpaRepository<Guest, Long> {
}

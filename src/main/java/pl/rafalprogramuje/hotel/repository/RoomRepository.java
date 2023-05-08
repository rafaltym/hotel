package pl.rafalprogramuje.hotel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.rafalprogramuje.hotel.entity.Room;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long>{
}

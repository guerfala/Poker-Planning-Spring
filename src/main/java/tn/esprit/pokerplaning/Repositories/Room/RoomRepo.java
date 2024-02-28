package tn.esprit.pokerplaning.Repositories.Room;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.pokerplaning.Entities.Room.Room;


@Repository
public interface RoomRepo extends JpaRepository<Room, Long> {
}

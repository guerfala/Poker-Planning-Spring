package tn.esprit.pokerplanning.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.pokerplanning.Entities.Room;

@Repository
public interface RoomRepo extends JpaRepository<Room, Long> {
}

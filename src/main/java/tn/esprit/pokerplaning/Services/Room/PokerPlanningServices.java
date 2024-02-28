package tn.esprit.pokerplaning.Services.Room;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import tn.esprit.pokerplaning.Entities.Room.Room;
import tn.esprit.pokerplaning.Repositories.Room.RoomRepo;


import java.util.List;

@Service
public class PokerPlanningServices {

    @Autowired
    private RoomRepo roomRepo;

    public List<Room> ShowAllRooms()
    {
        List<Room> rooms = roomRepo.findAll();
        return rooms;
    }

    public Room AddRoom(Room room)
    {
        return this.roomRepo.save(room);
    }

    public void DeleteRoom(Long id)
    {
        Room room = roomRepo.findById(id).get();
        this.roomRepo.delete(room);
    }

    public ResponseEntity<Room> GetRoomById(@PathVariable Long id)
    {
        Room room = roomRepo.findById(id).get();
        return ResponseEntity.ok(room);
    }

    public ResponseEntity<Room> UpdateRoom(Long id, Room roomDetails)
    {
        Room room = roomRepo.findById(id).get();

        room.setRoomName(roomDetails.getRoomName());
        room.setStartDate(roomDetails.getStartDate());
        room.setEndDate(roomDetails.getEndDate());
        room.setDescription(roomDetails.getDescription());
        room.setFinalComplexity(roomDetails.getFinalComplexity());
        room.setStatus(roomDetails.getStatus());

        Room updatedRoom = roomRepo.save(room);
        return ResponseEntity.ok(updatedRoom);
    }
}

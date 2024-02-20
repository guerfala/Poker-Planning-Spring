package tn.esprit.pokerplanning.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.pokerplanning.Entities.Room;
import tn.esprit.pokerplanning.Repositories.RoomRepo;

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
}

package tn.esprit.pokerplanning.Controllers;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.pokerplanning.Entities.Room;
import tn.esprit.pokerplanning.Services.PokerPlanningServices;

import java.util.List;

@RestController
@RequestMapping
@AllArgsConstructor
public class RoomController {

    @Autowired
    private PokerPlanningServices pokerPlanningServices;

    // http://localhost:8082/pokerplanning/ShowAllRooms
    @PostMapping("/ShowAllRooms")
    public List<Room> ShowAllRooms(){
        return pokerPlanningServices.ShowAllRooms();
    }

    // http://localhost:8082/pokerplanning/AddRoom
    @PostMapping("/AddRoom")
    public Room AddRoom(@RequestBody Room room){
        return pokerPlanningServices.AddRoom(room);
    }

    // http://localhost:8082/pokerplanning/DeleteRoom
    @PostMapping("/DeleteRoom")
    public void DeleteRoom(@RequestParam Long RoomId){
        pokerPlanningServices.DeleteRoom(RoomId);
    }
}

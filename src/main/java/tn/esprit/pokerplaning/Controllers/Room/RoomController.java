package tn.esprit.pokerplaning.Controllers.Room;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.pokerplaning.Entities.Room.Room;
import tn.esprit.pokerplaning.Services.Room.PokerPlanningServices;


import java.util.List;

@RestController
@RequestMapping("/room")
@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class RoomController {

    @Autowired
    private PokerPlanningServices pokerPlanningServices;

    // http://localhost:8082/pokerplanning/ShowAllRooms
    @GetMapping("/ShowAllRooms")
    public List<Room> ShowAllRooms(){
        return pokerPlanningServices.ShowAllRooms();
    }

    // http://localhost:8082/pokerplanning/AddRoom
    @PostMapping("/AddRoom")
    public Room AddRoom(@RequestBody Room room){
        return pokerPlanningServices.AddRoom(room);
    }

    // http://localhost:8082/pokerplanning/GetRoomById/{RoomId}
    @GetMapping("/GetRoomById/{RoomId}")
    public ResponseEntity<Room> GetRoomById(@PathVariable Long RoomId){
        return pokerPlanningServices.GetRoomById(RoomId);
    }

    // http://localhost:8082/pokerplanning/UpdateRoom/{RoomId}
    @PutMapping("/UpdateRoom/{RoomId}")
    public ResponseEntity<Room> UpdateRoom(@PathVariable Long RoomId, @RequestBody Room room){
        return pokerPlanningServices.UpdateRoom(RoomId, room);
    }

    // http://localhost:8082/pokerplanning/DeleteRoom/{RoomId}
    @DeleteMapping("/DeleteRoom/{RoomId}")
    public void DeleteRoom(@PathVariable Long RoomId){
        this.pokerPlanningServices.DeleteRoom(RoomId);
    }

}

package tn.esprit.pokerplaning.Controllers.Room;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.pokerplaning.Entities.Room.Room;
import tn.esprit.pokerplaning.Entities.Task.Task;
import tn.esprit.pokerplaning.Services.Room.PokerPlanningServices;


import java.util.List;

@RestController
@RequestMapping("/room")
@AllArgsConstructor
@CrossOrigin("http://localhost:4200")
public class RoomController {

    @Autowired
    private PokerPlanningServices pokerPlanningServices;

    @GetMapping("/ShowAllRooms")
    public List<Room> showAllRooms(){
        return pokerPlanningServices.showAllRooms();
    }

    @PostMapping("/AddRoom")
    public Room addRoom(@RequestBody Room room){
        return pokerPlanningServices.addRoom(room);
    }

    @GetMapping("/GetRoomById/{roomId}")
    public ResponseEntity<Room> getRoomById(@PathVariable Long roomId){
        return pokerPlanningServices.getRoomById(roomId);
    }

    @PutMapping("/UpdateRoom/{roomId}")
    public ResponseEntity<Room> updateRoom(@PathVariable Long roomId, @RequestBody Room room){
        return pokerPlanningServices.updateRoom(roomId, room);
    }

    @DeleteMapping("/DeleteRoom/{roomId}")
    public void deleteRoom(@PathVariable Long roomId){
        this.pokerPlanningServices.deleteRoom(roomId);
    }

    @PutMapping("/AffectRoomToTask")
    public void affectRoomToTask(@RequestBody Task[] tasks){
        this.pokerPlanningServices.affectRoomToTask(tasks);
    }

    @GetMapping("/ShowAvailableTasks")
    public List<Task> showAvailableTasks(){
        return pokerPlanningServices.showAvailableTasks();
    }

    @GetMapping("/ShowVotedTasks")
    public List<Task> showVotedTasks(){
        return pokerPlanningServices.showVotedTasks();
    }

    @PutMapping("/AffectTaskToDev")
    public void affectTaskToDev(@RequestBody Task task){
        pokerPlanningServices.affectTaskToDev(task);
    }

    @PutMapping("/DoingTaskDev/{id}")
    public void doingTaskDev(@PathVariable Long id){
        pokerPlanningServices.doingTaskDev(id);
    }

    @PutMapping("/DoneTaskDev/{id}")
    public void doneTaskDev(@RequestBody Task task, @PathVariable Long id){
        pokerPlanningServices.doneTaskDev(task, id);
    }

    @GetMapping("/ShowDevTasks/{userId}")
    public List<Task> showDevTasks(@PathVariable Long userId){
        return pokerPlanningServices.showDevTasks(userId);
    }

}

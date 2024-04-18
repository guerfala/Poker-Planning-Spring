package tn.esprit.pokerplaning.Services.Room;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import tn.esprit.pokerplaning.Entities.Room.Room;
import tn.esprit.pokerplaning.Entities.Task.Status;
import tn.esprit.pokerplaning.Entities.Task.Task;
import tn.esprit.pokerplaning.Entities.User.User;
import tn.esprit.pokerplaning.Repositories.Room.RoomRepo;
import tn.esprit.pokerplaning.Repositories.Task.TaskRepository;
import tn.esprit.pokerplaning.Repositories.User.UserRepository;
import tn.esprit.pokerplaning.Services.Task.TaskServiceImpl;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class PokerPlanningServices {

    @Autowired
    private RoomRepo roomRepo;

    @Autowired
    private TaskRepository taskRepo;

    @Autowired
    private UserRepository userRepo;

    public List<Room> ShowAllRooms()
    {
        List<Room> rooms = roomRepo.findAll();
        return rooms;
    }

    public Room AddRoom(Room room)
    {
        return roomRepo.save(room);
    }

    public void DeleteRoom(Long id)
    {
        Room room = roomRepo.findById(id).get();
        List<Task> tasks = room.getTasksRoom();
        room.setTasksRoom(null);

        for (Task task : tasks) {
            task.setRoomTask(null);
            taskRepo.save(task);
        }

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

    public void AffectRoomToTask(Task[] tasks)
    {
        for (Task task : tasks) {
            // Ensure that the room associated with the task is saved and exists in the database
            Room room = task.getRoomTask();
            if (room != null && room.getRoomId() == null) {
                // If the room is not yet persisted, save it first
                room = roomRepo.save(room);
                // Update the task with the persisted room
                task.setRoomTask(room);
            }
            // Save the task
            taskRepo.save(task);
        }
    }

    public List<Task> ShowAvailableTasks(){
        List<Task> tasks = this.taskRepo.findAllByRoomTaskIsNull();
        return tasks;
    }

    public List<Task> ShowVotedTasks(){
        List<Task> tasks = this.taskRepo.findAllByComplexityNotZero();
        List<Task> taskList = new ArrayList<>();
        for (int i=0; i<tasks.size(); i++)
        {
            if (tasks.get(i).getUser() == null)
                taskList.add(tasks.get(i));
        }
        return taskList;
    }

    @Transactional
    public void AffectTaskToDev(Task task) {
        int MAX_SKILL_RATE = 50;
        int complexity = task.getComplexity();
        User user = null;
        int higherSkillRate = complexity;

        while (user == null && higherSkillRate <= MAX_SKILL_RATE) { // Assuming MAX_SKILL_RATE is the maximum possible skill rate
            user = userRepo.findFirstBySkillRateOrderBySkillRateAsc(higherSkillRate);
            higherSkillRate++;
        }

        if (user == null) {
            // If no user is found with a higher skill rate, assign the task to the highest skilled user
            user = userRepo.findFirstByOrderBySkillRateDesc();
        }

        user.getTasks().add(task);
        task.setUser(user);
        userRepo.save(user);
        taskRepo.save(task);
    }

    public void DoingTaskDev(Task task, Long idTask)
    {
        Task t = this.taskRepo.findById(idTask).get();
        t.setStatus(Status.INPROGRESS);
        this.taskRepo.save(t);
    }

    public void DoneTaskDev(Task task, Long idTask)
    {
        Task t = this.taskRepo.findById(idTask).get();
        t.setStatus(Status.DONE);
        this.taskRepo.save(t);

        User user = t.getUser();

        LocalDate today = LocalDate.now();
        if (task.getEndDate().isAfter(today)) {
            user.setSkillRate(user.getSkillRate() + 1);
            this.userRepo.save(user);
        } else {
            if (user.getSkillRate() > 0)
            {
                user.setSkillRate(user.getSkillRate() - 1);
                this.userRepo.save(user);
            }
        }
    }

    public List<Task> ShowDevTasks(Long userId)
    {
        return this.taskRepo.findAllByUserId(userId);
    }
}

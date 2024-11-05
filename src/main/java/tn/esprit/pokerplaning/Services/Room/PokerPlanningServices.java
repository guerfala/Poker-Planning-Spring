package tn.esprit.pokerplaning.Services.Room;

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


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PokerPlanningServices {

    private final RoomRepo roomRepo;
    private final TaskRepository taskRepo;
    private final UserRepository userRepo;

    public PokerPlanningServices(RoomRepo roomRepo, TaskRepository taskRepo, UserRepository userRepo) {
        this.roomRepo = roomRepo;
        this.taskRepo = taskRepo;
        this.userRepo = userRepo;
    }

    public List<Room> showAllRooms()
    {
        List<Room> rooms = roomRepo.findAll();
        return rooms;
    }

    public Room addRoom(Room room)
    {
        return roomRepo.save(room);
    }

    public void deleteRoom(Long id)
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

    public ResponseEntity<Room> getRoomById(@PathVariable Long id) {
        Room room = roomRepo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Room with ID " + id + " not found"));
        return ResponseEntity.ok(room);
    }

    public ResponseEntity<Room> updateRoom(Long id, Room roomDetails)
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

    public void affectRoomToTask(Task[] tasks)
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

    public List<Task> showAvailableTasks(){
        return this.taskRepo.findAllByRoomTaskIsNull();
    }

    public List<Task> showVotedTasks(){
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
    public void affectTaskToDev(Task task) {
        int maxSkillRate = 50;
        int complexity = task.getComplexity();
        User user = null;
        int higherSkillRate = complexity;

        while (user == null && higherSkillRate <= maxSkillRate) { // Assuming MAX_SKILL_RATE is the maximum possible skill rate
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

    public void doingTaskDev(Long idTask) {
        Optional<Task> optionalTask = this.taskRepo.findById(idTask);

        if (optionalTask.isPresent()) {
            Task t = optionalTask.get();
            t.setStatus(Status.INPROGRESS);
            this.taskRepo.save(t);
        } else {
            // Handle the case where the task was not found, e.g., throw an exception or log an error
            throw new IllegalArgumentException("Task with ID " + idTask + " not found.");
        }
    }

    public void doneTaskDev(Task task, Long idTask) {
        Task t = this.taskRepo.findById(idTask)
                .orElseThrow(() -> new IllegalArgumentException("Task with ID " + idTask + " not found"));

        t.setStatus(Status.DONE);
        this.taskRepo.save(t);

        User user = t.getUser();
        LocalDate today = LocalDate.now();

        if (task.getEndDate().isAfter(today)) {
            user.setSkillRate(user.getSkillRate() + 1);
        } else {
            if (user.getSkillRate() > 0) {
                user.setSkillRate(user.getSkillRate() - 1);
            }
        }

        this.userRepo.save(user);
    }

    public List<Task> showDevTasks(Long userId)
    {
        return this.taskRepo.findAllByUserId(userId);
    }
}

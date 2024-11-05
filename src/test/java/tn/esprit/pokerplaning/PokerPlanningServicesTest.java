package tn.esprit.pokerplaning.Services.Room;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;
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

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class PokerPlanningServicesTest {

    @Mock
    private RoomRepo roomRepo;

    @Mock
    private TaskRepository taskRepo;

    @Mock
    private UserRepository userRepo;

    @InjectMocks
    private PokerPlanningServices pokerPlanningServices;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testShowAllRooms() {
        List<Room> rooms = new ArrayList<>();
        when(roomRepo.findAll()).thenReturn(rooms);

        List<Room> result = pokerPlanningServices.showAllRooms();
        assertEquals(rooms, result);
        verify(roomRepo, times(1)).findAll();
    }

    @Test
    void testAddRoom() {
        Room room = new Room();
        when(roomRepo.save(room)).thenReturn(room);

        Room result = pokerPlanningServices.addRoom(room);
        assertEquals(room, result);
        verify(roomRepo, times(1)).save(room);
    }

    @Test
    void testDeleteRoom() {
        Room room = new Room();
        room.setTasksRoom(new ArrayList<>());
        when(roomRepo.findById(1L)).thenReturn(Optional.of(room));

        pokerPlanningServices.deleteRoom(1L);
        verify(roomRepo, times(1)).delete(room);
    }

    @Test
    void testGetRoomById() {
        Long roomId = 1L;
        Room room = new Room();
        when(roomRepo.findById(roomId)).thenReturn(Optional.of(room));

        ResponseEntity<Room> result = pokerPlanningServices.getRoomById(roomId);
        assertEquals(ResponseEntity.ok(room), result);
        verify(roomRepo, times(1)).findById(roomId);
    }

    @Test
    void testUpdateRoom() {
        Long roomId = 1L;
        Room existingRoom = new Room();
        Room roomDetails = new Room();
        roomDetails.setRoomName("Updated Room");

        when(roomRepo.findById(roomId)).thenReturn(Optional.of(existingRoom));
        when(roomRepo.save(existingRoom)).thenReturn(existingRoom);

        ResponseEntity<Room> result = pokerPlanningServices.updateRoom(roomId, roomDetails);
        assertEquals(ResponseEntity.ok(existingRoom), result);
        assertEquals("Updated Room", existingRoom.getRoomName());
        verify(roomRepo, times(1)).save(existingRoom);
    }

    @Test
    void testAffectRoomToTask() {
        Task task = new Task();
        Room room = new Room();
        task.setRoomTask(room);
        Task[] tasks = {task};

        when(roomRepo.save(room)).thenReturn(room);

        pokerPlanningServices.affectRoomToTask(tasks);
        verify(roomRepo, times(1)).save(room);
        verify(taskRepo, times(1)).save(task);
    }

    @Test
    void testShowAvailableTasks() {
        List<Task> tasks = new ArrayList<>();
        when(taskRepo.findAllByRoomTaskIsNull()).thenReturn(tasks);

        List<Task> result = pokerPlanningServices.showAvailableTasks();
        assertEquals(tasks, result);
        verify(taskRepo, times(1)).findAllByRoomTaskIsNull();
    }

    @Test
    void testShowVotedTasks() {
        Task task1 = new Task();
        task1.setComplexity(5);
        Task task2 = new Task();
        task2.setComplexity(0);
        List<Task> tasks = List.of(task1, task2);

        when(taskRepo.findAllByComplexityNotZero()).thenReturn(tasks);

        List<Task> result = pokerPlanningServices.showVotedTasks();
        assertTrue(result.contains(task1));
        assertFalse(result.contains(task2));
        verify(taskRepo, times(1)).findAllByComplexityNotZero();
    }

    @Test
    void testAffectTaskToDev() {
        Task task = new Task();
        task.setComplexity(10);
        User user = new User();
        when(userRepo.findFirstBySkillRateOrderBySkillRateAsc(10)).thenReturn(user);

        pokerPlanningServices.affectTaskToDev(task);

        assertEquals(user, task.getUser());
        verify(userRepo, times(1)).save(user);
        verify(taskRepo, times(1)).save(task);
    }

    @Test
    void testDoingTaskDev() {
        Long idTask = 1L;
        Task task = new Task();
        when(taskRepo.findById(idTask)).thenReturn(Optional.of(task));

        pokerPlanningServices.doingTaskDev(idTask);

        assertEquals(Status.INPROGRESS, task.getStatus());
        verify(taskRepo, times(1)).save(task);
    }

    @Test
    void testDoneTaskDev() {
        Long idTask = 1L;
        Task task = new Task();
        task.setEndDate(LocalDate.now().plusDays(1));
        User user = new User();
        user.setSkillRate(5);
        task.setUser(user);

        when(taskRepo.findById(idTask)).thenReturn(Optional.of(task));

        pokerPlanningServices.doneTaskDev(task, idTask);

        assertEquals(Status.DONE, task.getStatus());
        assertEquals(6, user.getSkillRate());  // Skill rate should increase
        verify(taskRepo, times(1)).save(task);
        verify(userRepo, times(1)).save(user);
    }

    @Test
    void testShowDevTasks() {
        Long userId = 1L;
        List<Task> tasks = new ArrayList<>();
        when(taskRepo.findAllByUserId(userId)).thenReturn(tasks);

        List<Task> result = pokerPlanningServices.showDevTasks(userId);
        assertEquals(tasks, result);
        verify(taskRepo, times(1)).findAllByUserId(userId);
    }
}

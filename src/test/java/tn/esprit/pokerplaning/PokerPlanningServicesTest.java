package tn.esprit.pokerplaning;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;
import tn.esprit.pokerplaning.Entities.Room.Room;
import tn.esprit.pokerplaning.Entities.Task.Task;
import tn.esprit.pokerplaning.Repositories.Room.RoomRepo;
import tn.esprit.pokerplaning.Repositories.Task.TaskRepository;
import tn.esprit.pokerplaning.Repositories.User.UserRepository;
import tn.esprit.pokerplaning.Services.Room.PokerPlanningServices;

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
        Room room = new Room();
        when(roomRepo.findById(1L)).thenReturn(Optional.of(room));

        ResponseEntity<Room> result = pokerPlanningServices.getRoomById(1L);
        assertEquals(ResponseEntity.ok(room), result);
        verify(roomRepo, times(1)).findById(1L);
    }

    @Test
    void testUpdateRoom() {
        Room existingRoom = new Room();
        Room roomDetails = new Room();
        roomDetails.setRoomName("Updated Room");

        when(roomRepo.findById(1L)).thenReturn(Optional.of(existingRoom));
        when(roomRepo.save(existingRoom)).thenReturn(existingRoom);

        ResponseEntity<Room> result = pokerPlanningServices.updateRoom(1L, roomDetails);
        assertEquals(ResponseEntity.ok(existingRoom), result);
        assertEquals("Updated Room", existingRoom.getRoomName());
        verify(roomRepo, times(1)).save(existingRoom);
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
    void testAffectRoomToTask() {
        Task task = new Task();
        Room room = new Room();
        task.setRoomTask(room);

        Task[] tasks = { task };

        pokerPlanningServices.affectRoomToTask(tasks);

        verify(roomRepo, times(1)).save(room);
        verify(taskRepo, times(1)).save(task);
    }

    // Add more test methods here to cover other service methods as needed

}

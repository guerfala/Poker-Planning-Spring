package tn.esprit.pokerplanning.Controllers;

import lombok.AllArgsConstructor;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.pokerplanning.Entities.Task;
import tn.esprit.pokerplanning.Services.ITaskService;


import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/tasks")
@CrossOrigin("http://localhost:4200")
public class TaskController {

    ITaskService taskService;



    @GetMapping("/getAllTasks")
    public ResponseEntity<List<Task>> getAllTasks() {
        List<Task> listTasks = taskService.getAllTask();
        return ResponseEntity.ok(listTasks);
    }


    @GetMapping("/{taskId}")
    public Task getTaskById(@PathVariable("taskId") Long taskId) {
        Task task = taskService.getTaskById(taskId);
        return task;
    }



    @PutMapping("/updateTask/{taskId}")
    public Task updateTask(@PathVariable("taskId") Long taskId, @RequestBody Task taskDetails) {
        return taskService.updateTask(taskId, taskDetails);
    }


    @DeleteMapping("/deleteTask/{taskId}")
    public ResponseEntity<?> deleteTask(@PathVariable("taskId") Long taskId) {
        taskService.deleteTask(taskId);
        return ResponseEntity.ok().build();
    }

}

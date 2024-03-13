package tn.esprit.pokerplanning.Controllers;

import lombok.AllArgsConstructor;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.pokerplanning.Dto.TaskDto;
import tn.esprit.pokerplanning.Entities.Task;
import tn.esprit.pokerplanning.Services.ITaskService;


import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/tasks")
@CrossOrigin("**")
public class TaskController {

    ITaskService taskService;



    @GetMapping("/getAllTasks")
    public List<Task> getAllTask(){
        return taskService.getAllTask();
    }


    @GetMapping("/{taskId}")
    public Task getTaskById(@PathVariable("taskId") Long taskId) {
        Task task = taskService.getTaskById(taskId);
        return task;
    }



    @PutMapping("/updates/{taskId}")
    public ResponseEntity<?> updateTask(@PathVariable("taskId") Long taskId, @RequestBody TaskDto taskDetails) {
        Task updatedTask = taskService.updateTask(taskId, taskDetails);
        return ResponseEntity.ok(true);
    }


    @DeleteMapping("/{taskId}")
    public ResponseEntity<?> deleteTask(@PathVariable("taskId") Long taskId) {
        taskService.deleteTask(taskId);
        return ResponseEntity.ok().build();
    }



}

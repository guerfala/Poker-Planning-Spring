package tn.esprit.pokerplanning.Services;

import jakarta.transaction.Transactional;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import tn.esprit.pokerplanning.Entities.Task;
import tn.esprit.pokerplanning.Repositories.TaskRepository;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE)

public class TaskServiceImpl implements ITaskService {

   TaskRepository taskRepository;

  /* public List<Task> getAllTasks() {
      return TaskRepository.FindAll();
   }*/


   @Override
   public Task getTaskById(Long idTask) {

      return taskRepository.findById(idTask).get();
   }


   public List<Task> getAllTask()
   {
      List<Task> tasks = taskRepository.findAll();
      return tasks;
   }



   public Task updateTask(Long id, Task taskDetails) {
      Task task = getTaskById(id);
      task.setTaskName(taskDetails.getTaskName());
      task.setDescription(taskDetails.getDescription());
      task.setStartDate(taskDetails.getStartDate());
      task.setEndDate(taskDetails.getEndDate());
      task.setStatus(taskDetails.getStatus());
      task.setComplexity(taskDetails.getComplexity());
      return taskRepository.save(task);
   }

   public void deleteTask(Long taskId) {
      taskRepository.deleteById(taskId);
   }



}



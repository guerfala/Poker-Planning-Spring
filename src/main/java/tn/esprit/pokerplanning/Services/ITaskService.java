package tn.esprit.pokerplanning.Services;

import org.springframework.stereotype.Service;
import tn.esprit.pokerplanning.Dto.TaskDto;
import tn.esprit.pokerplanning.Entities.Task;

import java.util.List;


public interface ITaskService {

        public Task getTaskById(Long idTask);

        public  List <Task> getAllTask();
        Task updateTask(Long taskId, TaskDto taskDetails);
        void deleteTask(Long taskId);



}

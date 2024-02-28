package tn.esprit.pokerplaning.Services.Task;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import tn.esprit.pokerplaning.Entities.Task.Sprint;
import tn.esprit.pokerplaning.Entities.Task.Task;


import tn.esprit.pokerplaning.Repositories.Task.SprintRepository;
import tn.esprit.pokerplaning.Repositories.Task.TaskRepository;


import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SprintServiceImpl  {

   SprintRepository sprintRepository;
   TaskRepository taskRepository;
  /* public List<Sprint> getAllSprints() {
      return SprintRepository.FindAll();
   }*/



   public Sprint getSprintById(Long sprintId) {

      return sprintRepository.findById(sprintId).get();
   }


   public Sprint addSprint(Sprint c) {
      return sprintRepository.save(c);
   }

   public List <Sprint> getAllSprint() {
       List<Sprint> listT = sprintRepository.findAll();
       for (Sprint t: listT) {
          log.info("sprint :" + t);
       }
       return listT;
   }



   public Sprint updateSprint(Long id, Sprint sprintDetails) {
      Sprint sprint = getSprintById(id);
      sprint.setSprintName(sprintDetails.getSprintName());
      sprint.setStartDate(sprintDetails.getStartDate());
      sprint.setEndDate(sprintDetails.getEndDate());
      return sprintRepository.save(sprint);
   }

   public void deleteSprint(Long sprintId) {
      sprintRepository.deleteById(sprintId);
   }


   public void assignTaskToSprint(Long idTask, Long sprintId) {
      Task task = taskRepository.findById(idTask).get();
      Sprint sprint = sprintRepository.findById(sprintId).get();
      task.setSprintTask(sprint);
      taskRepository.save(task);

   }
}


//////////// neksa l'affectation mtaa sprint
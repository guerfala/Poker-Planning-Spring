package tn.esprit.pokerplanning.Services;

import jakarta.transaction.Transactional;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import tn.esprit.pokerplanning.Entities.Sprint;
import tn.esprit.pokerplanning.Entities.Task;
import tn.esprit.pokerplanning.Repositories.SprintRepository;
import tn.esprit.pokerplanning.Repositories.TaskRepository;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SprintServiceImpl implements ISprintService {

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


   public List<Sprint> getAllSprint()
   {
      List<Sprint> sprints = sprintRepository.findAll();
      return sprints;
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


   public void affectersprinttotask(Long idTask, Long sprintId) {
      Task task = taskRepository.findById(idTask).get();
      Sprint sprint = sprintRepository.findById(sprintId).get();
      task.setSprintTask(sprint);
      taskRepository.save(task);

   }
}



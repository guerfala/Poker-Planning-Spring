package tn.esprit.pokerplanning.Services;

import tn.esprit.pokerplanning.Entities.Sprint;
import tn.esprit.pokerplanning.Entities.Task;

import java.util.List;


public interface ISprintService {

        public Sprint getSprintById(Long sprintId);
        public Sprint addSprint(Sprint c);

        public  List <Sprint> getAllSprint();
        Sprint updateSprint(Long sprintId, Sprint SprintDetails);
        void deleteSprint(Long sprintId);


        public void affectersprinttotask(Long idTask, Long sprintId);



}

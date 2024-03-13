package tn.esprit.pokerplanning.Controllers;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.pokerplanning.Entities.Sprint;
import tn.esprit.pokerplanning.Entities.Task;
import tn.esprit.pokerplanning.Services.ISprintService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/sprints")
@CrossOrigin("**")
public class SprintController {

    ISprintService sprintService;


    @PutMapping("/affectersprinttotask/{taskId}/{sprintId}")
    public void affectersprinttotask(@PathVariable("taskId") Long idTask,
                                             @PathVariable("sprintId") Long sprintId) {
        sprintService.affectersprinttotask(idTask, sprintId);
    }


    @PostMapping("/add-sprint")
    public Sprint addSprint(@RequestBody Sprint c) {
        Sprint sprint = sprintService.addSprint(c);
        return sprint;
    }


    @GetMapping("/getAllSprints")
    public List<Sprint> getAllSprints(){
        return sprintService.getAllSprint();
    }

    @GetMapping("/{sprintId}")
    public Sprint getSprintById(@PathVariable("sprintId") Long sprintId) {
        Sprint sprint = sprintService.getSprintById(sprintId);
        return sprint;
    }



    @PutMapping("/update/{sprintId}")
    public Sprint updateSprint(@PathVariable("sprintId") Long sprintId, @RequestBody Sprint sprintDetails) {
        return sprintService.updateSprint(sprintId, sprintDetails);
    }


    @DeleteMapping("/delete/{sprintId}")
    public ResponseEntity<?> deleteSprint(@PathVariable("sprintId") Long sprintId) {
        sprintService.deleteSprint(sprintId);
        return ResponseEntity.ok().build();
    }

}

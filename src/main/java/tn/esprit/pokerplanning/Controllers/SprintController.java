package tn.esprit.pokerplanning.Controllers;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.pokerplanning.Entities.Sprint;
import tn.esprit.pokerplanning.Services.ISprintService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/sprints")
public class SprintController {

    ISprintService sprintService;


    @PutMapping("/affecter-sprint-to-task/{taskId}/{sprintId}")
    public void affecgterProjetAProjetDetail(@PathVariable("taskId") Long idTask,
                                             @PathVariable("sprintId") Long sprintId) {
        sprintService.assignTaskToSprint(idTask, sprintId);
    }
    @PostMapping("/add-sprint")
    public Sprint addSprint(@RequestBody Sprint c) {
        Sprint sprint = sprintService.addSprint(c);
        return sprint;
    }

    @GetMapping("/getAllSprints")
    public ResponseEntity<List<Sprint>> getAllSprints() {
        List<Sprint> listSprints = sprintService.getAllSprint();
        return ResponseEntity.ok(listSprints);
    }


    @GetMapping("/{sprintId}")
    public Sprint getSprintById(@PathVariable("sprintId") Long sprintId) {
        Sprint sprint = sprintService.getSprintById(sprintId);
        return sprint;
    }



    @PutMapping("/{sprintId}")
    public Sprint updateSprint(@PathVariable("sprintId") Long sprintId, @RequestBody Sprint sprintDetails) {
        return sprintService.updateSprint(sprintId, sprintDetails);
    }


    @DeleteMapping("/{sprintId}")
    public ResponseEntity<?> deleteSprint(@PathVariable("sprintId") Long sprintId) {
        sprintService.deleteSprint(sprintId);
        return ResponseEntity.ok().build();
    }

}

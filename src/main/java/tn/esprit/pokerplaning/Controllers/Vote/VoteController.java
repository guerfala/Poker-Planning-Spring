package tn.esprit.pokerplaning.Controllers.Vote;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.pokerplaning.Entities.Task.Task;
import tn.esprit.pokerplaning.Entities.Vote.Vote;
import tn.esprit.pokerplaning.Services.Task.TaskServiceImpl;
import tn.esprit.pokerplaning.Services.Vote.VoteServicesImp;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/vote")
@RequiredArgsConstructor


public class VoteController {

    private final VoteServicesImp voteService;
    private final TaskServiceImpl taskService;

    @PostMapping("/add/{userId}/{taskId}")
    public Vote addVote(@RequestBody Vote vote, @PathVariable Long userId, @PathVariable Long taskId) {
        // Retrieve the task object based on the taskId
        Task task = taskService.getTaskById(taskId);
        // Call the service method with the task object
        return voteService.addVote(vote, userId, task);
    }

    @GetMapping("/task/{taskId}/votes")
    public ResponseEntity<List<Vote>> getVotesForTask(@PathVariable Long taskId) {
        List<Vote> votes = voteService.getVotesForTask(taskId);
        return ResponseEntity.ok(votes);
    }


    @PutMapping("/update")
    public Vote updateVote(@RequestBody Vote vote) {
        return voteService.updateVote(vote);
    }

    @GetMapping("/all")
    public List<Vote> getAllVotes() {
        return voteService.getAllVotes();
    }

    @GetMapping("/{idVote}")
    public Vote getVoteById(@PathVariable Long idVote) {
        return voteService.getVoteById(idVote);
    }

    @DeleteMapping("/delete/{idVote}")
    public void deleteVote(@PathVariable Long idVote) {
        voteService.deleteVote(idVote);
    }
}


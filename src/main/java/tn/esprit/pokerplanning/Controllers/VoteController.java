package tn.esprit.pokerplanning.Controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.pokerplanning.Entities.Vote;
import tn.esprit.pokerplanning.Services.VoteServicesImp;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/vote")
@RequiredArgsConstructor
public class VoteController {

    private final VoteServicesImp voteService;

    @PostMapping("/add")
    public Vote addVote(@RequestBody Vote vote) {
        return voteService.addVote(vote);
    }

    @PutMapping("/update")
    public Vote updateVote(@RequestBody Vote vote) {
        return voteService.updateVote(vote);
    }

//    @GetMapping("/getAllVotesByIdFoyer/{idFoyer}")
//    public List<Vote> getAllVotesByIdFoyer(@PathVariable Long idFoyer) {
//        return voteService.getAllVotesByIdFoyer(idFoyer);
//    }

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


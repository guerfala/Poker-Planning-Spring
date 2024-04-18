package tn.esprit.pokerplaning.Services.Vote;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import tn.esprit.pokerplaning.Entities.Task.Task;
import tn.esprit.pokerplaning.Entities.Vote.Vote;
import tn.esprit.pokerplaning.Repositories.Vote.VoteRepository;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor

public class VoteServicesImp {

    private final VoteRepository voteRepository;


    public Vote addVote(Vote vote, Long userId, Task task) {
        // Set the userId and task in the vote entity
        vote.setUserId(userId);
        vote.setTask(task);

        // Save the vote entity
        return voteRepository.save(vote);
    }

    public List<Vote> getVotesForTask(Long taskId) {
        // Implement the logic to fetch votes for the specified task ID
        return voteRepository.findByTaskId(taskId);
    }


    public Vote updateVote(Vote vote) {
        return voteRepository.save(vote);
    }


    public List<Vote> getAllVotes() {
        return voteRepository.findAll();
    }


    public Vote getVoteById(Long idVote) {
        return voteRepository.findById(idVote).orElse(null);
    }


    public void deleteVote(Long idVote) {
        voteRepository.deleteById(idVote);
    }

}

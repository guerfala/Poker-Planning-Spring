package tn.esprit.pokerplaning.Services.Vote;

import tn.esprit.pokerplaning.Entities.Task.Task;
import tn.esprit.pokerplaning.Entities.Vote.Vote;

import java.util.List;
public interface VoteServices {
    Vote addVote(Vote vote, Long UserId, Task task);
    Vote updateVote(Vote vote);
    List<Vote> getAllVotes();
    List<Vote> getVotesForTask(Long taskId);
    Vote getVoteById(Long idVote);
    void deleteVote(Long idVote);
}

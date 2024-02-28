package tn.esprit.pokerplaning.Services.Vote;
import tn.esprit.pokerplaning.Entities.Vote.Vote;
import java.util.List;
public interface VoteServices {
    Vote addVote(Vote vote);
    Vote updateVote(Vote vote);
    List<Vote> getAllVotes();
//    List<Vote> getAllVotesByIdFoyer( Long idFoyer);
    Vote getVoteById(Long idVote);
    void deleteVote(Long idVote);
}

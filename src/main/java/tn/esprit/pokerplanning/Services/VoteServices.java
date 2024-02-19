package tn.esprit.pokerplanning.Services;
import tn.esprit.pokerplanning.Entities.Vote;
import java.util.List;
public interface VoteServices {
    Vote addVote(Vote vote);
    Vote updateVote(Vote vote);
    List<Vote> getAllVotes();
//    List<Vote> getAllVotesByIdFoyer( Long idFoyer);
    Vote getVoteById(Long idVote);
    void deleteVote(Long idVote);
}

package tn.esprit.pokerplaning.Services.Vote;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import tn.esprit.pokerplaning.Entities.Vote.Vote;
import tn.esprit.pokerplaning.Repositories.Vote.VoteRepository;


import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class VoteServicesImp implements VoteServices{

    private final VoteRepository voteRepository;

    @Override
    public Vote addVote(Vote vote) {return voteRepository.save(vote);
    }

    @Override
    public Vote updateVote(Vote vote) {
        return voteRepository.save(vote);
    }

    @Override
    public List<Vote> getAllVotes() {
        return voteRepository.findAll();
    }

    @Override
    public Vote getVoteById(Long idVote) {
        return voteRepository.findById(idVote).orElse(null);
    }

    @Override
    public void deleteVote(Long idVote) {
        voteRepository.deleteById(idVote);
    }

}

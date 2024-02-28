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
<<<<<<< HEAD
public class VoteServicesImp {

    private final VoteRepository voteRepository;


    public Vote addVote(Vote vote) {return voteRepository.save(vote);
    }


=======
public class VoteServicesImp implements VoteServices{

    private final VoteRepository voteRepository;

    @Override
    public Vote addVote(Vote vote) {return voteRepository.save(vote);
    }

    @Override
>>>>>>> 374fea84c1f645878643d3e628e8c17aecb8511b
    public Vote updateVote(Vote vote) {
        return voteRepository.save(vote);
    }

<<<<<<< HEAD

=======
    @Override
>>>>>>> 374fea84c1f645878643d3e628e8c17aecb8511b
    public List<Vote> getAllVotes() {
        return voteRepository.findAll();
    }

<<<<<<< HEAD

=======
    @Override
>>>>>>> 374fea84c1f645878643d3e628e8c17aecb8511b
    public Vote getVoteById(Long idVote) {
        return voteRepository.findById(idVote).orElse(null);
    }

<<<<<<< HEAD

=======
    @Override
>>>>>>> 374fea84c1f645878643d3e628e8c17aecb8511b
    public void deleteVote(Long idVote) {
        voteRepository.deleteById(idVote);
    }

}
package tn.esprit.pokerplaning.Repositories.Vote;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import tn.esprit.pokerplaning.Entities.Vote.Vote;

import java.util.List;

public interface VoteRepository extends JpaRepository<Vote, Long> {
}

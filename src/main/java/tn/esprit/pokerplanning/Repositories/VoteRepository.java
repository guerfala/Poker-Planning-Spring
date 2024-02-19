package tn.esprit.pokerplanning.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import tn.esprit.pokerplanning.Entities.Vote;

import java.util.List;

public interface VoteRepository extends JpaRepository<Vote, Long> {
}

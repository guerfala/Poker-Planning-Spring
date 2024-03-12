package tn.esprit.pokerplanning.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.pokerplanning.Entities.Sprint;
import tn.esprit.pokerplanning.Entities.Task;

@Repository

public interface SprintRepository extends JpaRepository<Sprint, Long> {

}
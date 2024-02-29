package tn.esprit.pokerplaning.Repositories.Task;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.pokerplaning.Entities.Task.Sprint;
import tn.esprit.pokerplaning.Entities.Task.Task;

@Repository

public interface SprintRepository extends JpaRepository<Sprint, Long> {

}

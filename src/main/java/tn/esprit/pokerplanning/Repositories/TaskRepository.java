package tn.esprit.pokerplanning.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.pokerplanning.Entities.Status;
import tn.esprit.pokerplanning.Entities.Task;

import java.util.List;
import java.util.Optional;
@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

    /*List<Task> findAllByTaskId();*/

}

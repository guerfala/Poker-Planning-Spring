package tn.esprit.pokerplaning.Repositories.Task;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.esprit.pokerplaning.Entities.Task.Task;

import java.util.List;
import java.util.Optional;
@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findAllByRoomTaskIsNull();
    @Query("SELECT t FROM Task t WHERE t.complexity > 0")
    List<Task> findAllByComplexityNotZero();

    @Query("SELECT t FROM Task t WHERE t.user.userId = :userId")
    List<Task> findAllByUserId(@Param("userId") Long userId);
}

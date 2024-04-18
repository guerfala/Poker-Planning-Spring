package tn.esprit.pokerplaning.Repositories.ProjectTeam;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.pokerplaning.Entities.ProjectTeam.Project;

@Repository
public interface ProjectRepository extends JpaRepository<Project,Long> {
}

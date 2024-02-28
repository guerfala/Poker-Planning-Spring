package tn.esprit.pokerplaning.Services.ProjectTeam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.pokerplaning.Entities.ProjectTeam.Project;
import tn.esprit.pokerplaning.Entities.ProjectTeam.Team;
import tn.esprit.pokerplaning.Repositories.ProjectTeam.ProjectRepository;


import java.util.List;

@Service
public class ProjectService {
    @Autowired
    private ProjectRepository projectRepository;

    public Project getProjectById(Long id) {
        return projectRepository.findById(id) .orElse(null);
    }


    public Project addProject(Project project) {
        return projectRepository.save(project);
    }

    public Project updateProject(Project project1) {
        return projectRepository.save(project1);
    }

    public List<Project> getAllProjects() {
     return projectRepository.findAll();
     }


    public void deleteProject(Project project) {
        projectRepository.delete(project);
    }

    public void affectTeamToProject(Long projectId, Team team) {
        Project project = projectRepository.findById(projectId)
                .orElseThrow(() -> new RuntimeException("Project not found with id: " + projectId));
        project.setTeam(team);
        projectRepository.save(project);
    }
}
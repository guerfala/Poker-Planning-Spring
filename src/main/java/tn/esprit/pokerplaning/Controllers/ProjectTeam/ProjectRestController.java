package tn.esprit.pokerplaning.Controllers.ProjectTeam;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.pokerplaning.Entities.ProjectTeam.Project;
import tn.esprit.pokerplaning.Entities.ProjectTeam.Team;
import tn.esprit.pokerplaning.Repositories.ProjectTeam.ProjectRepository;
import tn.esprit.pokerplaning.Services.ProjectTeam.ProjectService;
import tn.esprit.pokerplaning.Services.ProjectTeam.TeamService;

import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@CrossOrigin
public class ProjectRestController {
    @Autowired
    private ProjectRepository projectRepository;
    @Autowired
    private ProjectService projectService;
    @Autowired
    private TeamService teamService;


    @PostMapping("/addProject")
    public Project addProject (@RequestBody Project project){
        return projectService.addProject(project);
    }


    @GetMapping("/Project/{id}")
    public ResponseEntity<Project>getProjectById(@PathVariable Long id){
        Project project = projectService.getProjectById(id);
        if (project==null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(project);
    }
    @GetMapping("/Projects")
     public List <Project> getAllProjects(){
      return projectService.getAllProjects();
    }


    @PostMapping("/updateProject/{id}")
    public ResponseEntity<Project> updateProjectById(@PathVariable Long id, @RequestBody Project project) {
        Project project1 =  projectService.getProjectById(id);
        if (project==null){
            return ResponseEntity.notFound().build();
        }
        project1.setProjectName(project.getProjectName());
        project1.setStartDate(project.getStartDate());
        project1.setEndDate(project.getEndDate());
        project1.setStatus(project.getStatus());
        Project updateProject = projectService.updateProject(project1);
        return ResponseEntity.ok(updateProject);

    }
    @DeleteMapping("/deleteProject/{id}")
    public ResponseEntity<Project> deleteProject(@PathVariable Long id){
        Project project = projectService.getProjectById(id);
        if (project==null)
            return ResponseEntity.notFound().build();
        projectService.deleteProject(project);
        return ResponseEntity.ok().build();

    }

    @PutMapping("/assign-team/{projectId}/{teamId}")
    public ResponseEntity<String> assignTeamToProject(@PathVariable Long projectId, @PathVariable Long teamId) {
        Project project = projectService.getProjectById(projectId);
        Team team = teamService.getTeamById(teamId);

        if (project == null || team == null) {
            return ResponseEntity.notFound().build();
        }

        projectService.affectTeamToProject(projectId, team);
        return ResponseEntity.ok("Team with ID " + teamId + " has been assigned to project with ID " + projectId);
    }

}

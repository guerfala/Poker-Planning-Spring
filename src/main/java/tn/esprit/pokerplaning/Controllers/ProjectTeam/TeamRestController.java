package tn.esprit.pokerplaning.Controllers.ProjectTeam;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.pokerplaning.Entities.ProjectTeam.Team;
import tn.esprit.pokerplaning.Repositories.ProjectTeam.TeamRepository;
import tn.esprit.pokerplaning.Services.ProjectTeam.TeamService;


import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class TeamRestController {
     @Autowired
    private TeamRepository teamRepository;
     @Autowired
     private TeamService teamService;

     @PostMapping("/addTeam")
     public Team addTeam (@RequestBody Team team){
         return teamService.addTeam(team);
     }


     @GetMapping("/Team/{id}")
     public ResponseEntity<Team>getTeamById(@PathVariable Long id){
         Team team = teamService.getTeamById(id);
         if (team==null){
             return ResponseEntity.notFound().build();
         }
         return ResponseEntity.ok(team);
     }
     @GetMapping("/Teams")
    public List <Team> getAllTeams(){
         return teamService.getAllTeams();
     }


    @PostMapping("/updateTeam/{id}")
    public ResponseEntity<Team> updateTeamById(@PathVariable Long id, @RequestBody Team team) {
         Team team1 =  teamService.getTeamById(id);
        if (team==null){
            return ResponseEntity.notFound().build();
        }
        team1.setTeamName(team.getTeamName());
        team1.setEvaluation(team.getEvaluation());
        Team updateTeam = teamService.updateTeam(team1);
        return ResponseEntity.ok(updateTeam);

     }
     @DeleteMapping("/deleteTeam/{id}")
     public ResponseEntity<Team> deleteTeam(@PathVariable Long id){
         Team team = teamService.getTeamById(id);
         if (team==null)
             return ResponseEntity.notFound().build();
             teamService.deleteTeam(team);
             return ResponseEntity.ok().build();

     }


}

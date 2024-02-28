package tn.esprit.pokerplaning.Services.ProjectTeam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.pokerplaning.Entities.ProjectTeam.Team;
import tn.esprit.pokerplaning.Repositories.ProjectTeam.TeamRepository;


import java.util.List;

@Service
public class TeamService {
    @Autowired
    private TeamRepository teamRepository;

    public Team getTeamById(Long id) {
        return teamRepository.findById(id) .orElse(null);
    }


    public Team addTeam(Team team) {
      return teamRepository.save(team);
    }

    public Team updateTeam(Team team1) {
        return teamRepository.save(team1);
    }

    public List<Team> getAllTeams() {
       return teamRepository.findAll();
   }


    public void deleteTeam(Team team) {
         teamRepository.delete(team);
    }
}

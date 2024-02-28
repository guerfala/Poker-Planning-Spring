package tn.esprit.pokerplaning.Entities.ProjectTeam;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long teamId;

    private String teamName;

    private int evaluation;

    @OneToMany(mappedBy = "team")
  
    private List<Project> projectsTeam;

    @OneToMany(mappedBy = "teamAffected")
    private List<Affectation> affectations;
}

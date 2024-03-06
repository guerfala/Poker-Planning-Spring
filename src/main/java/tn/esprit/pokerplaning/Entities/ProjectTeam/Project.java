package tn.esprit.pokerplaning.Entities.ProjectTeam;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import tn.esprit.pokerplaning.Entities.Task.Sprint;
import tn.esprit.pokerplaning.Entities.packCard.Pack;

import java.util.Date;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long projetId;

    private String projectName;

    private Date startDate;

    private Date endDate;

    private int status;

    @ManyToOne
    private Pack pack;

    @OneToMany(mappedBy = "project")
    private List<Sprint> sprints;

    @ManyToOne(fetch = FetchType.EAGER)
    @JsonIgnore
    private Team team;
}

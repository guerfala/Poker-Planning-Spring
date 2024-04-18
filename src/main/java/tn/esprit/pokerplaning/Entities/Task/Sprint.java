package tn.esprit.pokerplaning.Entities.Task;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import tn.esprit.pokerplaning.Entities.ProjectTeam.Project;

import java.util.Date;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Sprint {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long sprintId;

    private String sprintName;

    private Date startDate;

    private Date endDate;

    @OneToMany(mappedBy = "sprintTask")
    private List<Task> tasksSprint;

    @ManyToOne
    private Project project;
}

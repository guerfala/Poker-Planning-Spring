package tn.esprit.pokerplanning.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

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

    @OneToMany(mappedBy = "sprintTask", fetch = FetchType.LAZY)
    @JsonIgnoreProperties("sprintTask")
    private List<Task> tasksSprint;

    @ManyToOne
    @JsonIgnore
    private Project project;
}

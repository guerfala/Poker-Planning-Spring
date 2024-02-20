package tn.esprit.pokerplanning.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long taskId;

    private String taskName;

    private String description;

    private int complexity;

    private LocalDate startDate;

    private LocalDate endDate;

    private int status;

    @ManyToOne
    private Room roomTask;

    @ManyToOne
    private Sprint sprintTask;
}

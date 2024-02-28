package tn.esprit.pokerplaning.Entities.Task;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import tn.esprit.pokerplaning.Entities.Room.Room;

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


    @Enumerated(EnumType.STRING)
    private Status status;


    @ManyToOne
    private Room roomTask;

    @ManyToOne
    private Sprint sprintTask;







}

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

<<<<<<< HEAD
    @Enumerated(EnumType.STRING)
    private Status status;
=======
    private int status;
>>>>>>> 374fea84c1f645878643d3e628e8c17aecb8511b

    @ManyToOne
    private Room roomTask;

    @ManyToOne
    private Sprint sprintTask;
<<<<<<< HEAD





=======
>>>>>>> 374fea84c1f645878643d3e628e8c17aecb8511b
}

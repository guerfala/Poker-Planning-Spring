package tn.esprit.pokerplaning.Entities.Room;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import tn.esprit.pokerplaning.Entities.Task.Task;
import tn.esprit.pokerplaning.Entities.User.User;
import tn.esprit.pokerplaning.Entities.Vote.Vote;

import java.util.Date;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long roomId;

    private String roomName;

    private Date startDate;

    private Date endDate;

    private int finalComplexity;

    private String description;

    private int status;

    @ManyToMany(mappedBy = "rooms")
    private List<User> participants;

    @OneToMany(mappedBy = "roomVote")
    private List<Vote> votes;

    @OneToMany(mappedBy = "roomTask")
    private List<Task> tasksRoom;
}

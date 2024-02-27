package tn.esprit.pokerplaning.Entities.Vote;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import tn.esprit.pokerplaning.Entities.Room.Room;
import tn.esprit.pokerplaning.Entities.Task.Task;
import tn.esprit.pokerplaning.Entities.User.User;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Vote {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long voteId;

    private int cardValue;

    @ManyToOne
    private Task task;

    private int occurence;

    private LocalDateTime voteTimestamp;

    private ConfidenceLevel confidenceLevel;

    @PrePersist
    protected void onCreate() {
        voteTimestamp = LocalDateTime.now().withSecond(0).withNano(0); // Set current timestamp with seconds and nanoseconds truncated
    }

    public String getFormattedVoteTimestamp() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"); // Define the desired format
        return voteTimestamp.format(formatter); // Format the timestamp
    }

    @ManyToOne
    private User participant;

    @ManyToOne
    private Room roomVote;
}

package tn.esprit.pokerplanning.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

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

    private Timestamp voteTimeStamp;

    private ConfidenceLevel confidenceLevel;

    @ManyToOne
    private User participant;

    @ManyToOne
    private Room roomVote;
}

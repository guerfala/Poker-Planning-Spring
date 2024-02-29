package tn.esprit.pokerplaning.Entities.ProjectTeam;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import tn.esprit.pokerplaning.Entities.User.User;

import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Affectation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAffectation;

    private Date dateAffectation;

    @ManyToOne
    private User userAffected;

    @ManyToOne
    private Team teamAffected;
}

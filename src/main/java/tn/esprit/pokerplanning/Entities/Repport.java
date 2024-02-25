package tn.esprit.pokerplanning.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Repport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long repportId;

    @OneToOne
    @JoinColumn(name = "roomId")
    private Room roomRepport;
}

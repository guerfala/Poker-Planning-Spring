package tn.esprit.pokerplaning.Entities.packCard;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Cards {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cardId;

    private int value;

    private String image;

 
    @ManyToOne
    private Pack pack;
}

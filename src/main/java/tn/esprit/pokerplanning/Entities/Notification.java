package tn.esprit.pokerplanning.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Notification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long notificationId;

    private String description;
    private String image;



    @OneToOne
    @JoinColumn(name = "roomId")
    private Room roomNotif;
}

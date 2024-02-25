package tn.esprit.pokerplanning.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    private String lastName;

    private String firstname;

    private Role role;

    private String image;

    private String email;

    private String password;

    private Gender gender;

    private int skillRate;

    @ManyToMany
    private List<Room> rooms;

    @OneToMany(mappedBy = "userAffected")
    private List<Affectation> affectations;
}

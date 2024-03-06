package tn.esprit.pokerplanning.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pack {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long packId;

    private String packName;

    private String packDescription;

    private String image;

    private int nbCards;
    @JsonIgnore
    @OneToMany(mappedBy = "pack")
    private List<Cards> cardsList;

    @OneToMany(mappedBy = "pack")
    private List<Project> projectList;
}

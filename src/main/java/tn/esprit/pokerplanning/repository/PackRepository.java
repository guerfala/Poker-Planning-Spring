package tn.esprit.pokerplanning.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.pokerplanning.Entities.Cards;
import tn.esprit.pokerplanning.Entities.Pack;

public interface PackRepository extends JpaRepository<Pack, Long>{
    Pack findBypackName (String packName);

}

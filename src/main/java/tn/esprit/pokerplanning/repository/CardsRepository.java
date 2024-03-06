package tn.esprit.pokerplanning.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.pokerplanning.Entities.Cards;

public interface CardsRepository extends JpaRepository<Cards,Long>  {
}

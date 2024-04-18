package tn.esprit.pokerplaning.Repositories.packCard;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.pokerplaning.Entities.packCard.Cards;


public interface CardsRepository extends JpaRepository<Cards,Long>  {
}

package tn.esprit.pokerplaning.Repositories.packCard;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.pokerplaning.Entities.packCard.Pack;

public interface PackRepository extends JpaRepository<Pack, Long>{
    Pack findBypackName (String packName);

}

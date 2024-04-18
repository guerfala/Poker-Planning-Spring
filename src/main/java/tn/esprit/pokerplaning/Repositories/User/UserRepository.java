package tn.esprit.pokerplaning.Repositories.User;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import tn.esprit.pokerplaning.Entities.User.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository <User , Long> {

    Optional<User> findByEmail(String email);

    @Query("SELECT u FROM User u WHERE u.skillRate = :complexity")
    User findByskillRate(@Param("complexity") int complexity);

    User findFirstByOrderBySkillRateDesc();

    User findFirstBySkillRateOrderBySkillRateAsc(int nextSkillRate);
}

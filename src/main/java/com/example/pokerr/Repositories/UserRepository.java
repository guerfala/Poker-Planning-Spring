package com.example.pokerr.Repositories;

import com.example.pokerr.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository <User , Long> {

    Optional<User> findByEmail(String email);
}

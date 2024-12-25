package com.SpringBoot_PollingApp_Assignment.api.repositories;
import com.SpringBoot_PollingApp_Assignment.api.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByNom(String nom);

    boolean existsByNom(String nom);

}

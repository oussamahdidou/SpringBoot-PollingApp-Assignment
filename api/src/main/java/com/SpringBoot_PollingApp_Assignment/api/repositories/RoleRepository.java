package com.SpringBoot_PollingApp_Assignment.api.repositories;
import com.SpringBoot_PollingApp_Assignment.api.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(String name);

}

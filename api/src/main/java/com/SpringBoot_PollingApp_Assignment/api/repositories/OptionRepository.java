package com.SpringBoot_PollingApp_Assignment.api.repositories;

import com.SpringBoot_PollingApp_Assignment.api.models.Option;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OptionRepository extends JpaRepository<Option, Long> {}

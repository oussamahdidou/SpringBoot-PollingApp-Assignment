package com.SpringBoot_PollingApp_Assignment.api.repositories;

import com.SpringBoot_PollingApp_Assignment.api.models.Option;
import com.SpringBoot_PollingApp_Assignment.api.models.Poll;
import com.SpringBoot_PollingApp_Assignment.api.models.Vote;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PollRepository extends JpaRepository<Poll, Long> {}

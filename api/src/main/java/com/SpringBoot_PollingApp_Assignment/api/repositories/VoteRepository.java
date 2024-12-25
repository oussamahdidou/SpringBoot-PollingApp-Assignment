package com.SpringBoot_PollingApp_Assignment.api.repositories;

import com.SpringBoot_PollingApp_Assignment.api.models.Poll;
import com.SpringBoot_PollingApp_Assignment.api.models.User;
import com.SpringBoot_PollingApp_Assignment.api.models.Vote;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VoteRepository extends JpaRepository<Vote, Long> {
   boolean existsByUserAndPoll(User user, Poll pool);

}

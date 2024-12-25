package com.SpringBoot_PollingApp_Assignment.api.services.poll;

import com.SpringBoot_PollingApp_Assignment.api.models.Poll;
import com.SpringBoot_PollingApp_Assignment.api.models.Vote;

import java.util.List;

public interface PollService {
    Poll createPoll(String question, List<String> options, Long userId);
    Vote vote(Long userId, Long pollId, Long optionId);
}

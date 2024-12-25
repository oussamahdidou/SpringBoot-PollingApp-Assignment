package com.SpringBoot_PollingApp_Assignment.api.services.poll;

import com.SpringBoot_PollingApp_Assignment.api.models.Option;
import com.SpringBoot_PollingApp_Assignment.api.models.Poll;
import com.SpringBoot_PollingApp_Assignment.api.models.User;
import com.SpringBoot_PollingApp_Assignment.api.models.Vote;
import com.SpringBoot_PollingApp_Assignment.api.repositories.OptionRepository;
import com.SpringBoot_PollingApp_Assignment.api.repositories.PollRepository;
import com.SpringBoot_PollingApp_Assignment.api.repositories.UserRepository;
import com.SpringBoot_PollingApp_Assignment.api.repositories.VoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class PollServiceImpl implements PollService {
    @Autowired
    private PollRepository pollRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private OptionRepository optionRepository;
    @Autowired
    private VoteRepository voteRepository;

    public Poll createPoll(String question, List<String> options, Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Poll poll = new Poll();
        poll.setQuestion(question);
        poll.setUser(user);

        List<Option> pollOptions = options.stream()
                .map(content -> {
                    Option option = new Option();
                    option.setContent(content);
                    option.setPoll(poll);
                    return option;
                })
                .collect(Collectors.toList());

        poll.setOptions(pollOptions);
        return pollRepository.save(poll);
    }

    public Vote vote(Long userId, Long pollId, Long optionId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Poll poll = pollRepository.findById(pollId)
                .orElseThrow(() -> new RuntimeException("Poll not found"));

        Option option = optionRepository.findById(optionId)
                .orElseThrow(() -> new RuntimeException("Option not found"));

        // Check if user already voted for this poll
        if (voteRepository.existsByUserAndPoll(user, poll)) {
            throw new RuntimeException("User already voted for this poll");
        }

        Vote vote = new Vote();
        vote.setUser(user);
        vote.setPoll(poll);
        vote.setOption(option);

        return voteRepository.save(vote);
    }
}

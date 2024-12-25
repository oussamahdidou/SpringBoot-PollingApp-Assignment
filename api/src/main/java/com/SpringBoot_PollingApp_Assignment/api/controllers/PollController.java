package com.SpringBoot_PollingApp_Assignment.api.controllers;

import com.SpringBoot_PollingApp_Assignment.api.dtos.PollRequest;
import com.SpringBoot_PollingApp_Assignment.api.dtos.VoteRequest;
import com.SpringBoot_PollingApp_Assignment.api.models.Poll;
import com.SpringBoot_PollingApp_Assignment.api.models.Vote;
import com.SpringBoot_PollingApp_Assignment.api.services.poll.PollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class PollController {
    @Autowired
    private PollService pollService;

    @PostMapping("/polls")
    public ResponseEntity<Poll> createPoll(@RequestBody PollRequest request) {
        Poll poll = pollService.createPoll(request.getQuestion(), request.getOptions(), request.getUserId());
        return ResponseEntity.ok(poll);
    }

    @PostMapping("/votes")
    public ResponseEntity<Vote> vote(@RequestBody VoteRequest request) {
        Vote vote = pollService.vote(request.getUserId(), request.getPollId(), request.getOptionId());
        return ResponseEntity.ok(vote);
    }
}
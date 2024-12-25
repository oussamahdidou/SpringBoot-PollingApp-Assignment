package com.SpringBoot_PollingApp_Assignment.api.dtos;

import lombok.Data;

@Data
public class VoteRequest {
    private Long userId;
    private Long pollId;
    private Long optionId;
}

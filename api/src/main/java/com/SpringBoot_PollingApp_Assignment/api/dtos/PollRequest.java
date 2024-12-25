package com.SpringBoot_PollingApp_Assignment.api.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class PollRequest {
    private String question;
    private List<String> options;
    private Long userId;
}

package com.example.geamweb.dto;

import lombok.Data;

@Data
public class ScoreSubmitRequest {
    private Long gameId;
    private Integer score;
    private Integer duration;
    private String result;
}

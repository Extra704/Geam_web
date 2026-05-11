package com.example.geamweb.service;

import com.example.geamweb.dto.ScoreSubmitRequest;
import com.example.geamweb.entity.Game;

import java.util.List;
import java.util.Map;

public interface GameService {
    List<Game> listGames();
    Game getGame(Long id);
    void submitScore(String username, ScoreSubmitRequest request);
    List<Map<String, Object>> getGlobalRanking();
}

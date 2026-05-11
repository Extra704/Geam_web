package com.example.geamweb.controller;

import com.example.geamweb.common.ApiResponse;
import com.example.geamweb.dto.ScoreSubmitRequest;
import com.example.geamweb.service.GameService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class GameController {

    private final GameService gameService;

    @GetMapping("/games")
    public ApiResponse<?> listGames() {
        return ApiResponse.success(gameService.listGames());
    }

    @GetMapping("/games/{id}")
    public ApiResponse<?> getGame(@PathVariable Long id) {
        return ApiResponse.success(gameService.getGame(id));
    }

    @PostMapping("/scores")
    public ApiResponse<?> submitScore(@RequestBody ScoreSubmitRequest request, Authentication authentication) {
        gameService.submitScore(authentication.getName(), request);
        return ApiResponse.success(null);
    }

    @GetMapping("/rankings/global")
    public ApiResponse<?> globalRanking() {
        return ApiResponse.success(gameService.getGlobalRanking());
    }
}

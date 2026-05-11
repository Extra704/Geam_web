package com.example.geamweb.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.example.geamweb.dto.ScoreSubmitRequest;
import com.example.geamweb.entity.Game;
import com.example.geamweb.entity.GameRecord;
import com.example.geamweb.entity.User;
import com.example.geamweb.mapper.GameMapper;
import com.example.geamweb.mapper.GameRecordMapper;
import com.example.geamweb.mapper.UserMapper;
import com.example.geamweb.service.GameService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class GameServiceImpl implements GameService {

    private final GameMapper gameMapper;
    private final GameRecordMapper gameRecordMapper;
    private final UserMapper userMapper;

    @Override
    public List<Game> listGames() {
        return gameMapper.selectList(null);
    }

    @Override
    public Game getGame(Long id) {
        return gameMapper.selectById(id);
    }

    @Override
    public void submitScore(String username, ScoreSubmitRequest request) {
        User user = userMapper.selectOne(new LambdaQueryWrapper<User>().eq(User::getUsername, username));
        GameRecord record = new GameRecord();
        record.setUserId(user.getId());
        record.setGameId(request.getGameId());
        record.setScore(request.getScore());
        record.setDuration(request.getDuration());
        record.setResult(request.getResult());
        gameRecordMapper.insert(record);
    }

    @Override
    public List<Map<String, Object>> getGlobalRanking() {
        List<User> users = userMapper.selectList(null);
        List<Map<String, Object>> rows = new ArrayList<>();
        for (User user : users) {
            Map<String, Object> row = new LinkedHashMap<>();
            row.put("nickname", user.getNickname());
            row.put("bestScore", 0);
            rows.add(row);
        }
        return rows;
    }
}

package com.example.geamweb.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.geamweb.entity.Game;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface GameMapper extends BaseMapper<Game> {
}

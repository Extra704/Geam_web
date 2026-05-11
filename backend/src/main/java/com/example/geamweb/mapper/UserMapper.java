package com.example.geamweb.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.geamweb.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<User> {
}

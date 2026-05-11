package com.example.geamweb.service;

import com.example.geamweb.dto.LoginRequest;
import com.example.geamweb.dto.RegisterRequest;
import com.example.geamweb.vo.LoginResponse;

public interface AuthService {
    LoginResponse login(LoginRequest request);
    void register(RegisterRequest request);
}

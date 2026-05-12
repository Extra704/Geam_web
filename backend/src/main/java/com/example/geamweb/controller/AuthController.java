package com.example.geamweb.controller;
import com.example.geamweb.common.ApiResponse;
import com.example.geamweb.dto.LoginRequest;
import com.example.geamweb.dto.RegisterRequest;
import com.example.geamweb.service.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    // 注入认证相关的业务服务，实际逻辑在 AuthServiceImpl 中实现
    private final AuthService authService;

    /**
     * 登录接口
     * 接收前端的用户名/密码登录请求，调用服务层进行认证并返回登录结果（例如 JWT）。
     * 请求体使用 `LoginRequest`，包含必要的校验注解，由 `@Valid` 驱动。
     *
     * @param request 前端的登录请求对象
     * @return 封装在 `ApiResponse` 中的登录结果（成功通常包含 token 或用户信息）
     */
    @PostMapping("/login")
    public ApiResponse<?> login(@Valid @RequestBody LoginRequest request) {
        return ApiResponse.success(authService.login(request));
    }

    /**
     * 注册接口
     * 接收注册请求并委托给服务层处理。控制器只负责接收参数和返回统一响应，
     * 具体的用户名唯一性检查、密码加密等在服务层完成。
     *
     * @param request 包含注册所需字段的 `RegisterRequest`
     * @return 空的成功响应（前端可据此展示注册成功提示）
     */
    @PostMapping("/register")
    public ApiResponse<?> register(@Valid @RequestBody RegisterRequest request) {
        authService.register(request);
        return ApiResponse.success(null);
    }

    /**
     * 获取当前登录用户信息
     * Spring Security 会将当前认证信息注入到 `Authentication` 参数中。此接口
     * 常用于前端检测当前用户会话是否有效以及获取用户名等基本信息。
     *
     * @param authentication 由 Spring Security 注入，代表当前请求的认证主体
     * @return 返回当前用户名的简单 Map 封装在 `ApiResponse` 中
     */
    @GetMapping("/me")
    public ApiResponse<?> me(Authentication authentication) {
        return ApiResponse.success(Map.of("username", authentication.getName()));
    }
}

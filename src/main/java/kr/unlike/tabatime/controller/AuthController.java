package kr.unlike.tabatime.controller;

import kr.unlike.tabatime.dto.TokenResponse;
import kr.unlike.tabatime.dto.UserRequest;
import kr.unlike.tabatime.dto.response.ApiResponse;
import kr.unlike.tabatime.domain.User;
import kr.unlike.tabatime.exception.BizException;
import kr.unlike.tabatime.service.AuthService;
import kr.unlike.tabatime.util.ValidateUtil;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
@AllArgsConstructor
public class AuthController {
    private final AuthService authService;

    @PostMapping("/signup")
    public ApiResponse<?> signup(@RequestBody UserRequest userRequest) {
        ValidateUtil.notEmpty(userRequest.getEmail(), "이메일을 확인해주세요.");

        User user = authService.findOneByEmail(userRequest.getEmail());
        if (user != null) {
            throw new BizException("이미 가입되어 있는 유저입니다.", 991);
        }

        User newUser = User.builder()
                .snsType("KAKAO")
                .snsId(userRequest.getSnsId())
                .email(userRequest.getEmail())
                .status("active")
                .build();

        authService.signup(newUser);
        return ApiResponse.ok();
    }

    @PostMapping("/login")
    public ApiResponse<TokenResponse> login(@RequestBody UserRequest userRequest) {
        ValidateUtil.notEmpty(userRequest.getEmail(), "이메일을 확인해주세요.");
        TokenResponse tokenResponse = authService.login(userRequest);
        return ApiResponse.ok(tokenResponse);
    }

    @PostMapping("/left")
    public ApiResponse<?> left(@RequestAttribute User user) {
        authService.left(user);
        return ApiResponse.ok();
    }
}

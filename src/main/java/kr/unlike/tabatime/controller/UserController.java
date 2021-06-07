package kr.unlike.tabatime.controller;

import kr.unlike.tabatime.dto.response.ApiResponse;
import kr.unlike.tabatime.domain.User;
import kr.unlike.tabatime.dto.UserResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/user")
@AllArgsConstructor
public class UserController {

    @GetMapping("/me")
    public ApiResponse<UserResponse> getMe(User user) {
        return ApiResponse.ok(new UserResponse().of(user));
    }
}

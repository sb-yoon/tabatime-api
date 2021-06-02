package kr.unlike.tabatime.controller;

import kr.unlike.tabatime.dto.response.ApiResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {

    @GetMapping("/")
    public ApiResponse<String> welcome() {
        return ApiResponse.ok("Welcome Tabata Time");
    }
}
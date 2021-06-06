package kr.unlike.tabatime.controller;

import kr.unlike.tabatime.domain.User;
import kr.unlike.tabatime.dto.RoutineRequest;
import kr.unlike.tabatime.dto.RoutineResponse;
import kr.unlike.tabatime.dto.StatisticsResponse;
import kr.unlike.tabatime.dto.response.ApiResponse;
import kr.unlike.tabatime.service.RoutineService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/routine")
@AllArgsConstructor
public class RoutineController {

    private final RoutineService routineService;

    @PostMapping
    public ApiResponse<?> saveRoutine(@RequestAttribute User user, @RequestBody RoutineRequest routineRequest) {
        routineService.saveRoutine(user, routineRequest);
        return ApiResponse.ok();
    }

    @GetMapping
    public ApiResponse<List<RoutineResponse>> routineList(@RequestAttribute User user) {
        return ApiResponse.ok(routineService.getRoutineList(user));
    }

    @GetMapping("/statistics")
    public ApiResponse<StatisticsResponse> routineStatistics(@RequestAttribute User user) {
        return ApiResponse.ok(routineService.getStatistics(user));
    }
}

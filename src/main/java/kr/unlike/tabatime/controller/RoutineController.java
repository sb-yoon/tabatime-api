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
import java.util.Map;

@RestController
@RequestMapping("/api/v1/routine")
@AllArgsConstructor
public class RoutineController {

    private final RoutineService routineService;

    @PostMapping
    public ApiResponse<?> saveRoutine(User user, @RequestBody RoutineRequest routineRequest) {
        routineService.saveRoutine(user, routineRequest);
        return ApiResponse.ok();
    }

    @GetMapping
    public ApiResponse<List<RoutineResponse>> routineList(User user) {
        return ApiResponse.ok(routineService.getRoutineList(user));
    }

    @GetMapping("/statistics")
    public ApiResponse<StatisticsResponse> routineStatistics(User user) {
        return ApiResponse.ok(routineService.getStatistics(user));
    }

    @PostMapping("/delete")
    public ApiResponse<?> deleteRoutine(@RequestBody Map<String, List<String>> map, User user) {
        List<String> deleteRoutines = map.get("routineIds");
        routineService.deleteRoutines(user, deleteRoutines);
        return ApiResponse.ok();
    }
}

package kr.unlike.tabatime.dto;

import lombok.Data;

@Data
public class RoutineRequest {
    private Integer exerciseTime;
    private Integer restTime;
    private Integer setCnt;
    private Integer roundCnt;
    private Integer roundTime;
    private Integer totalTime;
}

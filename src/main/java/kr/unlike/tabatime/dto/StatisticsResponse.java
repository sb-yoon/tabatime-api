package kr.unlike.tabatime.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class StatisticsResponse {
    private Integer totalRoutineCnt;
    private Integer totalRoutineTime;
    private Double rankPer;
}

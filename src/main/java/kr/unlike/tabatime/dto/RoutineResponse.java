package kr.unlike.tabatime.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import kr.unlike.tabatime.domain.Routine;
import kr.unlike.tabatime.dto.response.BaseResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RoutineResponse implements BaseResponse<RoutineResponse, Routine> {
    private Long id; // 루틴 식별자
    private Integer exerciseTime; // 운동시간(초단위)
    private Integer restTime; // 휴식시간(초단위)
    private Integer setCnt; // 세트수
    private Integer roundCnt; // 라운드수
    private Integer roundTime; // 라운드시간
    private Integer totalTime; // 총 운동시간(초단위)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date regDate; // 등록일시

    @Override
    public RoutineResponse of(Routine routine) {
        return RoutineResponse.builder()
                .id(routine.getId())
                .exerciseTime(routine.getExerciseTime())
                .restTime(routine.getRestTime())
                .setCnt(routine.getSetCnt())
                .roundCnt(routine.getRoundCnt())
                .roundTime(routine.getRoundTime())
                .totalTime(routine.getTotalTime())
                .regDate(routine.getRegDate())
                .build();
    }

    @Override
    public List<RoutineResponse> of(List<Routine> routines) {
        return routines
                .stream()
                .map(this::of)
                .collect(Collectors.toList());
    }
}

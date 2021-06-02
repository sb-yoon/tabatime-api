package kr.unlike.tabatime.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Routine {
    private Integer id; // 루틴 식별자
    private Integer exerciseTime; // 운동시간(초단위)
    private Integer restTime; // 휴식시간(초단위)
    private Integer setCnt; // 세트수
    private Integer roundCnt; // 라운드수
    private Integer roundTime; // 라운드시간
    private Integer totalTime; // 총 운동시간(초단위)
    private Integer userId;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date regDate; // 등록일시

    private User user;
}
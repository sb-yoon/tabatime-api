package kr.unlike.tabatime.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class User {

    private Long id; // 회원 식별자
    private String snsType; // sns 종류: kakao
    private String snsId; // sns 아이디
    private String email; // 이메일
    private Integer totalExerciseTime; // 총운동시간
    private String status; // 회원 상태: active(정상), paused(휴면), blocked(차단), left(탈퇴)
    private Date loginDate; // 최종로그인일시
    private Date pausedDate; // 휴면일시
    private Date leftDate; // 탈퇴일시
    private Date blockedDate; // 차단일시
    private Date regDate; // 등록일시
    private Date modDate; // 수정일시
}

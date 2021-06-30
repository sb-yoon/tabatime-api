package kr.unlike.tabatime.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import kr.unlike.tabatime.domain.User;
import kr.unlike.tabatime.dto.response.BaseResponse;
import lombok.*;

import java.util.Date;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserResponse implements BaseResponse<UserResponse, User> {

    private Long id;
    private String snsType;
    private String email;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date regDate;

    @Override
    public UserResponse of(User user) {
        return builder()
                .id(user.getId())
                .snsType(user.getSnsType())
                .email(user.getEmail())
                .regDate(user.getRegDate())
                .build();
    }

    @Override
    public List<UserResponse> of(List<User> list) {
        return null;
    }
}

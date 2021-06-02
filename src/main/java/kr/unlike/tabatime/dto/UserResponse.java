package kr.unlike.tabatime.dto;

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

    private int id;
    private String snsType;
    private String email;
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

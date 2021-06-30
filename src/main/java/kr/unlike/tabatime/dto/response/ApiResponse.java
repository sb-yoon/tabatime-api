package kr.unlike.tabatime.dto.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class ApiResponse<T> {
    private Integer code;
    private String message;

    // DATA
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private T data;

    public static ApiResponse<?> ok() {
        ApiResponse<?> response = new ApiResponse<>();
        response.setCode(Result.A0200.getCode());
        response.setMessage(Result.A0200.getMessage());
        return response;
    }

    public static <T> ApiResponse<T> ok(T data) {
        ApiResponse<T> response = new ApiResponse<>();
        response.setCode(Result.A0200.getCode());
        response.setMessage(Result.A0200.getMessage());
        response.setData(data);
        return response;
    }

    public static ApiResponse<?> error(Result result) {
        return error(result, result.getMessage());
    }

    public static ApiResponse<?> error(Result result, String message) {
        ApiResponse<?> response = new ApiResponse<>();
        response.setCode(result.getCode());
        if (message == null) response.setMessage(result.getMessage());
        else response.setMessage(message);
        return response;
    }

    public static ApiResponse<?> error(int code, String message) {
        ApiResponse<?> response = new ApiResponse<>();
        response.setCode(code);
        response.setMessage(message);
        return response;
    }
}

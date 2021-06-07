package kr.unlike.tabatime.dto.response;

public enum Result {

    A0000(0,"Fail"),
    A0200(200, "Success"),
    A0400(400,"Bad Request"),
    A0401(401,"Authentication failed"),
    A0404(404, "Not Found"),
    A0406(406, "HttpMediaTypeNotSupported"),
    A0500(500, "Internal Server Error"),

    // API 오류
    A1000(1000,"존재하지 않음"),
    A1101(1101, "이미 가입된 회원");

    private final Integer code;
    private final String message;

    Result(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}

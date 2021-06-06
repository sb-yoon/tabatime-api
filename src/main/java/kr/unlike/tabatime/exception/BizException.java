package kr.unlike.tabatime.exception;

import kr.unlike.tabatime.dto.response.Result;

public class BizException extends RuntimeException {

    private static final long serialVersionUID = 2447329833156858838L;

    private Result result;

    public BizException(String msg, Result result) {
        super(msg);
        this.result = result;
    }

    public BizException(String msg) {
        super(msg);
    }

    public Result getCode() {
        return result;
    }
}

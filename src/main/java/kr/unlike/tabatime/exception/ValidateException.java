package kr.unlike.tabatime.exception;

public class ValidateException extends RuntimeException {
    private static final long serialVersionUID = -9218894624533726526L;

    public ValidateException(String msg, Exception e) {
        super(msg, e);
    }

    public ValidateException(String msg) {
        super(msg);
    }
}

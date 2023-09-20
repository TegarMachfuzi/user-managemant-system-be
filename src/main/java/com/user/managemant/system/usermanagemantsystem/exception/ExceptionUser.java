package com.user.managemant.system.usermanagemantsystem.exception;

public class ExceptionUser extends RuntimeException{
    private static final long serialVersionUID = 2325455234935684257L;

    private final Integer statusCode;

    public ExceptionUser(String message) {
        super(message);
        this.statusCode = -1;
    }

    public ExceptionUser(String message, Throwable cause) {
        super(message, cause);
        this.statusCode = -1;
    }

    public ExceptionUser(String message, Integer statusCode) {
        super(message);
        this.statusCode = statusCode;
    }

    public ExceptionUser(String message,Integer statusCode, Throwable cause) {
        super(message, cause);
        this.statusCode = statusCode;
    }

    public int getStatusCode() {
        return this.statusCode;
    }
    @Override
    public String getMessage() {
        return super.getMessage();
    }
}

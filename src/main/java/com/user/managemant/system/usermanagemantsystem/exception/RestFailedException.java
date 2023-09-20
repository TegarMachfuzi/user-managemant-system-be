package com.user.managemant.system.usermanagemantsystem.exception;

public class RestFailedException extends RuntimeException{
    private static final long serialVersionUID = 3205874618400385129L;

    private final String url;

    private final Integer statusCode;

    private final String failingRequest;

    private final String failingResponse;

    public RestFailedException() {
        super();
        this.url = "";
        this.statusCode = -1;
        this.failingRequest = "";
        this.failingResponse = "";
    }

    public RestFailedException(String message) {
        super(message);
        this.url = "";
        this.statusCode = -1;
        this.failingRequest = "";
        this.failingResponse = "";
    }

    public RestFailedException(String message, Throwable cause) {
        super(message, cause);
        this.url = "";
        this.statusCode = -1;
        this.failingRequest = "";
        this.failingResponse = "";
    }

    public RestFailedException(String message, String url, Integer statusCode, String failingRequest, String failingResponse) {
        super(message);
        this.url = url;
        this.statusCode = statusCode;
        this.failingRequest = failingRequest;
        this.failingResponse = failingResponse;
    }

    public RestFailedException(String message, String url, Integer statusCode, String failingRequest, String failingResponse, Throwable cause) {
        super(message, cause);
        this.url = url;
        this.statusCode = statusCode;
        this.failingRequest = failingRequest;
        this.failingResponse = failingResponse;
    }

    public String getFormattedError() {
        return "URL: " + this.url + " | Response Code: " + this.statusCode + " | Request: " + this.failingRequest + " | Response: " + this.failingResponse;
    }
    public int getStatusCode() {
        return this.statusCode;
    }
    @Override
    public String getMessage() {
        return super.getMessage() + "::" + getFormattedError();
    }
}

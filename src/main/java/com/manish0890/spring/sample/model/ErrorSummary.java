package com.manish0890.spring.sample.model;

import java.util.Date;

public class ErrorSummary {
    private String message;
    private String errorDetails;
    private String timeStamp;

    public ErrorSummary() {}

    public ErrorSummary(String message, String errorDetails, Date time) {
        this.message = message;
        this.errorDetails = errorDetails;
        this.timeStamp = time.toString();
    }



    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getErrorDetails() {
        return errorDetails;
    }

    public void setErrorDetails(String errorDetails) {
        this.errorDetails = errorDetails;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }
}

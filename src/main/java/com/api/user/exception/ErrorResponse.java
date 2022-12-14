package com.api.user.exception;

import lombok.Data;

@Data
public class ErrorResponse
{
    private int status;
    private String message;
    private long timeStamp;
    public ErrorResponse(int status, String message, long timeStamp)
    {
        this.status = status;
        this.message = message;
        this.timeStamp = timeStamp;
    }
}

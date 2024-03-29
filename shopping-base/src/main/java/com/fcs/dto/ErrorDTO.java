package com.fcs.dto;

import java.util.Date;

public class ErrorDTO {

    private int status;
    private String message;
    private Date timestamp;

    public ErrorDTO() {

    }

    public ErrorDTO(int status, String message) {
        this.status = status;
        this.message = message;
        this.timestamp = new Date();
    }

    public ErrorDTO(int status, String message, Date timestamp) {
        this.status = status;
        this.message = message;
        this.timestamp = timestamp;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }
}

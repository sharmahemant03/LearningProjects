package com.hartron.springbootapi.springbootapi;




public class Response {

    String message;
    String status;

    public Response(String message, String status) {
        this.message = message;
        this.status = status;
    }

    public Response() {
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

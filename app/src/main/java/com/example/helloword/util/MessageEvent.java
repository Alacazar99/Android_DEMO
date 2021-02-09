package com.example.helloword.util;

public class MessageEvent {
    private String message;
    private String username,password;

    public  MessageEvent(String message){
        this.message=message;
    };


    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

package com.example.helloword.util;

public class UserEvent {
    String username;
    String password;

    public UserEvent(String username,String password){
        this.username = username;
        this.password = password;
    }

    public UserEvent(String username) {
        this.username = username;
    }


    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}

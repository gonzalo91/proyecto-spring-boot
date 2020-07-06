package com.zalo.ss.model;

import java.io.Serializable;

public class UserDto implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private String username;
    private String name;
    private String password;
    private int status;

    public String getUsername() {
        return username;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }



    
}

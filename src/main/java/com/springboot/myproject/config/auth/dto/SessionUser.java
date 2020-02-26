package com.springboot.myproject.config.auth.dto;

import lombok.Getter;

import java.io.Serializable;

@Getter
public class SessionUser implements Serializable {
    private String name;
    private String email;

    public SessionUser(String name, String email) {
        this.name = name;
        this.email = email;
    }
}

package com.springboot.myproject.web.dto;

import com.springboot.myproject.domain.user.RegisteredUser;
import com.springboot.myproject.domain.user.Role;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginResponseDto {
    private String id;
    private String pw;
    private String email;
    private String name;
    private Role role;

    public LoginResponseDto(RegisteredUser registeredUser){
        this.id = registeredUser.getId();
        this.pw = registeredUser.getPw();
        this.email = registeredUser.getEmail();
        this.name = registeredUser.getName();
        this.role = registeredUser.getRole();
    }

}

package com.springboot.myproject.web.dto;

import com.springboot.myproject.domain.user.RegisteredUser;
import com.springboot.myproject.domain.user.Role;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class RegisterDto {
    private String id;
    private String pw;
    private String name;
    private String email;
    private Role role;

    @Builder
    public RegisterDto(String id, String pw, String name, String email, Role role){
        this.id = id;
        this.pw = pw;
        this.name = name;
        this.email = email;
        this.role = role;
    }

    public RegisteredUser toEntity(){
        return RegisteredUser.builder()
                .id(id)
                .pw(pw)
                .name(name)
                .email(email)
                .role(Role.USER)
                .build();

    }

}

package com.springboot.myproject.web.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class LoginDto {
    private String id;
    private String pw;

    @Builder
    public LoginDto(String id, String pw){
        this.id = id;
        this.pw = pw;
    }

    public LoginDto toEntity(){
        return LoginDto.builder()
                .id(id)
                .pw(pw)
                .build();
    }
}

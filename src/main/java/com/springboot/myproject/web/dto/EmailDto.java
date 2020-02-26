package com.springboot.myproject.web.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class EmailDto {
    private String sender;
    private String title;
    private String content;

    @Builder
    public EmailDto(String sender, String title, String content){
        this.sender = sender;
        this.title = title;
        this.content = content;
    }
}

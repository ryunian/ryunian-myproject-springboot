package com.springboot.myproject.web.dto;

import com.springboot.myproject.domain.comment.Comment;
import lombok.Builder;
import lombok.Getter;

@Getter
public class CommentWriteDto {
    private String author;
    private String content;

    @Builder
    public CommentWriteDto(String author, String content){
        this.author = author;
        this.content = content;
    }

    public Comment toEntity(){
        return Comment.builder()
                .author(author)
                .content(content)
                .build();
    }

}

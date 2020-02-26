package com.springboot.myproject.web.dto;

import com.springboot.myproject.domain.comment.Comment;
import lombok.Getter;

@Getter
public class CommentResponseDto {
    private Long id;
    private String author;
    private String content;
    private int grp;
    private int step;
    private int indent;

    public CommentResponseDto(Comment comment){
        this.id = comment.getId();
        this.author = comment.getAuthor();
        this.content = comment.getContent();
        this.grp = comment.getGrp();
        this.step = comment.getStep();
        this.indent = comment.getIndent();
    }
}

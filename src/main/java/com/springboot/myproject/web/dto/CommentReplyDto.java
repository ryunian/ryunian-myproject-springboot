package com.springboot.myproject.web.dto;

import com.springboot.myproject.domain.comment.Comment;
import lombok.Builder;
import lombok.Getter;

@Getter
public class CommentReplyDto {
    private String author;
    private String content;
    private int grp;
    private int step;
    private int indent;

    @Builder
    public CommentReplyDto(String author, String content, int grp,int step, int indent){
        this.author = author;
        this.content = content;
        this.grp = grp;
        this.step =step;
        this.indent = indent;
    }

    public Comment toEntity(){
        return Comment.builder()
                .author(author)
                .content(content)
                .grp(grp)
                .step(step)
                .indent(indent)
                .build();
    }
}

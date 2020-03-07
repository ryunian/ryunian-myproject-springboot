package com.springboot.myproject.web.dto;

import com.springboot.myproject.domain.posts.Posts;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class PostsWriteRequestDto {
    private String title;
    private String content;
    private String author;
    private boolean isfile;

    @Builder
    public PostsWriteRequestDto(String title, String content, String author, boolean isfile){
        this.title = title;
        this.content = content;
        this.author = author;
        this.isfile = isfile;
    }

    public Posts toEntity(){
        return Posts.builder()
                .title(title)
                .content(content)
                .author(author)
                .isfile(isfile)
                .build();
    }
}

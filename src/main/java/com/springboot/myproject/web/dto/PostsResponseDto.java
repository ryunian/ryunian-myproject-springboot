package com.springboot.myproject.web.dto;

import com.springboot.myproject.domain.fileInfo.FileInfo;
import com.springboot.myproject.domain.posts.Posts;
import lombok.Getter;

import java.util.List;

@Getter
public class PostsResponseDto {
    private long id;
    private String title;
    private String content;
    private String author;
    private String date;
    private List<FileInfo> list;

    public PostsResponseDto(Posts entity, List list){
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.content = entity.getContent();
        this.author = entity.getAuthor();
        this.date = entity.getModifiedDate().toString().substring(0,10);
        this.list = list;
    }
}

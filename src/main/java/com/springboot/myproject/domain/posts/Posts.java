package com.springboot.myproject.domain.posts;

import com.springboot.myproject.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Posts extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 500, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    private boolean isfile;

    @Builder
    public Posts(String title, String content, String author, boolean isfile){
        this.title = title;
        this.content = content;
        this.author = author;
        this.isfile = isfile;
    }

    public void update(String title, String content){
        this.title = title;
        this.content = content;
    }

}

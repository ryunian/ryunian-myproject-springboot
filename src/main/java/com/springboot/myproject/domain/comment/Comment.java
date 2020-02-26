package com.springboot.myproject.domain.comment;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@NoArgsConstructor
@Entity
public class Comment{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String author;

    private String content;

    private int grp;

    @ColumnDefault("0")
    private int step;

    @ColumnDefault("0")
    private int indent; // 들여쓰기 횟수


    @Builder
    public Comment(String author,String content, int grp, int step, int indent){
        this.author = author;
        this.content = content;
        this.grp = grp;
        this.step = step;
        this.indent = indent;
    }
}

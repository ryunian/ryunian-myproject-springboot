package com.springboot.myproject.domain.fileInfo;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@NoArgsConstructor
@Getter
@Entity
public class FileInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long boardNum;

    private String originalFileName;

    private String storedFileName;

    @Builder
    public FileInfo(Long boardNum, String originalFileName, String storedFileName){
        this.boardNum = boardNum;
        this.originalFileName = originalFileName;
        this.storedFileName = storedFileName;
    }
}

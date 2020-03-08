package com.springboot.myproject.web.dto;

import com.springboot.myproject.domain.fileInfo.FileInfo;
import lombok.Getter;

@Getter
public class PostsDownloadInfoDto {
    private String originalFileName;
    private String storedFileName;

    public PostsDownloadInfoDto(FileInfo fileInfo){
        this.originalFileName = fileInfo.getOriginalFileName();
        this.storedFileName = fileInfo.getStoredFileName();
    }
}

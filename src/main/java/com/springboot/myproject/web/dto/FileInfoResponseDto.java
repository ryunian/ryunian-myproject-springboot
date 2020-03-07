package com.springboot.myproject.web.dto;

import com.springboot.myproject.domain.fileInfo.FileInfo;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class FileInfoResponseDto {
    private String originalFileInfo;
    private String storedFileInfo;


    public FileInfoResponseDto(FileInfo fileInfo) {
        this.originalFileInfo = fileInfo.getOriginalFileName();
        this.storedFileInfo = fileInfo.getStoredFileName();
    }
}

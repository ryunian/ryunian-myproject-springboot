package com.springboot.myproject.web.dto;

import com.springboot.myproject.domain.fileInfo.FileInfo;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class FileInfoWriteDto {
    private Long boardNum;
    private String originalFileName;
    private String storedFileName;

    @Builder
    public FileInfoWriteDto(Long boardNum, String originalFileName, String storedFileName){
        this.boardNum = boardNum;
        this.originalFileName = originalFileName;
        this.storedFileName = storedFileName;
    }

    public FileInfo toEntity(){
        return FileInfo.builder()
                .boardNum(boardNum)
                .originalFileName(originalFileName)
                .storedFileName(storedFileName)
                .build();
    }
}

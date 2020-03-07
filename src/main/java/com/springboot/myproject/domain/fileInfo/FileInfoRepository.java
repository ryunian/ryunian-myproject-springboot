package com.springboot.myproject.domain.fileInfo;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FileInfoRepository extends JpaRepository<FileInfo, Long> {
    List<FileInfo> findByBoardNum(Long id);
}

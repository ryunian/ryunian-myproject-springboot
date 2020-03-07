package com.springboot.myproject.service;

import com.springboot.myproject.domain.fileInfo.FileInfo;
import com.springboot.myproject.domain.fileInfo.FileInfoRepository;
import com.springboot.myproject.domain.posts.Posts;
import com.springboot.myproject.domain.posts.PostsRepository;
import com.springboot.myproject.web.dto.*;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PostsService {
    private final PostsRepository postsRepository;
    private final FileInfoRepository fileInfoRepository;

    // 게시글 등록
    @Transactional
    public Long save(PostsWriteRequestDto postsWriteRequestDto, MultipartFile[] files) throws IOException {
        Long id = postsRepository.save(postsWriteRequestDto.toEntity()).getId();
//        String baseDir = "D:\\upload\\";
        String baseDir = "~/upload/";
        for(MultipartFile file : files){
            String storeFileName = UUID.randomUUID().toString() + file.getOriginalFilename();
            file.transferTo(new File(baseDir + storeFileName));
            FileInfoWriteDto fileInfoWriteDto = new FileInfoWriteDto(id,file.getOriginalFilename(),storeFileName);
            fileInfoRepository.save(fileInfoWriteDto.toEntity());
        }
        return id;
    }

    // 게시글 리스트
    public List<PostsListResponseDto> findAllDesc(int a) {
        PageRequest pageRequest = PageRequest.of(a-1, 5,new Sort(Sort.Direction.DESC,"createDate"));
        List<PostsListResponseDto> list = postsRepository.findAll(pageRequest).stream().map(posts -> new PostsListResponseDto(posts)).collect(Collectors.toList());
        return list;
    }

    // 게시글 보기
    @Transactional
    public PostsResponseDto findById(Long id){
        System.out.println("run 1");
        Posts entity = postsRepository.findById(id).orElseThrow(() ->new IllegalArgumentException("해당 사용자가 없습니다. "+ id));
        System.out.println("run 2");
        List<FileInfo> list = fileInfoRepository.findByBoardNum(id);
        System.out.println("run 3");
        return new PostsResponseDto(entity,list);
    }

    // 게시글 수정
    @Transactional
    public Long update(Long id, PostsUpdateRequestDto requestDto) {
        Posts posts = postsRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 사용자가 없습니다 "+id));
        posts.update(requestDto.getTitle(), requestDto.getContent());
        return id;
    }

    // 게시글 삭제
    @Transactional
    public void delete(Long id){
        Posts posts = postsRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 사용자가 없습니다 "+id));
        postsRepository.delete(posts);
    }

    //페이지 정보
    @Transactional
    public PaginationDto page(int page){
        Long totalCount = postsRepository.totalCount();
        PaginationDto paginationDto = PaginationDto.builder().totalCount(Math.toIntExact(totalCount)).page(page).build();
        return paginationDto;
    }
}

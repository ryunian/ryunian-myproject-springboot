package com.springboot.myproject.web;

import com.springboot.myproject.service.PostsService;
import com.springboot.myproject.web.dto.PostsResponseDto;
import com.springboot.myproject.web.dto.PostsUpdateRequestDto;
import com.springboot.myproject.web.dto.PostsWriteRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


// CRUD
@RequiredArgsConstructor
@RestController
public class PostsApiController {
    private final PostsService postsService;

    // 게시글 등록
    @PostMapping("/api/posts")
    public Long save(@RequestBody PostsWriteRequestDto writeRequestDto){
        return postsService.save(writeRequestDto);
    }

    // 게시글 보기
    @GetMapping("/api/posts/{id}")
    public PostsResponseDto view(@PathVariable Long id){
        return postsService.findById(id);
    }

    // 게시글 수정
    @PutMapping("/api/posts/{id}")
    public Long modify(@PathVariable Long id, @RequestBody PostsUpdateRequestDto requestDto){
        return postsService.update(id, requestDto);
    }
    // 게시글 삭제
    @DeleteMapping("/api/posts/{id}")
    public Long delete(@PathVariable Long id){
        postsService.delete(id);
        return id;
    }
}

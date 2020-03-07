package com.springboot.myproject.web;

import com.springboot.myproject.service.PostsService;
import com.springboot.myproject.web.dto.PostsResponseDto;
import com.springboot.myproject.web.dto.PostsUpdateRequestDto;
import com.springboot.myproject.web.dto.PostsWriteRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;


// CRUD
@RequiredArgsConstructor
@RestController
public class PostsApiController {
    private final PostsService postsService;

    // 게시글 등록
    @PostMapping("/api/posts")
    public Long save(@RequestParam("title") String title, @RequestParam("content") String content,
                    @RequestParam("author") String author, @RequestParam("files") MultipartFile[] files) throws IOException {

        PostsWriteRequestDto writeRequestDto = new PostsWriteRequestDto(title,content, author);
        return postsService.save(writeRequestDto, files);
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

//    @PostMapping("/api/posts/upload")
//    public void upload(@RequestPart MultipartFile files){
//        try{
//            String baseDir = "D:\\temp";
//            files.transferTo(new File(baseDir + "\\"+files.getOriginalFilename()));
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//    }
}

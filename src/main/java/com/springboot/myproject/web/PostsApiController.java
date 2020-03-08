package com.springboot.myproject.web;

import com.springboot.myproject.service.PostsService;
import com.springboot.myproject.web.dto.PostsDownloadInfoDto;
import com.springboot.myproject.web.dto.PostsResponseDto;
import com.springboot.myproject.web.dto.PostsUpdateRequestDto;
import com.springboot.myproject.web.dto.PostsWriteRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;


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

    // 파일다운로드
    @GetMapping("/api/posts/download")
    public void download(@RequestParam("id") Long id, HttpServletResponse response) throws IOException {
        PostsDownloadInfoDto dto = postsService.fileInfo(id);
        response.setContentType("application/octet-stream");
        String originalFileName = new String(dto.getOriginalFileName().getBytes("UTF-8"), "iso-8859-1");
        // 파일명 지정
        response.setHeader("Content-Disposition", "attachment; filename=\""+originalFileName+"\"");
        OutputStream os = response.getOutputStream();
//        String path = "D:/upload";
        String path = "/home/ec2-user/upload";
        // 실제파일 가지고 오기
        FileInputStream fis = new FileInputStream(path + File.separator + dto.getStoredFileName());
        int n = 0;
        byte[] b = new byte[512];
        while((n = fis.read(b)) != -1 ) {
            os.write(b, 0, n);
        }
        fis.close();
        os.close();
    }
}

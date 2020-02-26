package com.springboot.myproject.web;

import com.springboot.myproject.service.CommentService;
import com.springboot.myproject.web.dto.CommentReplyDto;
import com.springboot.myproject.web.dto.CommentWriteDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
public class CommentApiController {
    private final CommentService commentService;

    @PostMapping("/api/comment")
    public ModelAndView write(@Valid CommentWriteDto commentWriteDto){
        System.out.println("Author : "+commentWriteDto.getAuthor());
        System.out.println("Content : "+commentWriteDto.getContent());
        commentService.save(commentWriteDto);
        ModelAndView mav = new ModelAndView("redirect:/guest");
        return mav;
    }

    @PostMapping("/api/reply")
    public boolean reply(@RequestBody CommentReplyDto commentReplyDto){
        System.out.println("Run reply");
        System.out.println(commentReplyDto.getAuthor());
        System.out.println(commentReplyDto.getContent());
        commentService.reply(commentReplyDto);
        return true;
    }
}

package com.springboot.myproject.service;

import com.springboot.myproject.domain.comment.CommentRepository;
import com.springboot.myproject.web.dto.CommentReplyDto;
import com.springboot.myproject.web.dto.CommentResponseDto;
import com.springboot.myproject.web.dto.CommentWriteDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CommentService {
    private final CommentRepository commentRepository;

    // 댓글등록
    @Transactional
    public void save(CommentWriteDto commentWriteDto){
        commentRepository.write(commentWriteDto.getAuthor(),commentWriteDto.getContent());
    }
    // 답글등록
    @Transactional
    public void reply(CommentReplyDto replyDto) {
        stepModify(replyDto);
        System.out.println("indent = " + replyDto.getIndent());
        commentRepository.reply(replyDto.getAuthor(),replyDto.getContent(),replyDto.getGrp(),replyDto.getStep()+1,replyDto.getIndent()+1);
    }

    // 계층형을 위한 step update
    @Transactional
    public void stepModify(CommentReplyDto replyDto){
        commentRepository.stepModify(replyDto.getGrp(),replyDto.getStep());
    }

    // 댓글뷰
    @Transactional
    public List<CommentResponseDto> list(){
        return commentRepository.list().stream().map(comment -> new CommentResponseDto(comment)).collect(Collectors.toList());
    }
}

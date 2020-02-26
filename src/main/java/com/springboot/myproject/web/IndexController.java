package com.springboot.myproject.web;

import com.springboot.myproject.config.auth.LoginUser;
import com.springboot.myproject.config.auth.dto.SessionUser;
import com.springboot.myproject.service.CommentService;
import com.springboot.myproject.service.PostsService;
import com.springboot.myproject.web.dto.CommentWriteDto;
import com.springboot.myproject.web.dto.LoginDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@RequiredArgsConstructor
@Controller
public class IndexController {
    private final PostsService postsService;
    private final CommentService commentService;
    // index
    @GetMapping("/")
    public String index(Model model, @LoginUser SessionUser user){
        if(user != null){
            model.addAttribute("username", user.getName());
        }
        return "index";
    }

    // board
    @GetMapping("/board")
    public String board(HttpServletRequest request, Model model, @LoginUser SessionUser user){
        int id;
        if(request.getParameter("id")!=null){
            id = Integer.parseInt(request.getParameter("id"));
        }else{
            id = 1;
        }
        model.addAttribute("page",postsService.page(id));
        model.addAttribute("posts", postsService.findAllDesc(id));
        if(user != null){
            model.addAttribute("username", user.getName());
        }
        return "board";
    }

    // guest
    @GetMapping("/guest")
    public String guest(@ModelAttribute("form") CommentWriteDto commentWriteDto,
                        Model model, @LoginUser SessionUser user){
        model.addAttribute("comment", commentService.list());
        if(user != null){
            model.addAttribute("username", user.getName());
        }
        return "guest";
    }

    // contact
    @GetMapping("/contact")
    public String contact(Model model, @LoginUser SessionUser user){
        if(user != null){
            model.addAttribute("username", user.getName());
        }
        return "contact";
    }


    // 글쓰기
    @GetMapping("/write")
    public String write(Model model, @LoginUser SessionUser user){
        if(user != null){
            model.addAttribute("username", user.getName());
        }
        return "/write";
    }

    // 게시글
    @GetMapping("/contentView")
    public String view(@RequestParam Long id, Model model,@LoginUser SessionUser user){
        if(user != null){
            model.addAttribute("username", user.getName());
        }
        model.addAttribute("posts", postsService.findById(id));
        return "contentView";
    }

    // 글수정
    @GetMapping("/modify")
    public String modify(@RequestParam Long id, Model model, @LoginUser SessionUser user){
        if(user != null){
            model.addAttribute("username", user.getName());
        }
        model.addAttribute("posts", postsService.findById(id));
        return "modify";
    }

    // 로그인
    @GetMapping("/loginPage")
    public String login(@ModelAttribute("loginForm") LoginDto loginDto, Model model){
        return "loginPage";
    }

    // 회원가입
    @GetMapping("/register")
    public String register(){
        return "register";
    }

}

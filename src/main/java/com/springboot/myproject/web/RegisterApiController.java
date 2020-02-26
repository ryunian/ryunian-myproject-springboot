package com.springboot.myproject.web;

import com.springboot.myproject.service.RegisterService;
import com.springboot.myproject.web.dto.RegisterDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class RegisterApiController {
    private final RegisterService registerService;

    // 회원가입
    @PostMapping("/api/register")
    public boolean register(@RequestBody RegisterDto registerDto){
        if(registerService.check(registerDto.getId()) == 0){
            registerService.register(registerDto);
            return true;
        }
        return false;
    }

    // 중복체크
    @GetMapping("/api/check/{id}")
    public boolean check(@PathVariable String id){
        Long result = registerService.check(id);
        if(result != 0){
            return false;
        }
        return true;
    }
}

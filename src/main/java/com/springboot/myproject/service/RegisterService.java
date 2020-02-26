package com.springboot.myproject.service;

import com.springboot.myproject.config.auth.dto.SessionUser;
import com.springboot.myproject.domain.user.RegisteredUser;
import com.springboot.myproject.domain.user.RegisteredUserRepository;
import com.springboot.myproject.web.dto.LoginResponseDto;
import com.springboot.myproject.web.dto.RegisterDto;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpSession;

@Service
@RequiredArgsConstructor
public class RegisterService {
    private final RegisteredUserRepository registeredUserRepository;
    private final HttpSession httpSession;

    // 회원가입
    @Transactional
    public String register(RegisterDto registerDto) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        registerDto.setPw(passwordEncoder.encode(registerDto.getPw()));
        return registeredUserRepository.save(registerDto.toEntity()).getId();
    }

    // 중복체크
    @Transactional
    public Long check(String id) {
        return registeredUserRepository.countById(id);
    }

    // 로그인
    @Transactional
    public LoginResponseDto login(String id) {
        RegisteredUser entity = registeredUserRepository.login(id);
        if (entity == null) return null;
        LoginResponseDto responseDto = new LoginResponseDto(entity);
        SessionUser sessionUser = new SessionUser(responseDto.getName(), responseDto.getEmail());
        httpSession.setAttribute("user", sessionUser);
        return responseDto;
    }
}

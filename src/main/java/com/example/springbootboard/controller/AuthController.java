package com.example.springbootboard.controller;

import com.example.springbootboard.dto.TokenDto;
import com.example.springbootboard.dto.UserDto;
import com.example.springbootboard.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    @PostMapping("/signup")
    public ResponseEntity<UserDto.UserResponseDto> signup(@RequestBody UserDto.UserRequestDto requestDto) {
        return ResponseEntity.ok(authService.signup(requestDto));
    }

    @PostMapping("/login")
    public ResponseEntity<TokenDto.tokenResponseDto> login(@RequestBody UserDto.UserRequestDto requestDto) {
        return ResponseEntity.ok(authService.login(requestDto));
    }

    @PostMapping("/reissue")
    public ResponseEntity<TokenDto.tokenResponseDto> reissue(@RequestBody TokenDto.tokenRequestDto requestDto) {
        return ResponseEntity.ok(authService.reissue(requestDto));
    }
}

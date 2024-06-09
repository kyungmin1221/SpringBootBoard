package com.example.springbootboard.dto;

import com.example.springbootboard.constant.Authority;
import com.example.springbootboard.domain.User;
import lombok.*;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;


public class UserDto {

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class UserRequestDto {
        private String email;
        private String username;
        private String password;

        public User toUser(PasswordEncoder passwordEncoder) {
            return User.builder()
                    .email(email)
                    .username(username)
                    .password(passwordEncoder.encode(password))
                    .authority(Authority.ROLE_USER) // 기본 권한 설정
                    .build();
        }

        public UsernamePasswordAuthenticationToken toAuthentication() {
            return new UsernamePasswordAuthenticationToken(email, password);
        }
    }

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class UserResponseDto {
        private Long id;
        private String email;
        private String username;



        public UserResponseDto(User user) {
            this.id = user.getId();
            this.email = user.getEmail();
            this.username = user.getUsername();
        }


        public static UserResponseDto of(User user) {
            return UserResponseDto.builder()
                    .id(user.getId())
                    .email(user.getEmail())
                    .username(user.getUsername())
                    .build();
        }
    }
}

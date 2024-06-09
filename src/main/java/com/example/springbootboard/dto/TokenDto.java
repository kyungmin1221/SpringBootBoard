package com.example.springbootboard.dto;

import lombok.*;

public class TokenDto {



    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class tokenResponseDto {

        private String grantType;

        private String accessToken;

        private String refreshToken;

        private Long accessTokenExpiresIn;


    }
}

package com.example.springbootboard.dto;

import com.example.springbootboard.domain.PortFolio;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

public class PortFolioDto {

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class PortfolioRequestDto {

        @NotBlank
        private String title;

        @NotBlank
        private String content;

    }

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class PortfolioResponseDto {

        private String title;

        private String content;

        public PortfolioResponseDto(PortFolio portFolio) {
            this.title = portFolio.getTitle();
            this.content = portFolio.getContent();
        }
    }
}

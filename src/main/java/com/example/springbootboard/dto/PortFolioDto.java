package com.example.springbootboard.dto;

import com.example.springbootboard.domain.PortFolio;
import lombok.*;

public class PortFolioDto {

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class PortfolioRequestDto {

        private String title;

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

package com.example.springbootboard.dto;

import com.example.springbootboard.constant.Note;
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

        @NotBlank
        private Note note;

    }

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class PortfolioResponseDto {

        private String title;

        private String content;

        private String note;

        public PortfolioResponseDto(PortFolio portFolio) {
            this.title = portFolio.getTitle();
            this.content = portFolio.getContent();
            this.note = portFolio.getNote().name();
        }
    }
}

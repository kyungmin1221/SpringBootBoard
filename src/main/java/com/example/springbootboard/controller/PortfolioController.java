package com.example.springbootboard.controller;


import com.example.springbootboard.constant.Note;
import com.example.springbootboard.dto.PortFolioDto;
import com.example.springbootboard.service.PortfolioService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/portfolio")
public class PortfolioController {

    private final PortfolioService portfolioService;

    @PostMapping
    public ResponseEntity<PortFolioDto.PortfolioResponseDto> createPortfolio(
            @RequestBody @Valid PortFolioDto.PortfolioRequestDto requestDto,
            @RequestParam Long userId) {

        PortFolioDto.PortfolioResponseDto responseDto = portfolioService.createPortfolio(requestDto, userId);
        return ResponseEntity.ok(responseDto);
    }

    @GetMapping
    public ResponseEntity<List<PortFolioDto.PortfolioResponseDto>> getAllPortfolios() {
        List<PortFolioDto.PortfolioResponseDto> responseDtos = portfolioService.getAllPortfolios();
        return ResponseEntity.ok(responseDtos);
    }

    @GetMapping("/note")
    public ResponseEntity<List<PortFolioDto.PortfolioResponseDto>> getUserPortfolio(@RequestParam Note note)  {
        List<PortFolioDto.PortfolioResponseDto> results = portfolioService.getUserPortfolio(note);
        return ResponseEntity.ok(results);
    }

    @DeleteMapping("/{portfolioId}")
    public ResponseEntity<PortFolioDto.PortfolioDeleteDto> deletePortfolio(@PathVariable Long portfolioId) {
        PortFolioDto.PortfolioDeleteDto deleteDto = portfolioService.deletePortfolio(portfolioId);
        return ResponseEntity.ok(deleteDto);

    }
}

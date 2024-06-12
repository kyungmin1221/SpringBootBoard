package com.example.springbootboard.controller;


import com.example.springbootboard.domain.PortFolio;
import com.example.springbootboard.domain.User;
import com.example.springbootboard.dto.PortFolioDto;
import com.example.springbootboard.service.PortfolioService;
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
            @RequestBody PortFolioDto.PortfolioRequestDto requestDto,
            @RequestParam Long userId) {

        PortFolioDto.PortfolioResponseDto responseDto = portfolioService.createPortfolio(requestDto, userId);
        return ResponseEntity.ok(responseDto);
    }

    @GetMapping
    public ResponseEntity<List<PortFolioDto.PortfolioResponseDto>> getAllPortfolios() {
        List<PortFolioDto.PortfolioResponseDto> responseDtos = portfolioService.getAllPortfolios();
        return ResponseEntity.ok(responseDtos);
    }
}
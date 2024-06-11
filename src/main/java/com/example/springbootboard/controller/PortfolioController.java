package com.example.springbootboard.controller;


import com.example.springbootboard.service.PortfolioService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
@RequestMapping("/pofols")
public class PortfolioController {

    private final PortfolioService portfolioService;
}

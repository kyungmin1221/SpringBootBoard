package com.example.springbootboard.repository.query;

import com.example.springbootboard.constant.Note;
import com.example.springbootboard.dto.PortFolioDto;

import java.util.List;


public interface PortfolioRepositoryCustom {
    List<PortFolioDto.PortfolioResponseDto> getUserPortfolio(Note note);
}

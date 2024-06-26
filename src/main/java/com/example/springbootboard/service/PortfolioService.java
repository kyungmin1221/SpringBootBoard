package com.example.springbootboard.service;

import com.example.springbootboard.constant.Note;
import com.example.springbootboard.domain.PortFolio;
import com.example.springbootboard.domain.User;
import com.example.springbootboard.dto.PortFolioDto;
import com.example.springbootboard.repository.PortfolioRepository;
import com.example.springbootboard.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class PortfolioService {

    private final PortfolioRepository portfolioRepository;
    private final UserRepository userRepository;

    // 생성
    @Transactional
    public PortFolioDto.PortfolioResponseDto createPortfolio(PortFolioDto.PortfolioRequestDto requestDto, Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("유저를 찾을 수 없습니다."));

        PortFolio portFolio = PortFolio.builder()
                .title(requestDto.getTitle())
                .content(requestDto.getContent())
                .note(requestDto.getNote())
                .user(user)
                .build();

        portfolioRepository.save(portFolio);
        return new PortFolioDto.PortfolioResponseDto(portFolio);
    }

    @Cacheable(value = "portfolio", key = "'all'")
    public List<PortFolioDto.PortfolioResponseDto> getAllPortfolios() {
        List<PortFolio> portFolios = portfolioRepository.findAll();
        return portFolios.stream()
                .map(PortFolioDto.PortfolioResponseDto::new)
                .collect(Collectors.toList());
    }

    // 포트폴리오 종류로 동적 필터링
    public List<PortFolioDto.PortfolioResponseDto> getUserPortfolio(Note note) {
        return portfolioRepository.getUserPortfolio(note);
    }

    // 포폴 삭제
    @Transactional
    public PortFolioDto.PortfolioDeleteDto deletePortfolio(Long portfolioId) {
        portfolioRepository.deleteById(portfolioId);
        return new PortFolioDto.PortfolioDeleteDto("포트폴리오가 삭제되었습니다");
    }

}

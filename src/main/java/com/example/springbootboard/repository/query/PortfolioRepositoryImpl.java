package com.example.springbootboard.repository.query;

import com.example.springbootboard.constant.Note;
import com.example.springbootboard.domain.QPortFolio;
import com.example.springbootboard.dto.PortFolioDto;
import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
@RequiredArgsConstructor
public class PortfolioRepositoryImpl implements PortfolioRepositoryCustom {

    private final JPAQueryFactory queryFactory;
    private final QPortFolio portFolio = QPortFolio.portFolio;

    // 포트폴리오 유형에 따라 동적으로 구분
    public List<PortFolioDto.PortfolioResponseDto> getUserPortfolio(Note note) {

        return queryFactory
                .select(Projections.bean(PortFolioDto.PortfolioResponseDto.class,
                        portFolio.title.as("title"),
                        portFolio.content.as("content"),
                        portFolio.note.as("note"))
                )
                .from(portFolio)
                .where(noteEq(note))
                .fetch();
    }

    private BooleanExpression noteEq(Note note) {
        if(note == null) {
            return null;
        } else {
            return portFolio.note.eq(note);
        }
    }



}

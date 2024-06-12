package com.example.springbootboard.repository;

import com.example.springbootboard.domain.PortFolio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PortfolioRepository extends JpaRepository<PortFolio, Long> {

}

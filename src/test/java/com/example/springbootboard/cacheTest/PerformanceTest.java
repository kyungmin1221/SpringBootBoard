package com.example.springbootboard.cacheTest;

import com.example.springbootboard.service.PortfolioService;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class PerformanceTest {

    @Autowired
    private PortfolioService portfolioService;

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    private static final Long TEST_PORTFOLIO_ID = 1L;

    @Before
    public void setUp() {
        // Redis 캐시 비우기
        redisTemplate.getConnectionFactory().getConnection().flushDb();
    }

    @Test
    public void testPortfolioRetrievalPerformanceWithoutCache() {
        // Redis 캐시 비우기
        redisTemplate.getConnectionFactory().getConnection().flushDb();

        // 캐시 없이 첫 번째 조회 시간 측정
        long startTime = System.currentTimeMillis();
        portfolioService.getPortfolio(TEST_PORTFOLIO_ID);
        long endTime = System.currentTimeMillis();
        System.out.println("Time taken without cache: " + (endTime - startTime) + " ms");

        // 캐시 없이 두 번째 조회 시간 측정
        startTime = System.currentTimeMillis();
        portfolioService.getPortfolio(TEST_PORTFOLIO_ID);
        endTime = System.currentTimeMillis();
        System.out.println("Time taken without cache (second call): " + (endTime - startTime) + " ms");
    }

    @Test
    public void testPortfolioRetrievalPerformanceWithCache() {
        // 첫 번째 조회 시간 측정 (캐시 생성)
        long startTime = System.currentTimeMillis();
        portfolioService.getPortfolio(TEST_PORTFOLIO_ID);
        long endTime = System.currentTimeMillis();
        System.out.println("Time taken with cache (first call): " + (endTime - startTime) + " ms");

        // 두 번째 조회 시간 측정 (캐시 사용)
        startTime = System.currentTimeMillis();
        portfolioService.getPortfolio(TEST_PORTFOLIO_ID);
        endTime = System.currentTimeMillis();
        System.out.println("Time taken with cache (second call): " + (endTime - startTime) + " ms");
    }
}


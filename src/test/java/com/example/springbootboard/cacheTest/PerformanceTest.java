package com.example.springbootboard.cacheTest;

import com.example.springbootboard.service.PortfolioService;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Objects;

@SpringBootTest
@RunWith(SpringRunner.class)
public class PerformanceTest {

    @Autowired
    private PortfolioService portfolioService;

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;


    @Before
    public void setUp() {
        // Redis 캐시 비우기
        Objects.requireNonNull(redisTemplate.getConnectionFactory()).getConnection().serverCommands();
    }

    @Test
    public void testGetAllPortfoliosWithoutCache() {
        // Redis 캐시 비우기
        Objects.requireNonNull(redisTemplate.getConnectionFactory()).getConnection().serverCommands();

        // 캐시 없이 첫 번째 조회 시간 측정
        long startTime = System.currentTimeMillis();
        portfolioService.getAllPortfolios();
        long endTime = System.currentTimeMillis();
        System.out.println("캐시를 적용하지 않았을 때 시간: " + (endTime - startTime) + " ms");

        // 캐시 없이 두 번째 조회 시간 측정
        startTime = System.currentTimeMillis();
        portfolioService.getAllPortfolios();
        endTime = System.currentTimeMillis();
        System.out.println("캐시를 적용하지 않았을 때 시간 (두번 째 호출 시간): " + (endTime - startTime) + " ms");
    }

    @Test
    public void testGetAllPortfoliosWithCache() {
        // 첫 번째 조회 시간 측정 (캐시 생성)
        long startTime = System.currentTimeMillis();
        portfolioService.getAllPortfolios();
        long endTime = System.currentTimeMillis();
        System.out.println("캐시를 적용했을 때 시간(첫번 째 호출 시간): " + (endTime - startTime) + " ms");

        // 두 번째 조회 시간 측정 (캐시 사용)
        startTime = System.currentTimeMillis();
        portfolioService.getAllPortfolios();
        endTime = System.currentTimeMillis();
        System.out.println("캐시를 적용했을 때 시간(두번 째 호출 시간): " + (endTime - startTime) + " ms");
    }

}


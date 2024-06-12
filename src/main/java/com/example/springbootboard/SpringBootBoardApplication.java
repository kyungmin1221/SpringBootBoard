package com.example.springbootboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableCaching
@SpringBootApplication
public class SpringBootBoardApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootBoardApplication.class, args);
    }

}

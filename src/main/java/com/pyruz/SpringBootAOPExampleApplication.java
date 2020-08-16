package com.pyruz;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringBootAOPExampleApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringBootAOPExampleApplication.class, args);
    }

    @Bean
    public Logger logger() {
        return LoggerFactory.getLogger(SpringBootAOPExampleApplication.class);
    }
}
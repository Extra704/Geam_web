package com.example.geamweb;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.geamweb.mapper")
public class GeamWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(GeamWebApplication.class, args);
    }
}

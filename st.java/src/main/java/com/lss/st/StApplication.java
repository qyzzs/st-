package com.lss.st;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.lss.st.dao")
public class StApplication {

    public static void main(String[] args) {
        SpringApplication.run(StApplication.class, args);
    }

}

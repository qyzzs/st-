package com.lss.st;

import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@MapperScan("com.lss.st.dao")
class StApplicationTests {

    @Test
    void contextLoads() {
    }

}

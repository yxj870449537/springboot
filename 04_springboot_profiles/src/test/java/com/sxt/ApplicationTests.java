package com.sxt;

import com.sxt.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ApplicationTests {

    private User user;
    @Test
    void contextLoads() {
        System.out.println(user);
    }

}

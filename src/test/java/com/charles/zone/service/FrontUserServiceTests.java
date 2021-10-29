package com.charles.zone.service;

import com.charles.zone.domain.FrontUser;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class FrontUserServiceTests {

    @Autowired
    private FrontUserService frontUserService;

    @Test
    public void isUsernameDuplicated(){
        System.out.println(frontUserService.isUsernameDuplicated("Jerry"));
    }

    @Test
    public void register(){
        FrontUser frontUser = new FrontUser();
        frontUser.setUsername("Jerry");
        frontUser.setPassword("111111");
        frontUserService.register(frontUser);
    }

    @Test
    public void login(){
        FrontUser frontUser = new FrontUser();
        frontUser.setUsername("James");
        frontUser.setPassword("111111");
        FrontUser result = frontUserService.login(frontUser);
        System.out.println(result);
    }
}

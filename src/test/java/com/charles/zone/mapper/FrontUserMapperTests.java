package com.charles.zone.mapper;

import com.charles.zone.domain.FrontUser;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;

@SpringBootTest
public class FrontUserMapperTests {

    @Autowired
    private FrontUserMapper frontUserMapper;

    @Test
    public void insert(){
        FrontUser frontUser = new FrontUser();
        frontUser.setUuid(UUID.randomUUID().toString().toUpperCase());
        frontUser.setUsername("Tom");
        frontUser.setPassword("111111");
        Integer rows = frontUserMapper.insert(frontUser);
        System.out.println(rows);

    }

    @Test
    public void findByUsername(){
        FrontUser frontUser = frontUserMapper.findByUsername("Tom");
        System.out.println(frontUser);
    }
}

package com.charles.zone.service;

import com.charles.zone.mapper.CommentMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CommentServiceTests {
    @Autowired
    private CommentService commentService;

    @Test
    public void findAll(){
        System.out.println(commentService.findAll("065c1f53-8926-4171-a599-8a8eef77121a"));
    }
}

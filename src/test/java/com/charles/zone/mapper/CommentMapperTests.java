package com.charles.zone.mapper;

import com.charles.zone.domain.Comment;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class CommentMapperTests {

    @Autowired
    private CommentMapper commentMapper;

    @Test
    public void findByPostUuid(){
        List<Comment> commentList = commentMapper.findByPostUuId("df03d25f-e6ad-544c-868b-1e4cdc961836");
        System.out.println(commentList);
    }

    @Test
    public void findChildrenByRootId(){
        List<Comment> commentList = commentMapper.findChildrenByRootId(7);
        System.out.println(commentList);
    }
}

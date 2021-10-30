package com.charles.zone.mapper;

import com.charles.zone.domain.Comment;
import com.charles.zone.domain.FrontUser;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@SpringBootTest
public class CommentMapperTests {

    @Autowired
    private CommentMapper commentMapper;

    @Autowired
    private FrontUserMapper frontUserMapper;

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

    @Test
    public void insert(){
        FrontUser frontUser = frontUserMapper.findByUsername("James");

        Comment comment = new Comment();
        comment.setUuid(UUID.randomUUID().toString());
        comment.setContent("鸡你太美！");
        comment.setPostUuid("0babd385-b710-5cb8-9ff2-7089b596469d");
        comment.setAuthor(frontUser);
        comment.setIsRoot(1);
        comment.setCreatedTime(new Date());
        Integer rows = commentMapper.insert(comment);
        System.out.println(rows);

    }

    @Test
    public void findById(){
        Comment comment = commentMapper.findById(16);
        System.out.println(comment);
    }
}

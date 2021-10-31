package com.charles.zone.mapper;

import com.charles.zone.domain.Board;
import com.charles.zone.domain.FrontUser;
import com.charles.zone.domain.Post;
import com.charles.zone.mapper.BoardMapper;
import com.charles.zone.mapper.FrontUserMapper;
import com.charles.zone.mapper.PostMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.List;

@SpringBootTest
public class PostMapperTests {
    @Autowired
    private PostMapper postMapper;

    @Autowired
    private FrontUserMapper frontUserMapper;

    @Autowired
    private BoardMapper boardMapper;

    @Test
    public void insert(){
        FrontUser frontUser = frontUserMapper.findByUsername("Tom");
        List<Board> boardList = boardMapper.findAll();

        Post post = new Post();
        post.setTitle("python");
        post.setContent("pythonpythonpythonpythonpythonpythonpythonpythonpythonpythonpython");
        post.setAuthor(frontUser);
        post.setBoard(boardList.get(0));
        post.setCreatedTime(new Date());
        post.setViewCount(0);

        Integer rows = postMapper.insert(post);
        System.out.println(rows);
    }


    @Test
    public void findAll(){
        List<Post> postList = postMapper.findAll(null);
        System.out.println(postList);
        //System.out.println(postList.get(0).getUuid().equals("73dbc7fb-a7b9-4200-b5e9-782d3c0a9598"));
    }

    @Test
    public void findByUuid(){
        Post post = postMapper.findByUuid("73dbc7fb-a7b9-4200-b5e9-782d3c0a9598");
        System.out.println(post);
    }
}

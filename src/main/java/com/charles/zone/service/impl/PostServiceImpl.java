package com.charles.zone.service.impl;

import com.charles.zone.domain.Post;
import com.charles.zone.mapper.PostMapper;
import com.charles.zone.service.PostService;
import com.charles.zone.service.ex.InsertException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {
    @Autowired
    private PostMapper postMapper;

    @Override
    public void add(Post post) {
        Integer rows = postMapper.insert(post);
        if(rows != 1){
            throw new InsertException("数据插入异常");
        }
    }

    @Override
    public List<Post> list(Integer boardId) {
        return postMapper.findAll(boardId);
    }

    @Override
    public Post findByUuid(String uuid) {
        return postMapper.findByUuid(uuid);
    }
}

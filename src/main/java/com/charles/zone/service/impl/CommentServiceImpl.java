package com.charles.zone.service.impl;

import com.charles.zone.domain.Comment;
import com.charles.zone.mapper.CommentMapper;
import com.charles.zone.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    private CommentMapper commentMapper;

    @Override
    public List<Comment> findAll(String uuid) {
        List<Comment> rootCommentList = commentMapper.findByPostUuId(uuid);
        for (Comment rootComment : rootCommentList) {
            List<Comment> childrenCommentList = commentMapper.findChildrenByRootId(rootComment.getId());
            rootComment.setChildren(childrenCommentList);
        }
        return rootCommentList;
    }
}

package com.charles.zone.service;

import com.charles.zone.domain.Comment;

import java.util.List;

public interface CommentService {
    List<Comment> findAll(String uuid);

    void save(Comment comment);
}

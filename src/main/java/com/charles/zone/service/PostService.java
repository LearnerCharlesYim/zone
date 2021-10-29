package com.charles.zone.service;

import com.charles.zone.domain.Post;

import java.util.List;

public interface PostService {
    void add(Post post);

    List<Post> list();

    Post findByUuid(String uuid);
}

package com.charles.zone.mapper;

import com.charles.zone.domain.Post;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PostMapper {
    Integer insert(Post post);

    List<Post> findAll();

    Post findByUuid(String uuid);
}

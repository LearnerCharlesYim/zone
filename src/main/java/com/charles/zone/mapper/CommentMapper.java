package com.charles.zone.mapper;

import com.charles.zone.domain.Comment;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CommentMapper {

    List<Comment> findByPostUuId(String uuid);

    List<Comment> findChildrenByRootId(Integer id);

    Integer insert(Comment comment);

    Comment findById(Integer id);

}

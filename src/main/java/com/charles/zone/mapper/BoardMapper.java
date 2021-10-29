package com.charles.zone.mapper;

import com.charles.zone.domain.Board;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardMapper {
    List<Board> findAll();

    Board findById(Integer id);
}

package com.charles.zone.service;

import com.charles.zone.domain.Board;

import java.util.List;

public interface BoardService {
    List<Board> findAll();

    Board findById(Integer id);
}

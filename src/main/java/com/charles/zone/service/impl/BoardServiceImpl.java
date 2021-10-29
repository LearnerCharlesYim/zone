package com.charles.zone.service.impl;

import com.charles.zone.domain.Board;
import com.charles.zone.mapper.BoardMapper;
import com.charles.zone.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardServiceImpl implements BoardService {

    @Autowired
    private BoardMapper boardMapper;

    @Override
    public List<Board> findAll() {
        return boardMapper.findAll();
    }

    @Override
    public Board findById(Integer id) {
        return boardMapper.findById(id);
    }
}

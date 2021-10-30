package com.charles.zone.controller;

import com.charles.zone.domain.Board;
import com.charles.zone.service.BoardService;
import com.charles.zone.utils.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BoardController extends BaseController{

    @Autowired
    private BoardService boardService;

    @GetMapping("/getBoardList")
    public JsonResult<List<Board>> getBoardList(){
        List<Board> boardList = boardService.findAll();
        JsonResult<List<Board>> result = new JsonResult<>();
        result.setState(200);
        result.setData(boardList);
        return result;
    }
}

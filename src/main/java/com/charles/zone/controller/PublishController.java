package com.charles.zone.controller;

import com.charles.zone.domain.Board;
import com.charles.zone.domain.FrontUser;
import com.charles.zone.domain.Post;
import com.charles.zone.service.BoardService;
import com.charles.zone.service.PostService;
import com.charles.zone.utils.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Controller
public class PublishController extends BaseController{

    @Autowired
    private BoardService boardService;

    @Autowired
    private PostService postService;

    @GetMapping("/publish")
    public String publish(Model model){
        List<Board> boardList = boardService.findAll();
        model.addAttribute("boardList",boardList);
        return "publish";
    }

    @PostMapping("/publish")
    @ResponseBody
    public JsonResult<Void> addPost(Post post, Integer boardId, HttpSession session){
        FrontUser frontUser = getUserFromSession(session);
        post.setAuthor(frontUser);
        Board board = boardService.findById(boardId);
        post.setBoard(board);
        post.setViewCount(0);
        post.setCreatedTime(new Date());
        post.setUuid(UUID.randomUUID().toString());
        postService.add(post);
        return new JsonResult<Void>(OK);
    }
}

package com.charles.zone.controller;

import com.charles.zone.domain.Comment;
import com.charles.zone.service.CommentService;
import com.charles.zone.utils.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/comment")
public class CommentController {
    @Autowired
    private CommentService commentService;

    @GetMapping("/list/{uuid}")
    public JsonResult<List<Comment>> list(@PathVariable("uuid") String uuid){
        List<Comment> commentList = commentService.findAll(uuid);
        JsonResult<List<Comment>> result = new JsonResult<>();
        result.setState(200);
        result.setData(commentList);
        return result;
    }

}

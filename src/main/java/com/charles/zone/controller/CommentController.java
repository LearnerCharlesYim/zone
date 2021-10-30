package com.charles.zone.controller;

import com.charles.zone.domain.Comment;
import com.charles.zone.domain.FrontUser;
import com.charles.zone.service.CommentService;
import com.charles.zone.service.FrontUserService;
import com.charles.zone.utils.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/comment")
public class CommentController extends BaseController{
    @Autowired
    private CommentService commentService;

    @Autowired
    private FrontUserService frontUserService;

    @GetMapping("/list/{uuid}")
    public JsonResult<List<Comment>> list(@PathVariable("uuid") String uuid) {
        List<Comment> commentList = commentService.findAll(uuid);
        JsonResult<List<Comment>> result = new JsonResult<>();
        result.setState(200);
        result.setData(commentList);
        return result;
    }

    @PostMapping("/add")
    public JsonResult<Void> add(String postUuid,
                                   String replyAuthor,
                                   Integer commentId,
                                   String content,
                                   HttpSession session) {
        FrontUser frontUser = getUserFromSession(session);
        Comment comment = new Comment();
        comment.setUuid(UUID.randomUUID().toString());
        comment.setContent(content);
        comment.setPostUuid(postUuid);
        comment.setAuthor(frontUser);
        comment.setCreatedTime(new Date());
        if (replyAuthor == null && commentId == null){
            comment.setIsRoot(1);
        }else{
            comment.setIsRoot(0);
            comment.setRootCommentId(commentId);
            comment.setReplyToAuthor(frontUserService.findByUsername(replyAuthor));
        }
        commentService.save(comment);
        JsonResult<Void> result = new JsonResult<>();
        result.setState(200);
        return result;
    }

}

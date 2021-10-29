package com.charles.zone.controller;

import com.charles.zone.domain.Post;
import com.charles.zone.service.PostService;
import com.charles.zone.utils.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/post")
public class PostController {

    @Autowired
    private PostService postService;

    @GetMapping("/list")
    public JsonResult<List<Post>> list(){
        List<Post> postList = postService.list();
        JsonResult<List<Post>> result = new JsonResult<>();
        result.setState(200);
        result.setData(postList);
        return result;
    }

    @GetMapping("/{uuid}")
    public JsonResult<Post> detail(@PathVariable(value = "uuid") String uuid){
        Post post = postService.findByUuid(uuid);
        JsonResult<Post> result = new JsonResult<>();
        result.setState(200);
        result.setData(post);
        return result;
    }
}

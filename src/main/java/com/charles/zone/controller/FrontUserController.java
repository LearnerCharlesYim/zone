package com.charles.zone.controller;


import com.charles.zone.domain.FrontUser;
import com.charles.zone.service.FrontUserService;
import com.charles.zone.utils.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/frontUser")
public class FrontUserController extends BaseController{

    @Autowired
    private FrontUserService frontUserService;

    @RequestMapping("/checkUsername")
    @ResponseBody
    public JsonResult<Void> checkUsername(String username){
        Boolean isDuplicated = frontUserService.isUsernameDuplicated(username);
        JsonResult<Void> jsonResult = new JsonResult<>();
        if(! isDuplicated){
            jsonResult.setState(OK);
        }
        return jsonResult;
    }

    @PostMapping("/register")
    @ResponseBody
    public JsonResult<Void> register(FrontUser frontUser){
        frontUserService.register(frontUser);
        return new JsonResult<Void>(OK);
    }

    @PostMapping("/login")
    @ResponseBody
    public JsonResult<Void> login(FrontUser frontUser, HttpSession session){
        FrontUser result = frontUserService.login(frontUser);
        session.setAttribute("frontUser",result);
        return new JsonResult<>(OK);
    }

    @PostMapping("/logout")
    @ResponseBody
    public JsonResult<Void> logout(HttpSession session){
        frontUserService.logout(session);
        return new JsonResult<>(OK);
    }
}

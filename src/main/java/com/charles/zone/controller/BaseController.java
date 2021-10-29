package com.charles.zone.controller;

import com.charles.zone.controller.ex.FileEmptyException;
import com.charles.zone.controller.ex.FileStateException;
import com.charles.zone.controller.ex.FileUploadException;
import com.charles.zone.controller.ex.FileUploadIOException;
import com.charles.zone.domain.FrontUser;
import com.charles.zone.service.ex.*;
import com.charles.zone.utils.JsonResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;


import javax.servlet.http.HttpSession;


public class BaseController {
    public static final int OK = 200;

    @ResponseBody
    @ExceptionHandler({ServiceException.class, FileUploadException.class})
    public JsonResult<Void> handleException(Throwable e) {
        JsonResult<Void> result = new JsonResult<>();
        if (e instanceof UsernameDuplicatedException) {
            result.setState(4000);
            result.setMessage("用户名已被占用");
        } else if (e instanceof InsertException) {
            result.setState(5000);
            result.setMessage("注册时产生未知错误");
        } else if (e instanceof UserNotFoundException) {
            result.setState(5001);
            result.setMessage("用户名不存在");
        } else if (e instanceof UserNotActiveException) {
            result.setState(5002);
            result.setMessage("该用户已被封禁，请联系管理员");
        } else if (e instanceof PasswordNotMatchException) {
            result.setState(5003);
            result.setMessage("用户名或密码错误");
        } else if (e instanceof LogoutException) {
            result.setState(5004);
            result.setMessage("没有访问权限");
        } else if (e instanceof FileStateException) {
            result.setState(5005);
            result.setMessage("文件状态异常，可能文件已被移动或删除");
        } else if (e instanceof FileUploadIOException) {
            result.setState(5006);
            result.setMessage("上传文件时读写错误，请稍后重尝试");
        } else if (e instanceof FileEmptyException) {
            result.setState(5007);
            result.setMessage("上传文件为空");
        }
        return result;
    }

    public FrontUser getUserFromSession(HttpSession session) {
        return session.getAttribute("frontUser") != null ? (FrontUser) session.getAttribute("frontUser") :null;
    }

}

package com.charles.zone.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/error")
public class ErrorController {
    @RequestMapping("/405")
    public String Error405(){
        return "error/405";
    }

    @RequestMapping("/404")
    public String Error404(){
        return "error/404";
    }

}

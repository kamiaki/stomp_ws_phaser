package com.cnblogs.yjmyzz.websocket.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {

    @RequestMapping(value = "")
    public String index(){
        return "index";
    }

    @RequestMapping(value = "game")
    public String game(){
        return "game";
    }
}

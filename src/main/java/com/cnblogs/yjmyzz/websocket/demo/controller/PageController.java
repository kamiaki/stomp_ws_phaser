package com.cnblogs.yjmyzz.websocket.demo.controller;

import com.cnblogs.yjmyzz.websocket.demo.consts.GlobalConsts;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {
    @RequestMapping(value = "game")
    public String game(Model model){
        model.addAttribute("connect", GlobalConsts.connect);
        model.addAttribute("subM", GlobalConsts.subM);
        model.addAttribute("mappingM", GlobalConsts.mappingM);
        model.addAttribute("sub1", GlobalConsts.sub1);
        model.addAttribute("mapping1", GlobalConsts.mapping1);
        return "game";
    }
}

package com.xiang.shiro.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author longxiang
 * @Description
 * @create 2022/3/6 18:41
 */
@Controller
public class MyController {

    @RequestMapping({"/","index","index.html"})
    public String toIndex(Model model){
        model.addAttribute("msg","hello,shiro");
        return "index";
    }

    @RequestMapping("user/add")
    public String toAdd(){
        return "user/add";
    }

    @RequestMapping("user/update")
    public String toUpdate(){
        return "user/update";
    }
}

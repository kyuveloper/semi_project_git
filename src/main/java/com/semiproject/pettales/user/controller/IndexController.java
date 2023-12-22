package com.semiproject.pettales.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {

    @RequestMapping("/index")
    public String index() {
        return "/";
    }

    @GetMapping("comInfo")
    public String comInfo() {
        return "schedule/com_info";
    }

    @GetMapping
    public String root(){
        return "index";
    }

    @GetMapping("/admin/page") // 관리자 페이지로 이동
    public ModelAndView admnin(ModelAndView mv){
        mv.setViewName("admin/admin");
        return mv;
    }

    @GetMapping("/user/page") // 사용자 페이지로 이동
    public ModelAndView user(ModelAndView mv){
        mv.setViewName("/user/user");
        return mv;
    }

}
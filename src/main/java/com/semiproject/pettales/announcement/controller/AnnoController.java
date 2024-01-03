package com.semiproject.pettales.announcement.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AnnoController {

    @GetMapping("anno")
    public String annoList() {
        return "announcement/announcement";
    }
}

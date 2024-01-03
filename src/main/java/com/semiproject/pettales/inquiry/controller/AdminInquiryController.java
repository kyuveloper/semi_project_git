package com.semiproject.pettales.inquiry.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminInquiryController {

    @GetMapping("/inquirystatus")
    public String inquryList() {
        return "inquiry/inquiryList";
    }
}

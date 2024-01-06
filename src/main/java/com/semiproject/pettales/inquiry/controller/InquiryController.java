package com.semiproject.pettales.inquiry.controller;

import com.semiproject.pettales.inquiry.dto.InquiryDTO;
import com.semiproject.pettales.inquiry.service.InquiryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class InquiryController {

    @Autowired
    private InquiryService inquiryService;

    @GetMapping("inquiryPage")
    public String insert() {
        return "inquiry/insertInquiry";
    }

    @PostMapping("insertInquiry")
    public String insertInquiry(InquiryDTO inquiryDTO) {
        inquiryService.insertInquiry(inquiryDTO);
        return "redirect:/";
    }

}

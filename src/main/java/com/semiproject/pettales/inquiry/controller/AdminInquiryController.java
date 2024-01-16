//package com.semiproject.pettales.inquiry.controller;
//
//import com.semiproject.pettales.inquiry.dto.InquiryDTO;
//import com.semiproject.pettales.inquiry.service.InquiryService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//@Controller
//@RequestMapping("/admin")
//public class AdminInquiryController {
//
//    @Autowired
//    private InquiryService inquiryService;
//
//    @GetMapping("/inquirystatus")
//    public String inquryList() {
//        return "inquiry/inquiryList";
//    }
//
//    @GetMapping("/inquiry/inquiryAns")
//    public String inquiryAns() {
//        return "inquiry/inquiryAns";
//    }
//
//    @PostMapping("/inquiry/updateInqAns")
//    public String inquiryAns(InquiryDTO inquiryDTO) {
//        inquiryService.updateInqAns(inquiryDTO);
//
//        return "index";
//    }
//
//
//}

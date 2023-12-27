package com.semiproject.pettales.auth.controller;

import com.semiproject.pettales.auth.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController //비동기는 restcontroller쓴다
@RequestMapping("/user")
public class SignupController {
    @Autowired
    private MemberService memberService;
    // 이메일 중복체크
    @PostMapping("/email-check")
    public int emailCheck(@RequestParam("memberEmail") String memberEmail){
        System.out.println(memberEmail);
        System.out.println("memeberEmail = " + memberEmail); //제대로 오는지 확인용

        int checkResult = memberService.emailCheck(memberEmail);

        return checkResult;
    }
}

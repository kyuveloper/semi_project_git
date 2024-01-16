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

    // 닉네임 중복체크
    @PostMapping("/nickName-check")
    public int nickNameCheck(@RequestParam("memberNickName") String memberNickName) {
        System.out.println(memberNickName);
        System.out.println("memberNickName = " + memberNickName);

        int checkResult2 = memberService.nickNameCheck(memberNickName);

        return checkResult2;
    }

    @PostMapping("/check-answer")
    public int checkAnswer(@RequestParam("userEmail") String userEmail, @RequestParam("answer") String answer){
        System.out.println(userEmail);
        System.out.println(answer);
        System.out.println("userEmail = " + userEmail + "answer = " + answer);

        int checkResult3 = memberService.checkAnswer(userEmail, answer);

        return checkResult3;
    }

}

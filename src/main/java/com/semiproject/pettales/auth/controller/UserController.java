package com.semiproject.pettales.auth.controller;

import com.semiproject.pettales.auth.service.MemberService;
import com.semiproject.pettales.user.model.dto.LoginUserDTO;
import com.semiproject.pettales.user.model.dto.SignupDTO;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.naming.Binding;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// 회원가입 요청을 받음

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private MemberService memberService;

    //회원가입
    @GetMapping("/signup")
    public void signup(){

    }

    @PostMapping("/signup")
    public ModelAndView signup(@ModelAttribute @Valid SignupDTO signupDTO, ModelAndView mv, BindingResult bindingResult){

//        memberService.checkEmailDuplication(signupDTO);
//        memberService.checkNickName(signupDTO);
//
//        memberService.regist(signupDTO);

        //검증
//        if(bindingResult.hasErrors()){
//            //에러 메세지
//            Map<String, String> errorMap = new HashMap<>();
//
//            for (FieldError error : bindingResult.getFieldErrors()){
//                errorMap.put("valid_"+error.getField(),error.getDefaultMessage());
//            }
//            mv.addObject("errorMap",errorMap);
//            mv.setViewName("user/signup");
//        }

        int result = memberService.regist(signupDTO);

        String message;
        if(result>0){
            message = "회원가입 완료";
            mv.setViewName("auth/clearSignup");
        }else {
            message = "회원가입 실패";
            mv.setViewName("auth/fail");
        }
        System.out.println(result);
        mv.addObject("message",message);

        return mv;
    }

    @GetMapping("/find-pass")
    public void findPass(){

    }

    @PostMapping("/find-pass")
    public ModelAndView findPass(ModelAndView mv, @ModelAttribute LoginUserDTO loginUserDTO){
//        System.out.println(loginUserDTO.getPassword());
        System.out.println(loginUserDTO);

        int result = memberService.changePassword(loginUserDTO);

        String message;
        if(result > 0){
            message = "비밀번호 변경 완료";
            mv.setViewName("auth/clearChangePass");
        }else {
            message = "비밀번호 변경 실패";
            mv.setViewName("auth/failChangePass");
        }
        System.out.println(result);
        mv.addObject("message", message);

        return mv;
    }

}
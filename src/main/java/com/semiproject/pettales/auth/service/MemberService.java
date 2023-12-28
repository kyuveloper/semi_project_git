package com.semiproject.pettales.auth.service;

import com.semiproject.pettales.user.dao.UserMapper;
import com.semiproject.pettales.user.model.dto.LoginUserDTO;
import com.semiproject.pettales.user.model.dto.SignupDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

// 로그인과 회원가입을 처리 하는 기능

@Service
public class MemberService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private PasswordEncoder encoder;

    public LoginUserDTO findByUserNickName(String userNickName){ // 닉네임으로 사용자를 찾음 찾은거로 AuthService에서 로그인함

        LoginUserDTO login = userMapper.findByUserNickName(userNickName);
        System.out.println(login);
        if(!Objects.isNull(login)){
            System.out.println("있");
            return login;
        }else{
            System.out.println("없");
            return null;
        }
    }

    @Transactional
    public int regist(SignupDTO signupDTO){ // 회원가입
        signupDTO.setPassword(encoder.encode(signupDTO.getPassword()));
        int result = userMapper.regist(signupDTO);

        return result;
    }

    //이메일체크
    public int emailCheck(String memberEmail) {
//        userMapper.findByUserNickName(memberEmail);
        LoginUserDTO loginUserDTO = userMapper.findByUserEmail(memberEmail);
        if (loginUserDTO == null) {
            return 1;
        } else {
            return 0;
        }
    }
    //닉네임 체크
    public int nickNameCheck(String memberNickName) {
        LoginUserDTO loginUserDTO = userMapper.findByUserNickName(memberNickName);
        if (loginUserDTO == null){
            return 1;
        } else {
            return 0;
        }
    }

    public LoginUserDTO findByUserEmail(String userEmail) {
        LoginUserDTO login = userMapper.findByUserEmail(userEmail);
        System.out.println(login);
        if(!Objects.isNull(login)){
            System.out.println("있");
            return login;
        }else{
            System.out.println("없");
            return null;
        }
    }
}
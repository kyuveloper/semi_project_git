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

    public LoginUserDTO findByUserEmail(String userEmail) { //이메일에 해당하는 사람 찾기
        LoginUserDTO login = userMapper.findByUserEmail(userEmail);

        System.out.println(login);

        System.out.println("login : " + login);

        if (!Objects.isNull(login)) {
            System.out.println("있");
            return login;
        } else {
            System.out.println("없");
            return null;
        }
    }


//    public LoginUserDTO findByUserNickName(String userNickName){
//
//        LoginUserDTO login = userMapper.findByUserNickName(userNickName);
//        System.out.println(login);
//        if(!Objects.isNull(login)){
//            System.out.println("있");
//            return login;
//        }else{
//            System.out.println("없");
//            return null;
//        }
//    }


    @Transactional
    public int regist(SignupDTO signupDTO) { // 회원가입
        signupDTO.setPassword(encoder.encode(signupDTO.getPassword()));

        int result = userMapper.regist(signupDTO);

        return result;
    }

    @Transactional
    public int changePassword(LoginUserDTO loginUserDTO){ // 비밀번호 수정
        loginUserDTO.setPassword(encoder.encode(loginUserDTO.getPassword()));
        System.out.println(loginUserDTO);
        int result = userMapper.changePassword(loginUserDTO);

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
        System.out.println(loginUserDTO);
        if (loginUserDTO == null) {
            return 1;
        } else {
            return 0;
        }
    }

    public LoginUserDTO selectUserByUserCode(int userCode){
        return userMapper.selectUserByUserCode(userCode);
    }



    public int checkAnswer(String userEmail, String answer) { //입력한 답이 일치하는지 확인
        LoginUserDTO loginUserDTO = userMapper.findUserByEmailAndAnswer(userEmail, answer);
        System.out.println(loginUserDTO);
        if (loginUserDTO != null) {
            return 1;
        } else {
            return 0;
        }
    }

//    진짜 중복체크
//    @Transactional(readOnly = true)
//    public void checkEmailDuplication(SignupDTO signupDTO) {
//        boolean emailDuplicate = userMapper.existByUserEmail(signupDTO.getUserEmail());
//        if (emailDuplicate){
//            throw new IllegalStateException("이미 존재하는 이메일 입니다.");
//        }
//    }
//
//    @Transactional(readOnly = true)
//    public void checkNickName(SignupDTO signupDTO){
//        boolean nickNameDuplication = userMapper.existByUserNickName(signupDTO.getUserNickName());
//        if (nickNameDuplication) {
//            throw new IllegalStateException("이미 존재하는 닉네임 입니다.");
//        }
//    }


}
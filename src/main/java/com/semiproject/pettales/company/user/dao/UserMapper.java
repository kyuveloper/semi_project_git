package com.semiproject.pettales.company.user.dao;

import com.semiproject.pettales.company.user.model.dto.LoginUserDTO;
import com.semiproject.pettales.company.user.model.dto.SignupDTO;
import org.apache.ibatis.annotations.Mapper;

// 데이터베이스와 연동해줌

@Mapper
public interface UserMapper {
    LoginUserDTO findByUserNickName(String userNickName); //닉네임에 해당하는 사용자 찾기

    int regist(SignupDTO signupDTO); //회원가입

    int emailCheck(String userEmail);


    //이넘에 정지기능 로그인실패시 정지유저라고 알람
}

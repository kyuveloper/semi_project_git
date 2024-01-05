package com.semiproject.pettales.user.dao;

import com.semiproject.pettales.adminpage.model.dto.UserTableDTO;
import com.semiproject.pettales.user.model.dto.LoginUserDTO;
import com.semiproject.pettales.user.model.dto.SignupDTO;
import org.apache.catalina.User;
import org.apache.ibatis.annotations.Mapper;

// 데이터베이스와 연동해줌

@Mapper
public interface UserMapper{
    LoginUserDTO findByUserNickName(String userNickName); //닉네임에 해당하는 사용자 찾기

    LoginUserDTO findByUserEmail(String userEmail);

    LoginUserDTO findUserByEmailAndAnswer(String userEmail, String answer);

    int regist(SignupDTO signupDTO); //회원가입

    LoginUserDTO selectUserByUserCode(int userCode);


    int changePassword(LoginUserDTO loginUserDTO); //비밀번호 변경
}

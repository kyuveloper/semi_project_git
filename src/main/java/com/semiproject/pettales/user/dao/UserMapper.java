package com.semiproject.pettales.user.dao;

import com.semiproject.pettales.adminpage.model.dto.UserTableDTO;
import com.semiproject.pettales.user.model.dto.LoginUserDTO;
import com.semiproject.pettales.user.model.dto.SignupDTO;
import org.apache.catalina.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.data.jpa.repository.JpaRepository;

// 데이터베이스와 연동해줌

@Mapper
public interface UserMapper{
    LoginUserDTO findByUserNickName(String userNickName); //닉네임에 해당하는 사용자 찾기

    LoginUserDTO findByUserEmail(String userEmail);

    int regist(SignupDTO signupDTO); //회원가입

    LoginUserDTO selectUserByUserCode(Integer userCode);


    //이넘에 정지기능 로그인실패시 정지유저라고 알람

    //중복체크 중복:true 중복아님:false
//    boolean existByUserEmail(String userEmail);
//    boolean existByUserNickName(String userNickName);
}

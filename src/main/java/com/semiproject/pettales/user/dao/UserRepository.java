//package com.semiproject.pettales.user.dao;
//
//// 구글로그인
//
//import com.semiproject.pettales.user.model.dto.LoginUserDTO;
//import com.semiproject.pettales.user.model.entity.User;
//import org.springframework.data.jpa.repository.JpaRepository;
//
//import java.util.Optional;
//
//public interface UserRepository extends JpaRepository<User, Long> {
//    boolean existsByLoginId(String loginId);
//    boolean existsByUserNickname(String userNickname);
//    Optional<User> findByLoginId(String loginId);
//}

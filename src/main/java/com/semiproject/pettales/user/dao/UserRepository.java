//package com.semiproject.pettales.user.dao;
//
//// 구글로그인
//
//import com.semiproject.pettales.user.model.dto.LoginUserDTO;
//import org.springframework.data.jpa.repository.JpaRepository;
//
//import java.util.Optional;
//
//public interface UserRepository extends JpaRepository<LoginUserDTO, Long> {
//    boolean existsByUserEmail(String userEmail);
//    boolean existsByUserNickName(String userNickname);
//    Optional<LoginUserDTO> findByUserEmail(String userEmail);
//}

package com.semiproject.pettales.mypage.mypage.repository;

import com.semiproject.pettales.mypage.userupdate.entity.UserUpdate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MypageRepository extends JpaRepository<UserUpdate, Integer> {
    Optional<UserUpdate> findByUserEmail(String currentPrincipalName);
}

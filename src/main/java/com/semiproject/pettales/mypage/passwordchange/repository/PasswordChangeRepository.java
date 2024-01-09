package com.semiproject.pettales.mypage.passwordchange.repository;

import com.semiproject.pettales.mypage.userupdate.entity.UserUpdate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PasswordChangeRepository extends JpaRepository<UserUpdate, Integer> {
}

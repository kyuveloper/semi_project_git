package com.semiproject.pettales.mypage.passwordchange.service;

import com.semiproject.pettales.mypage.userupdate.entity.UserUpdate;

import java.util.Optional;

public interface PasswordChangeService {
    Optional<UserUpdate> findById(int userCode);
    void save(UserUpdate userUpdate);
}
package com.semiproject.pettales.AAmypage.passwordchange.service;

import com.semiproject.pettales.AAmypage.userupdate.entity.UserUpdate;

import java.util.Optional;

public interface PasswordChangeService {
    Optional<UserUpdate> findById(int userCode);
    void save(UserUpdate userUpdate);
}
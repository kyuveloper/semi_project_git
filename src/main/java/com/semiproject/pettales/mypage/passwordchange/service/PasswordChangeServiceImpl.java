package com.semiproject.pettales.mypage.passwordchange.service;

import com.semiproject.pettales.mypage.userupdate.entity.UserUpdate;
import com.semiproject.pettales.mypage.userupdate.repository.UserUpdateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PasswordChangeServiceImpl implements PasswordChangeService {

    @Autowired
    private UserUpdateRepository userUpdateRepository;

    @Override
    public Optional<UserUpdate> findById(int userCode) {
        return userUpdateRepository.findById(userCode);
    }

    @Override
    public void save(UserUpdate userUpdate) {
        userUpdateRepository.save(userUpdate);
    }
}
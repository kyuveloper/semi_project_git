package com.semiproject.pettales.mypage.passwordchange.service;

public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException(String message) {
        super(message);
    }
}


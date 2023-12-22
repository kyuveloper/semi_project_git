package com.semiproject.pettales.auth.model;

// 권한 받을 사용자의 변수명을 지정해주는 기능

public enum UserAuth {
    USER("유저"), // 유저
    ADMIN("운영자"); // 관리자
    private String auth;

    UserAuth(String auth) {
        this.auth = auth;
    }

    public String getAuth() {
        return auth;
    }

    public void setAuth(String auth) {
        this.auth = auth;
    }

    @Override
    public String toString() {
        return "UserAuth{" +
                "auth='" + auth + '\'' +
                '}';
    }
}
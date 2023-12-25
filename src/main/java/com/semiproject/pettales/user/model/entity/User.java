package com.semiproject.pettales.user.model.entity;

import com.semiproject.pettales.auth.model.UserAuth;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "user_table")
public class User {

    @Id
    @Column(name = "user_code")
    private int userCode;

    @Column(name = "USER_NICKNAME")
    private String userNickname;

    @Column(name = "USER_EMAIL")
    private String userEmail;

    @Column(name = "USER_PASSWORD", nullable = false)
    private String password;

    @Column(name = "USER_STATUS")
    private String userStatus;

    @Column(name = "USER_AUTH")
    private String userAuth;

    @Column(name = "PET_CODELIST")
    private String petCode;

    @Column(name = "COMPANY_CODELIST")
    private String companyCode;

    @Column(name = "REGIST_DATE")
    private String registDate;

    @Column(name = "UPDATE_DATE")
    private String updateDate;

    // OAuth로그인에 사용
    private String provider;
    private String providerId;

    @Column(name = "LOGIN_ID")
    private String loginId;
}

//package com.semiproject.pettales.user.model.entity;
//
//import com.semiproject.pettales.auth.model.UserAuth;
//import jakarta.persistence.*;
//import lombok.Builder;
//
//import java.time.LocalDateTime;
//
//@Entity
//@Builder
//@Table(name = "user_table")
//public class User {
//
//    @Id
//    @Column(name = "user_code")
//    private int userCode;
//
//    @Column(name = "USER_NICKNAME")
//    private String userNickname;
//
//    @Column(name = "USER_EMAIL")
//    private String userEmail;
//
//    @Column(name = "USER_PASSWORD", nullable = false)
//    private String password;
//
//    @Column(name = "USER_STATUS")
//    private String userStatus;
//
//    @Column(name = "USER_AUTH")
//    private String userAuth;
//
//    @Column(name = "PET_CODELIST")
//    private String petCode;
//
//    @Column(name = "COMPANY_CODELIST")
//    private String companyCode;
//
//    @Column(name = "REGIST_DATE")
//    private LocalDateTime registDate;
//
//    @Column(name = "UPDATE_DATE")
//    private LocalDateTime updateDate;
//
//    // OAuth로그인에 사용
//    @Column(name = "PROVIDER")
//    private String provider;
//
//    @Column(name = "PROVIDER_ID")
//    private String providerId;
//
//
//    public User() {
//    }
//
//    public User(int userCode, String userNickname, String userEmail, String password, String userStatus, String userAuth, String petCode, String companyCode, LocalDateTime registDate, LocalDateTime updateDate, String provider, String providerId) {
//        this.userCode = userCode;
//        this.userNickname = userNickname;
//        this.userEmail = userEmail;
//        this.password = password;
//        this.userStatus = userStatus;
//        this.userAuth = userAuth;
//        this.petCode = petCode;
//        this.companyCode = companyCode;
//        this.registDate = registDate;
//        this.updateDate = updateDate;
//        this.provider = provider;
//        this.providerId = providerId;
//    }
//
//    public int getUserCode() {
//        return userCode;
//    }
//
//    public void setUserCode(int userCode) {
//        this.userCode = userCode;
//    }
//
//    public String getUserNickname() {
//        return userNickname;
//    }
//
//    public void setUserNickname(String userNickname) {
//        this.userNickname = userNickname;
//    }
//
//    public String getUserEmail() {
//        return userEmail;
//    }
//
//    public void setUserEmail(String userEmail) {
//        this.userEmail = userEmail;
//    }
//
//    public String getPassword() {
//        return password;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//    }
//
//    public String getUserStatus() {
//        return userStatus;
//    }
//
//    public void setUserStatus(String userStatus) {
//        this.userStatus = userStatus;
//    }
//
//    public String getUserAuth() {
//        return userAuth;
//    }
//
//    public void setUserAuth(String userAuth) {
//        this.userAuth = userAuth;
//    }
//
//    public String getPetCode() {
//        return petCode;
//    }
//
//    public void setPetCode(String petCode) {
//        this.petCode = petCode;
//    }
//
//    public String getCompanyCode() {
//        return companyCode;
//    }
//
//    public void setCompanyCode(String companyCode) {
//        this.companyCode = companyCode;
//    }
//
//    public LocalDateTime getRegistDate() {
//        return registDate;
//    }
//
//    public void setRegistDate(LocalDateTime registDate) {
//        this.registDate = registDate;
//    }
//
//    public LocalDateTime getUpdateDate() {
//        return updateDate;
//    }
//
//    public void setUpdateDate(LocalDateTime updateDate) {
//        this.updateDate = updateDate;
//    }
//
//    public String getProvider() {
//        return provider;
//    }
//
//    public void setProvider(String provider) {
//        this.provider = provider;
//    }
//
//    public String getProviderId() {
//        return providerId;
//    }
//
//    public void setProviderId(String providerId) {
//        this.providerId = providerId;
//    }
//
//    @Override
//    public String toString() {
//        return "User{" +
//                "userCode=" + userCode +
//                ", userNickname='" + userNickname + '\'' +
//                ", userEmail='" + userEmail + '\'' +
//                ", password='" + password + '\'' +
//                ", userStatus='" + userStatus + '\'' +
//                ", userAuth='" + userAuth + '\'' +
//                ", petCode='" + petCode + '\'' +
//                ", companyCode='" + companyCode + '\'' +
//                ", registDate=" + registDate +
//                ", updateDate=" + updateDate +
//                ", provider='" + provider + '\'' +
//                ", providerId='" + providerId + '\'' +
//                '}';
//    }
//}

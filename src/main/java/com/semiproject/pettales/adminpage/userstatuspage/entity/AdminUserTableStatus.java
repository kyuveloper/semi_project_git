package com.semiproject.pettales.adminpage.userstatuspage.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "USER_TABLE")
public class AdminUserTableStatus {

    @Id
    @Column(name = "USER_CODE")
    private int userCode;

    @Column(name = "USER_NICKNAME")
    private String userNickname;

    @Column(name = "USER_EMAIL")
    private String userEmail;

    @Column(name = "USER_PASSWORD")
    private String userPassword;
    @Column(name = "USER_STATUS")
    private String userStatus;

    @Column(name = "USER_AUTH")
    private String userAuth;

    @Column(name = "PET_CODELIST")
    private String petCodeList;

    @Column(name = "COMPANY_CODELIST")
    private String companyCodeList;

    @Column(name = "REGIST_DATE")
    private Date registDate;

    @Column(name = "UPDATE_DATE")
    private Date updateDate;
    @Column(name = "USER_IMG")
    private String userImg;

    private String imagePath;

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public String getImagePath() {
        return this.imagePath;
    }

    public String getUserImg() {
        return userImg;
    }

    public void setUserImg(String userImg) {
        this.userImg = userImg;
    }

    public AdminUserTableStatus() {
    }

    public AdminUserTableStatus(int userCode, String userNickname, String userEmail, String userPassword, String userStatus, String userAuth, String petCodeList, String companyCodeList, Date registDate, Date updateDate) {
        this.userCode = userCode;
        this.userNickname = userNickname;
        this.userEmail = userEmail;
        this.userPassword = userPassword;
        this.userStatus = userStatus;
        this.userAuth = userAuth;
        this.petCodeList = petCodeList;
        this.companyCodeList = companyCodeList;
        this.registDate = registDate;
        this.updateDate = updateDate;
    }

    public int getUserCode() {
        return userCode;
    }

    public void setUserCode(int userCode) {
        this.userCode = userCode;
    }

    public String getUserNickname() {
        return userNickname;
    }

    public void setUserNickname(String userNickname) {
        this.userNickname = userNickname;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(String userStatus) {
        this.userStatus = userStatus;
    }

    public String getUserAuth() {
        return userAuth;
    }

    public void setUserAuth(String userAuth) {
        this.userAuth = userAuth;
    }

    public String getPetCodeList() {
        return petCodeList;
    }

    public void setPetCodeList(String petCodeList) {
        this.petCodeList = petCodeList;
    }

    public String getCompanyCodeList() {
        return companyCodeList;
    }

    public void setCompanyCodeList(String companyCodeList) {
        this.companyCodeList = companyCodeList;
    }

    public Date getRegistDate() {
        return registDate;
    }

    public void setRegistDate(Date registDate) {
        this.registDate = registDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    @Override
    public String toString() {
        return "UserTableStatus{" +
                "userCode=" + userCode +
                ", userNickname='" + userNickname + '\'' +
                ", userEmail='" + userEmail + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", userStatus='" + userStatus + '\'' +
                ", userAuth='" + userAuth + '\'' +
                ", petCodeList='" + petCodeList + '\'' +
                ", companyCodeList='" + companyCodeList + '\'' +
                ", registDate=" + registDate +
                ", updateDate=" + updateDate +
                '}';
    }
}

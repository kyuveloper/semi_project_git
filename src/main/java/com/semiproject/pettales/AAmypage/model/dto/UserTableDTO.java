package com.semiproject.pettales.AAmypage.model.dto;

import org.springframework.web.multipart.MultipartFile;

import java.util.Date;

public class UserTableDTO {

    private int userCode;
    private String userNickname;
    private String userEmail;
    private String userPassword;
    private String userStatus;
    private String userAuth;
    private String petCodeList;
    private String companyCodeList;
    private Date registDate;
    private Date updateDate;
    private MultipartFile image; // 사용자의 프로필 이미지
    public UserTableDTO() {
    }

    public UserTableDTO(int userCode, String userNickname, String userEmail, String userPassword, String userStatus, String userAuth, String petCodeList, String companyCodeList, Date registDate, Date updateDate, MultipartFile image) {
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
        this.image = image;
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

    public MultipartFile getImage() {
        return image;
    }

    public void setImage(MultipartFile image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "UserTableDTO{" +
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
                ", image=" + image +
                '}';
    }
}
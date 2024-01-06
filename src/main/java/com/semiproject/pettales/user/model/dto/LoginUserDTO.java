package com.semiproject.pettales.user.model.dto;

import com.semiproject.pettales.auth.model.UserAuth;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

//로그인 한 사용자의 정보


public class LoginUserDTO {

    private int userCode;
    private String userEmail;
    private String userNickName;
    private String provider; //google이 들어갈 자리
    private String providerId; //google 고유 아이디가 들어갈 자리
    private String userPassword;
    private String userStatus;
    private String petCode;
    private String companyCode;
    private Date registDate;
    private Date updateDate;
    private UserAuth userAuth;
    private String answer;

    public LoginUserDTO() {
    }

    public LoginUserDTO(int userCode, String userEmail, String userNickName, String provider, String providerId, String userPassword, String userStatus, String petCode, String companyCode, Date registDate, Date updateDate, UserAuth userAuth, String answer) {
        this.userCode = userCode;
        this.userEmail = userEmail;
        this.userNickName = userNickName;
        this.provider = provider;
        this.providerId = providerId;
        this.userPassword = userPassword;
        this.userStatus = userStatus;
        this.petCode = petCode;
        this.companyCode = companyCode;
        this.registDate = registDate;
        this.updateDate = updateDate;
        this.userAuth = userAuth;
        this.answer = answer;
    }

    public int getUserCode() {
        return userCode;
    }

    public void setUserCode(int userCode) {
        this.userCode = userCode;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserNickName() {
        return userNickName;
    }

    public void setUserNickName(String userNickName) {
        this.userNickName = userNickName;
    }

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    public String getProviderId() {
        return providerId;
    }

    public void setProviderId(String providerId) {
        this.providerId = providerId;
    }

    public String getPassword() {
        return userPassword;
    }

    public void setPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(String userStatus) {
        this.userStatus = userStatus;
    }

    public String getPetCode() {
        return petCode;
    }

    public void setPetCode(String petCode) {
        this.petCode = petCode;
    }

    public String getCompanyCodeList() {
        return companyCode;
    }

    public void setCompanyCodeList(String companyCodeList) {
        this.companyCode = companyCode;
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

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public UserAuth getUserAuth() {
        return userAuth;
    }

    public void setUserAuth(UserAuth userAuth) {
        this.userAuth = userAuth;
    }

    @Override
    public String toString() {
        return "LoginUserDTO{" +
                "userCode=" + userCode +
                ", userEmail='" + userEmail + '\'' +
                ", userNickName='" + userNickName + '\'' +
                ", provider='" + provider + '\'' +
                ", providerId='" + providerId + '\'' +
                ", password='" + userPassword + '\'' +
                ", userStatus='" + userStatus + '\'' +
                ", petCode='" + petCode + '\'' +
                ", companyCode='" + companyCode + '\'' +
                ", registDate=" + registDate +
                ", updateDate=" + updateDate +
                ", answer=" + answer +
                ", userAuth=" + userAuth +
                '}';
    }

    //    public List<String> getAuth(){
//        System.out.println(this.userAuth.getAuth());
//        if(this.userAuth != null && this.userAuth.getAuth() != null && this.userAuth.getAuth().length()>0){
//            return Arrays.asList(this.userAuth.getAuth().split(","));
//        }
//        return new ArrayList<>();
//    }
    public List<String> getAuth(){
        if(this.userAuth.getAuth().length()>0){
            return Arrays.asList(this.userAuth.getAuth().split(","));
        }
        return new ArrayList<>();
    }

        //    public LoginUserDTO(User user) {
    //        this.userCode = user.getUserCode();
    //        this.userEmail = user.getUserEmail();
    //        this.userNickName = user.getUserNickname();
    //        this.password = user.getPassword();
    //        this.userStatus = user.getUserStatus();
    //        this.petCode = user.getPetCode();
    //        this.companyCode = user.getCompanyCode();
    ////        this.registDate = user.getRegistDate();
    ////        this.updateDate = user.getUpdateDate();
    //        this.userAuth = UserAuth.valueOf(user.getUserAuth());
    //    }
}

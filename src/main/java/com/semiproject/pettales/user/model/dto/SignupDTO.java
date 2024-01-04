package com.semiproject.pettales.user.model.dto;

import jakarta.validation.constraints.*;

import java.util.Date;

//회원가입 할 사용자의 정보

public class SignupDTO {

    @NotBlank(message = "이메일은 필수로 입력해주세요")
    @Pattern(regexp = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+.[A-Za-z]{2,6}$", message = "이메일 형식이 올바르지 않습니다.")
    private String userEmail;
    @NotBlank(message = "닉네임은 필수로 입력해주세요")
    @Pattern(regexp = "^[가-힣a-zA-Z0-9]{2,8}$" , message = "닉네임은 특수문자를 포함하지 않은 2~8자리여야 합니다.")
    private String userNickName;
    @NotBlank(message = "비밀번호는 필수로 입력해주세요")
    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[$@$!%*#?&])[a-z\\d$@$!%*#?&]{4,16}$",
            message = "비밀번호는 8~16자리수여야 합니다. 영문 소문자, 숫자, 특수문자를 1개 이상 포함해야 합니다.")
    private String password;
    private String userStatus;
    private String auth;
    private String petCode;
    private Date registDate;
    private Date updateDate;
    private String answer;

    public SignupDTO() {
    }

    public SignupDTO(String userEmail, String userNickName, String password, String userStatus, String auth, String petCode, Date registDate, Date updateDate, String answer) {
        this.userEmail = userEmail;
        this.userNickName = userNickName;
        this.password = password;
        this.userStatus = userStatus;
        this.auth = auth;
        this.petCode = petCode;
        this.registDate = registDate;
        this.updateDate = updateDate;
        this.answer = answer;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(String userStatus) {
        this.userStatus = userStatus;
    }

    public String getAuth() {
        return auth;
    }

    public void setAuth(String auth) {
        this.auth = auth;
    }

    public String getPetCode() {
        return petCode;
    }

    public void setPetCode(String petCode) {
        this.petCode = petCode;
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

    @Override
    public String toString() {
        return "SignupDTO{" +
                "userEmail='" + userEmail + '\'' +
                ", userNickName='" + userNickName + '\'' +
                ", password='" + password + '\'' +
                ", userStatus='" + userStatus + '\'' +
                ", auth='" + auth + '\'' +
                ", petCode='" + petCode + '\'' +
                ", registDate=" + registDate +
                ", updateDate=" + updateDate +
                ", answer=" + answer +
                '}';
    }
}

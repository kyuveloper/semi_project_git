package com.semiproject.pettales.AAmypage.model.dto;

public class UserImgTableDTO {
    private int userImgCode;
    private int userCode; // AdminUserTableStatus의 기본 키 값
    private String imgOrgName;
    private String imgUpdName;
    private String imgStatus;

    public UserImgTableDTO() {
    }
    public UserImgTableDTO(int userImgCode, int userCode, String imgOrgName, String imgUpdName, String imgStatus) {
        this.userImgCode = userImgCode;
        this.userCode = userCode;
        this.imgOrgName = imgOrgName;
        this.imgUpdName = imgUpdName;
        this.imgStatus = imgStatus;
    }

    public int getUserImgCode() {
        return userImgCode;
    }

    public void setUserImgCode(int userImgCode) {
        this.userImgCode = userImgCode;
    }

    public int getUserCode() {
        return userCode;
    }

    public void setUserCode(int userCode) {
        this.userCode = userCode;
    }

    public String getImgOrgName() {
        return imgOrgName;
    }

    public void setImgOrgName(String imgOrgName) {
        this.imgOrgName = imgOrgName;
    }

    public String getImgUpdName() {
        return imgUpdName;
    }

    public void setImgUpdName(String imgUpdName) {
        this.imgUpdName = imgUpdName;
    }

    public String getImgStatus() {
        return imgStatus;
    }

    public void setImgStatus(String imgStatus) {
        this.imgStatus = imgStatus;
    }

    @Override
    public String toString() {
        return "UserImgTableDTO{" +
                "userImgCode=" + userImgCode +
                ", userCode=" + userCode +
                ", imgOrgName='" + imgOrgName + '\'' +
                ", imgUpdName='" + imgUpdName + '\'' +
                ", imgStatus='" + imgStatus + '\'' +
                '}';
    }
}
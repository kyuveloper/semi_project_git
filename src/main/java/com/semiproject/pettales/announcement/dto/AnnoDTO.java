package com.semiproject.pettales.announcement.dto;

import java.util.Date;

public class AnnoDTO {
    private int annoCode;
    private String annoTitle;
    private String annoContents;
    private String annoPin;
    private String annoStatus;
    private Date registDate;
    private Date updateDate;
    private int userCode;

    public AnnoDTO() {
    }

    public AnnoDTO(int annoCode, String annoTitle, String annoContents, String annoPin, String annoStatus, Date registDate, Date updateDate, int userCode) {
        this.annoCode = annoCode;
        this.annoTitle = annoTitle;
        this.annoContents = annoContents;
        this.annoPin = annoPin;
        this.annoStatus = annoStatus;
        this.registDate = registDate;
        this.updateDate = updateDate;
        this.userCode = userCode;
    }

    public int getAnnoCode() {
        return annoCode;
    }

    public void setAnnoCode(int annoCode) {
        this.annoCode = annoCode;
    }

    public String getAnnoTitle() {
        return annoTitle;
    }

    public void setAnnoTitle(String annoTitle) {
        this.annoTitle = annoTitle;
    }

    public String getAnnoContents() {
        return annoContents;
    }

    public void setAnnoContents(String annoContents) {
        this.annoContents = annoContents;
    }

    public String getAnnoPin() {
        return annoPin;
    }

    public void setAnnoPin(String annoPin) {
        this.annoPin = annoPin;
    }

    public String getAnnoStatus() {
        return annoStatus;
    }

    public void setAnnoStatus(String annoStatus) {
        this.annoStatus = annoStatus;
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

    public int getUserCode() {
        return userCode;
    }

    public void setUserCode(int userCode) {
        this.userCode = userCode;
    }

    @Override
    public String toString() {
        return "AnnoDTO{" +
                "annoCode=" + annoCode +
                ", annoTitle='" + annoTitle + '\'' +
                ", annoContents='" + annoContents + '\'' +
                ", annoPin='" + annoPin + '\'' +
                ", annoStatus='" + annoStatus + '\'' +
                ", registDate=" + registDate +
                ", updateDate=" + updateDate +
                ", userCode=" + userCode +
                '}';
    }
}

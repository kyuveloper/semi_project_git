package com.semiproject.pettales.adminpage.announcement.entity;

import com.semiproject.pettales.adminpage.userstatuspage.entity.AdminUserTableStatus;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "ANNOUNCEMENT")
public class AdminAnnouncementStatus {

    @Id
    @Column(name = "ANNO_CODE")
    private int annoCode;

    @Column(name = "ANNO_TITLE")
    private String annoTitle;

    @Column(name = "ANNO_CONTENTS")
    private String annoContents;

    @Column(name = "ANNO_PIN")
    private String annoPin;

    @Column(name = "ANNO_STATUS")
    private String annoStatus;

    @Column(name = "REGIST_DATE")
    private Date registDate;

    @Column(name = "UPDATE_DATE")
    private Date updateDate;

    @ManyToOne
    @JoinColumn(name = "USER_CODE")
    private AdminUserTableStatus adminUserTableStatus;


    public AdminAnnouncementStatus() {
    }

    public AdminAnnouncementStatus(int annoCode, String annoTitle, String annoContents, String annoPin, String annoStatus, Date registDate, Date updateDate) {
        this.annoCode = annoCode;
        this.annoTitle = annoTitle;
        this.annoContents = annoContents;
        this.annoPin = annoPin;
        this.annoStatus = annoStatus;
        this.registDate = registDate;
        this.updateDate = updateDate;
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

    @Override
    public String toString() {
        return "AdminAnnouncementStatus{" +
                "annoCode=" + annoCode +
                ", annoTitle='" + annoTitle + '\'' +
                ", annoContents='" + annoContents + '\'' +
                ", annoPin='" + annoPin + '\'' +
                ", annoStatus='" + annoStatus + '\'' +
                ", registDate=" + registDate +
                ", updateDate=" + updateDate +
                '}';
    }
}

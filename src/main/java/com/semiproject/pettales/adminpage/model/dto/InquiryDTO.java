package com.semiproject.pettales.adminpage.model.dto;

import java.util.Date;

public class InquiryDTO {
    private int inqCode;

    private String inqTitle;

    private String inqClassi;

    private String inqContents;

    private Date registDate;
    private Date updateDate;

    private int userCode;

    private int answerCode;

    private String answerContents;

    private Date answerRegistDate;

    private Date answerUpdateDate;

    public InquiryDTO() {
    }

    public InquiryDTO(int inqCode, String inqTitle, String inqClassi, String inqContents, Date registDate, Date updateDate, int userCode, int answerCode, String answerContents, Date answerRegistDate, Date answerUpdateDate) {
        this.inqCode = inqCode;
        this.inqTitle = inqTitle;
        this.inqClassi = inqClassi;
        this.inqContents = inqContents;
        this.registDate = registDate;
        this.updateDate = updateDate;
        this.userCode = userCode;
        this.answerCode = answerCode;
        this.answerContents = answerContents;
        this.answerRegistDate = answerRegistDate;
        this.answerUpdateDate = answerUpdateDate;
    }

    public int getInqCode() {
        return inqCode;
    }

    public void setInqCode(int inqCode) {
        this.inqCode = inqCode;
    }

    public String getInqTitle() {
        return inqTitle;
    }

    public void setInqTitle(String inqTitle) {
        this.inqTitle = inqTitle;
    }

    public String getInqClassi() {
        return inqClassi;
    }

    public void setInqClassi(String inqClassi) {
        this.inqClassi = inqClassi;
    }

    public String getInqContents() {
        return inqContents;
    }

    public void setInqContents(String inqContents) {
        this.inqContents = inqContents;
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

    public int getAnswerCode() {
        return answerCode;
    }

    public void setAnswerCode(int answerCode) {
        this.answerCode = answerCode;
    }

    public String getAnswerContents() {
        return answerContents;
    }

    public void setAnswerContents(String answerContents) {
        this.answerContents = answerContents;
    }

    public Date getAnswerRegistDate() {
        return answerRegistDate;
    }

    public void setAnswerRegistDate(Date answerRegistDate) {
        this.answerRegistDate = answerRegistDate;
    }

    public Date getAnswerUpdateDate() {
        return answerUpdateDate;
    }

    public void setAnswerUpdateDate(Date answerUpdateDate) {
        this.answerUpdateDate = answerUpdateDate;
    }

    @Override
    public String toString() {
        return "InquiryDTO{" +
                "inqCode=" + inqCode +
                ", inqTitle='" + inqTitle + '\'' +
                ", inqClassi='" + inqClassi + '\'' +
                ", inqContents='" + inqContents + '\'' +
                ", registDate=" + registDate +
                ", updateDate=" + updateDate +
                ", userCode=" + userCode +
                ", answerCode=" + answerCode +
                ", answerContents='" + answerContents + '\'' +
                ", answerRegistDate=" + answerRegistDate +
                ", answerUpdateDate=" + answerUpdateDate +
                '}';
    }
}
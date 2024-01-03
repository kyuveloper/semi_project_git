package com.semiproject.pettales.inquiry.dto;

import java.util.Date;

public class InquiryDTO {

    private int inqCode;
    private String inqTitle;
    private String inqClassi;
    private String inqContents;
    private Date registDate;
    private int answerCode;
    private String answerContents;
    private Date answerDate;
    private Date answerUpdateDate;
    private int userCode;

    public InquiryDTO() {
    }

    public InquiryDTO(int inqCode, String inqTitle, String inqClassi, String inqContents, Date registDate, int answerCode, String answerContents, Date answerDate, Date answerUpdateDate, int userCode) {
        this.inqCode = inqCode;
        this.inqTitle = inqTitle;
        this.inqClassi = inqClassi;
        this.inqContents = inqContents;
        this.registDate = registDate;
        this.answerCode = answerCode;
        this.answerContents = answerContents;
        this.answerDate = answerDate;
        this.answerUpdateDate = answerUpdateDate;
        this.userCode = userCode;
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

    public Date getAnswerDate() {
        return answerDate;
    }

    public void setAnswerDate(Date answerDate) {
        this.answerDate = answerDate;
    }

    public Date getAnswerUpdateDate() {
        return answerUpdateDate;
    }

    public void setAnswerUpdateDate(Date answerUpdateDate) {
        this.answerUpdateDate = answerUpdateDate;
    }

    public int getUserCode() {
        return userCode;
    }

    public void setUserCode(int userCode) {
        this.userCode = userCode;
    }

    @Override
    public String toString() {
        return "InquiryDTO{" +
                "inqCode=" + inqCode +
                ", inqTitle='" + inqTitle + '\'' +
                ", inqClassi='" + inqClassi + '\'' +
                ", inqContents='" + inqContents + '\'' +
                ", registDate=" + registDate +
                ", answerCode=" + answerCode +
                ", answerContents='" + answerContents + '\'' +
                ", answerDate=" + answerDate +
                ", answerUpdateDate=" + answerUpdateDate +
                ", userCode=" + userCode +
                '}';
    }
}

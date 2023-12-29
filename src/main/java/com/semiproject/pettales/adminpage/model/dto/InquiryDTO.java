package com.semiproject.pettales.adminpage.model.dto;

import java.sql.Date;

public class InquiryDTO {

    private int inqCode;
    private String inqTitle;
    private String inqClassi;
    private String inqContents;
    private Date registDate;
    private Date updateDate;
    private int userCode;

    public InquiryDTO() {
    }

    public InquiryDTO(int inqCode, String inqTitle, String inqClassi, String inqContents, Date registDate, Date updateDate, int userCode) {
        this.inqCode = inqCode;
        this.inqTitle = inqTitle;
        this.inqClassi = inqClassi;
        this.inqContents = inqContents;
        this.registDate = registDate;
        this.updateDate = updateDate;
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
        return "InquiryDTO{" +
                "inqCode=" + inqCode +
                ", inqTitle='" + inqTitle + '\'' +
                ", inqClassi='" + inqClassi + '\'' +
                ", inqContents='" + inqContents + '\'' +
                ", registDate=" + registDate +
                ", updateDate=" + updateDate +
                ", userCode=" + userCode +
                '}';
    }
}
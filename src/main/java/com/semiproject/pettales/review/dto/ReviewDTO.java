package com.semiproject.pettales.review.dto;

import java.util.Date;

public class ReviewDTO {
    private int reviewCode;
    private String companyGrade;
    private String reviewContents;
    private String reviewStatus;
    private Date registDate;
    private Date updateDate;
    private int companyCode;
    private int userCode;

    public ReviewDTO() {
    }

    public ReviewDTO(int reviewCode, String companyGrade, String reviewContents, String reviewStatus, Date registDate, Date updateDate, int companyCode, int userCode) {
        this.reviewCode = reviewCode;
        this.companyGrade = companyGrade;
        this.reviewContents = reviewContents;
        this.reviewStatus = reviewStatus;
        this.registDate = registDate;
        this.updateDate = updateDate;
        this.companyCode = companyCode;
        this.userCode = userCode;
    }

    public int getReviewCode() {
        return reviewCode;
    }

    public void setReviewCode(int reviewCode) {
        this.reviewCode = reviewCode;
    }

    public String getCompanyGrade() {
        return companyGrade;
    }

    public void setCompanyGrade(String companyGrade) {
        this.companyGrade = companyGrade;
    }

    public String getReviewContents() {
        return reviewContents;
    }

    public void setReviewContents(String reviewContents) {
        this.reviewContents = reviewContents;
    }

    public String getReviewStatus() {
        return reviewStatus;
    }

    public void setReviewStatus(String reviewStatus) {
        this.reviewStatus = reviewStatus;
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

    public int getCompanyCode() {
        return companyCode;
    }

    public void setCompanyCode(int companyCode) {
        this.companyCode = companyCode;
    }

    public int getUserCode() {
        return userCode;
    }

    public void setUserCode(int userCode) {
        this.userCode = userCode;
    }

    @Override
    public String toString() {
        return "ReviewDTO{" +
                "reviewCode=" + reviewCode +
                ", companyGrade='" + companyGrade + '\'' +
                ", reviewContents='" + reviewContents + '\'' +
                ", reviewStatus='" + reviewStatus + '\'' +
                ", registDate=" + registDate +
                ", updateDate=" + updateDate +
                ", companyCode=" + companyCode +
                ", userCode=" + userCode +
                '}';
    }
}

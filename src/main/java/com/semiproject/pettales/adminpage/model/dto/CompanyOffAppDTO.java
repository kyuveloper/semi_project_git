package com.semiproject.pettales.adminpage.model.dto;

import java.sql.Date;

public class CompanyOffAppDTO {
    private String businessApp;
    private Date registDate;
    private String notAppReason;

    private int userCode;
    private int companyCode;

    public CompanyOffAppDTO() {
    }

    public CompanyOffAppDTO(String businessApp, Date registDate, String notAppReason, int userCode, int companyCode) {
        this.businessApp = businessApp;
        this.registDate = registDate;
        this.notAppReason = notAppReason;
        this.userCode = userCode;
        this.companyCode = companyCode;
    }

    public String getBusinessApp() {
        return businessApp;
    }

    public void setBusinessApp(String businessApp) {
        this.businessApp = businessApp;
    }

    public Date getRegistDate() {
        return registDate;
    }

    public void setRegistDate(Date registDate) {
        this.registDate = registDate;
    }

    public String getNotAppReason() {
        return notAppReason;
    }

    public void setNotAppReason(String notAppReason) {
        this.notAppReason = notAppReason;
    }

    public int getUserCode() {
        return userCode;
    }

    public void setUserCode(int userCode) {
        this.userCode = userCode;
    }

    public int getCompanyCode() {
        return companyCode;
    }

    public void setCompanyCode(int companyCode) {
        this.companyCode = companyCode;
    }

    @Override
    public String toString() {
        return "CompanyOffAppDTO{" +
                "businessApp='" + businessApp + '\'' +
                ", registDate=" + registDate +
                ", notAppReason='" + notAppReason + '\'' +
                ", userCode=" + userCode +
                ", companyCode=" + companyCode +
                '}';
    }
}

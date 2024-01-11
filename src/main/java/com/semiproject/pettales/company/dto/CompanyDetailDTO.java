package com.semiproject.pettales.company.dto;


public class CompanyDetailDTO {
    private int companyCode;
    private String companyClassi;
    private String companyName;
    private String companyAddress;
    private String companyPhone;
    private String companyTime;
    private String companyUrl;
    private String companyInfo;

    public CompanyDetailDTO() {
    }

    public CompanyDetailDTO(int companyCode, String companyClassi, String companyName, String companyAddress, String companyPhone, String companyTime, String companyUrl, String companyInfo) {
        this.companyCode = companyCode;
        this.companyClassi = companyClassi;
        this.companyName = companyName;
        this.companyAddress = companyAddress;
        this.companyPhone = companyPhone;
        this.companyTime = companyTime;
        this.companyUrl = companyUrl;
        this.companyInfo = companyInfo;
    }

    public int getCompanyCode() {
        return companyCode;
    }

    public void setCompanyCode(int companyCode) {
        this.companyCode = companyCode;
    }

    public String getCompanyClassi() {
        return companyClassi;
    }

    public void setCompanyClassi(String companyClassi) {
        this.companyClassi = companyClassi;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyAddress() {
        return companyAddress;
    }

    public void setCompanyAddress(String companyAddress) {
        this.companyAddress = companyAddress;
    }

    public String getCompanyPhone() {
        return companyPhone;
    }

    public void setCompanyPhone(String companyPhone) {
        this.companyPhone = companyPhone;
    }

    public String getCompanyTime() {
        return companyTime;
    }

    public void setCompanyTime(String companyTime) {
        this.companyTime = companyTime;
    }

    public String getCompanyUrl() {
        return companyUrl;
    }

    public void setCompanyUrl(String companyUrl) {
        this.companyUrl = companyUrl;
    }

    public String getCompanyInfo() {
        return companyInfo;
    }

    public void setCompanyInfo(String companyInfo) {
        this.companyInfo = companyInfo;
    }

    @Override
    public String toString() {
        return "CompanyDetailDTO{" +
                "companyCode=" + companyCode +
                ", companyClassi='" + companyClassi + '\'' +
                ", companyName='" + companyName + '\'' +
                ", companyAddress='" + companyAddress + '\'' +
                ", companyPhone='" + companyPhone + '\'' +
                ", companyTime='" + companyTime + '\'' +
                ", companyUrl='" + companyUrl + '\'' +
                ", companyInfo='" + companyInfo + '\'' +
                '}';
    }
}

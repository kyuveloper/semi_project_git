package com.semiproject.pettales.company.dto;

import java.util.Date;

public class CompanyDTO {
    private int companyCode;
    private String companyClassi;
    private char companyStatus;
    private String companyName;
    private String companyAddress;
    private String companyLat;
    private String companyHar;
    private String phoneNumber;
    private String companyTime;
    private Date registDate;
    private Date updateDate;
    private String petPosbl;
    private String companyCtprvn;
    private String companySigngu;
    private int zipNum;
    private String info;
    private String url;
    private String companyCertified;

    public CompanyDTO() {
    }

    public CompanyDTO(int companyCode, String companyClassi, char companyStatus, String companyName, String companyAddress, String companyLat, String companyHar, String phoneNumber, String companyTime, Date registDate, Date updateDate, String petPosbl, String companyCtprvn, String companySigngu, int zipNum, String info, String url, String companyCertified) {
        this.companyCode = companyCode;
        this.companyClassi = companyClassi;
        this.companyStatus = companyStatus;
        this.companyName = companyName;
        this.companyAddress = companyAddress;
        this.companyLat = companyLat;
        this.companyHar = companyHar;
        this.phoneNumber = phoneNumber;
        this.companyTime = companyTime;
        this.registDate = registDate;
        this.updateDate = updateDate;
        this.petPosbl = petPosbl;
        this.companyCtprvn = companyCtprvn;
        this.companySigngu = companySigngu;
        this.zipNum = zipNum;
        this.info = info;
        this.url = url;
        this.companyCertified = companyCertified;
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

    public char getCompanyStatus() {
        return companyStatus;
    }

    public void setCompanyStatus(char companyStatus) {
        this.companyStatus = companyStatus;
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

    public String getCompanyLat() {
        return companyLat;
    }

    public void setCompanyLat(String companyLat) {
        this.companyLat = companyLat;
    }

    public String getCompanyHar() {
        return companyHar;
    }

    public void setCompanyHar(String companyHar) {
        this.companyHar = companyHar;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getCompanyTime() {
        return companyTime;
    }

    public void setCompanyTime(String companyTime) {
        this.companyTime = companyTime;
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

    public String getPetPosbl() {
        return petPosbl;
    }

    public void setPetPosbl(String petPosbl) {
        this.petPosbl = petPosbl;
    }

    public String getCompanyCtprvn() {
        return companyCtprvn;
    }

    public void setCompanyCtprvn(String companyCtprvn) {
        this.companyCtprvn = companyCtprvn;
    }

    public String getCompanySigngu() {
        return companySigngu;
    }

    public void setCompanySigngu(String companySigngu) {
        this.companySigngu = companySigngu;
    }

    public int getZipNum() {
        return zipNum;
    }

    public void setZipNum(int zipNum) {
        this.zipNum = zipNum;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getCompanyCertified() {
        return companyCertified;
    }

    public void setCompanyCertified(String companyCertified) {
        this.companyCertified = companyCertified;
    }

    @Override
    public String toString() {
        return "CompanyDTO{" +
                "companyCode=" + companyCode +
                ", companyClassi='" + companyClassi + '\'' +
                ", companyStatus=" + companyStatus +
                ", companyName='" + companyName + '\'' +
                ", companyAddress='" + companyAddress + '\'' +
                ", companyLat='" + companyLat + '\'' +
                ", companyHar='" + companyHar + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", companyTime='" + companyTime + '\'' +
                ", registDate=" + registDate +
                ", updateDate=" + updateDate +
                ", petPosbl='" + petPosbl + '\'' +
                ", companyCtprvn='" + companyCtprvn + '\'' +
                ", companySigngu='" + companySigngu + '\'' +
                ", zipNum=" + zipNum +
                ", info='" + info + '\'' +
                ", url='" + url + '\'' +
                ", companyCertified='" + companyCertified + '\'' +
                '}';
    }
}

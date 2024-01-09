package com.semiproject.pettales.mypage.model.dto;

import java.util.Date;

public class CompanyTableDTO {

        private int companyCode;
        private String companyClassi;
        private String companyStatus;
        private String companyName;
        private String companyAddress;
        private String companyLat;
        private String companyHar;
        private String companyPhoneNumber;
        private String companyTime;
        private Date registDate;
        private Date updateDate;
        private String companyPetPosbl;
        private String companyCtprvn;
        private String companySigngu;
        private String companyZipNum;
        private String companyInfo;
        private String companyUrl;
        private String companyCertified;

        public CompanyTableDTO() {
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

        public String getCompanyStatus() {
                return companyStatus;
        }

        public void setCompanyStatus(String companyStatus) {
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

        public String getCompanyPhoneNumber() {
                return companyPhoneNumber;
        }

        public void setCompanyPhoneNumber(String companyPhoneNumber) {
                this.companyPhoneNumber = companyPhoneNumber;
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

        public String getCompanyPetPosbl() {
                return companyPetPosbl;
        }

        public void setCompanyPetPosbl(String companyPetPosbl) {
                this.companyPetPosbl = companyPetPosbl;
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

        public String getCompanyZipNum() {
                return companyZipNum;
        }

        public void setCompanyZipNum(String companyZipNum) {
                this.companyZipNum = companyZipNum;
        }

        public String getCompanyInfo() {
                return companyInfo;
        }

        public void setCompanyInfo(String companyInfo) {
                this.companyInfo = companyInfo;
        }

        public String getCompanyUrl() {
                return companyUrl;
        }

        public void setCompanyUrl(String companyUrl) {
                this.companyUrl = companyUrl;
        }

        public String getCompanyCertified() {
                return companyCertified;
        }

        public void setCompanyCertified(String companyCertified) {
                this.companyCertified = companyCertified;
        }

        @Override
        public String toString() {
                return "CompanyTableDTO{" +
                        "companyCode=" + companyCode +
                        ", companyClassi='" + companyClassi + '\'' +
                        ", companyStatus='" + companyStatus + '\'' +
                        ", companyName='" + companyName + '\'' +
                        ", companyAddress='" + companyAddress + '\'' +
                        ", companyLat='" + companyLat + '\'' +
                        ", companyHar='" + companyHar + '\'' +
                        ", companyPhoneNumber='" + companyPhoneNumber + '\'' +
                        ", companyTime='" + companyTime + '\'' +
                        ", registDate=" + registDate +
                        ", updateDate=" + updateDate +
                        ", companyPetPosbl='" + companyPetPosbl + '\'' +
                        ", companyCtprvn='" + companyCtprvn + '\'' +
                        ", companySigngu='" + companySigngu + '\'' +
                        ", companyZipNum='" + companyZipNum + '\'' +
                        ", companyInfo='" + companyInfo + '\'' +
                        ", companyUrl='" + companyUrl + '\'' +
                        ", companyCertified='" + companyCertified + '\'' +
                        '}';
        }

        public CompanyTableDTO(int companyCode, String companyClassi, String companyStatus, String companyName, String companyAddress, String companyLat, String companyHar, String companyPhoneNumber, String companyTime, Date registDate, Date updateDate, String companyPetPosbl, String companyCtprvn, String companySigngu, String companyZipNum, String companyInfo, String companyUrl, String companyCertified) {
                this.companyCode = companyCode;
                this.companyClassi = companyClassi;
                this.companyStatus = companyStatus;
                this.companyName = companyName;
                this.companyAddress = companyAddress;
                this.companyLat = companyLat;
                this.companyHar = companyHar;
                this.companyPhoneNumber = companyPhoneNumber;
                this.companyTime = companyTime;
                this.registDate = registDate;
                this.updateDate = updateDate;
                this.companyPetPosbl = companyPetPosbl;
                this.companyCtprvn = companyCtprvn;
                this.companySigngu = companySigngu;
                this.companyZipNum = companyZipNum;
                this.companyInfo = companyInfo;
                this.companyUrl = companyUrl;
                this.companyCertified = companyCertified;




        }
}

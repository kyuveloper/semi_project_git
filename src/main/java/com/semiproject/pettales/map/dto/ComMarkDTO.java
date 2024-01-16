package com.semiproject.pettales.map.dto;

import com.semiproject.pettales.bookmark.dto.BookmarkDTO;

public class ComMarkDTO {
    private int companyCode;
    private String companyName;
    private String companyAddress;
    private String companyLat;
    private String companyHar;
    private String companyPhone;
    private String companyTime;
    private String companyUrl;
    private int userCode;

    public ComMarkDTO() {
    }
    public void bookMark(BookmarkDTO bookmarkDTO) {
        this.companyCode = bookmarkDTO.getCompanyCode();
        this.userCode = bookmarkDTO.getUserCode();
    }

    public ComMarkDTO(int companyCode, String companyName, String companyAddress, String companyLat, String companyHar, String companyPhone, String companyTime, String companyUrl, int userCode) {
        this.companyCode = companyCode;
        this.companyName = companyName;
        this.companyAddress = companyAddress;
        this.companyLat = companyLat;
        this.companyHar = companyHar;
        this.companyPhone = companyPhone;
        this.companyTime = companyTime;
        this.companyUrl = companyUrl;
        this.userCode = userCode;
    }

    public int getCompanyCode() {
        return companyCode;
    }

    public void setCompanyCode(int companyCode) {
        this.companyCode = companyCode;
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

    public int getUserCode() {
        return userCode;
    }

    public void setUserCode(int userCode) {
        this.userCode = userCode;
    }

    @Override
    public String toString() {
        return "ComMarkDTO{" +
                "companyCode=" + companyCode +
                ", companyName='" + companyName + '\'' +
                ", companyAddress='" + companyAddress + '\'' +
                ", companyLat='" + companyLat + '\'' +
                ", companyHar='" + companyHar + '\'' +
                ", companyPhone='" + companyPhone + '\'' +
                ", companyTime='" + companyTime + '\'' +
                ", companyUrl='" + companyUrl + '\'' +
                ", userCode=" + userCode +
                '}';
    }
}

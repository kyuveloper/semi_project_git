package com.semiproject.pettales.map.dto;

import com.semiproject.pettales.bookmark.dto.BookmarkDTO;

public class ComMarkDTO {
    private int companyCode;
    private String companyName;
    private String companyLat;
    private String companyHar;
    private int userCode;

    public ComMarkDTO() {
    }
    public void bookMark(BookmarkDTO bookmarkDTO) {
        this.companyCode = bookmarkDTO.getCompanyCode();
        this.userCode = bookmarkDTO.getUserCode();
    }

    public ComMarkDTO(int companyCode, String companyName, String companyLat, String companyHar, int userCode) {
        this.companyCode = companyCode;
        this.companyName = companyName;
        this.companyLat = companyLat;
        this.companyHar = companyHar;
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
                ", companyLat='" + companyLat + '\'' +
                ", companyHar='" + companyHar + '\'' +
                ", userCode=" + userCode +
                '}';
    }
}

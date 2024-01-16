package com.semiproject.pettales.plan.dto;

import com.semiproject.pettales.company.dto.CompanyDTO;

public class BookmarkMappingDTO {
    private int planDetailCode;
    private int bookmarkCode;
    private int userCode;
    private String companyClassi;
    private String companyName;
    private String companyCtprvn;

    public BookmarkMappingDTO() {
    }

    public void setCompInfo(CompanyDTO companyDTO) {
        if (companyDTO == null) {
            // compDTO가 null인 경우 처리
            return;
        }

        this.companyCtprvn = companyDTO.getCompanyCtprvn();
        this.companyName = companyDTO.getCompanyName();
        this.companyClassi = companyDTO.getCompanyClassi();
    }

    public BookmarkMappingDTO(int planDetailCode, int bookmarkCode, int userCode, String companyClassi, String companyName, String companyCtprvn) {
        this.planDetailCode = planDetailCode;
        this.bookmarkCode = bookmarkCode;
        this.userCode = userCode;
        this.companyClassi = companyClassi;
        this.companyName = companyName;
        this.companyCtprvn = companyCtprvn;
    }

    public int getPlanDetailCode() {
        return planDetailCode;
    }

    public void setPlanDetailCode(int planDetailCode) {
        this.planDetailCode = planDetailCode;
    }

    public int getBookmarkCode() {
        return bookmarkCode;
    }

    public void setBookmarkCode(int bookmarkCode) {
        this.bookmarkCode = bookmarkCode;
    }

    public int getUserCode() {
        return userCode;
    }

    public void setUserCode(int userCode) {
        this.userCode = userCode;
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

    public String getCompanyCtprvn() {
        return companyCtprvn;
    }

    public void setCompanyCtprvn(String companyCtprvn) {
        this.companyCtprvn = companyCtprvn;
    }

    @Override
    public String toString() {
        return "BookmarkMappingDTO{" +
                "planDetailCode=" + planDetailCode +
                ", bookmarkCode=" + bookmarkCode +
                ", userCode=" + userCode +
                ", companyClassi='" + companyClassi + '\'' +
                ", companyName='" + companyName + '\'' +
                ", companyCtprvn='" + companyCtprvn + '\'' +
                '}';
    }
}

package com.semiproject.pettales.bookmark.dto;

import com.semiproject.pettales.company.dto.CompanyDTO;

public class BookmarkDTO {
    private int bookmarkCode;
    private int companyCode;
    private int userCode;
    private boolean bookmarked;
    private String companyCtprvn;
    private String companyName;
    private String companyClassi;

    public BookmarkDTO() {
    }


    public void setCompInfo(CompanyDTO companyDTO) {
        if (companyDTO == null) {
            // compDTO가 null인 경우 처리
            return;
        }

        this.companyCode = companyDTO.getCompanyCode();
        this.companyCtprvn = companyDTO.getCompanyCtprvn();
        this.companyName = companyDTO.getCompanyName();
        this.companyClassi = companyDTO.getCompanyClassi();
    }

    public BookmarkDTO(int bookmarkCode, int companyCode, int userCode, boolean bookmarked, String companyCtprvn, String companyName, String companyClassi) {
        this.bookmarkCode = bookmarkCode;
        this.companyCode = companyCode;
        this.userCode = userCode;
        this.bookmarked = bookmarked;
        this.companyCtprvn = companyCtprvn;
        this.companyName = companyName;
        this.companyClassi = companyClassi;
    }

    public int getBookmarkCode() {
        return bookmarkCode;
    }

    public void setBookmarkCode(int bookmarkCode) {
        this.bookmarkCode = bookmarkCode;
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

    public boolean isBookmarked() {
        return bookmarked;
    }

    public void setBookmarked(boolean bookmarked) {
        this.bookmarked = bookmarked;
    }

    public String getCompanyCtprvn() {
        return companyCtprvn;
    }

    public void setCompanyCtprvn(String companyCtprvn) {
        this.companyCtprvn = companyCtprvn;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyClassi() {
        return companyClassi;
    }

    public void setCompanyClassi(String companyClassi) {
        this.companyClassi = companyClassi;
    }

    @Override
    public String toString() {
        return "BookmarkDTO{" +
                "bookmarkCode=" + bookmarkCode +
                ", companyCode=" + companyCode +
                ", userCode=" + userCode +
                ", bookmarked=" + bookmarked +
                ", companyCtprvn='" + companyCtprvn + '\'' +
                ", companyName='" + companyName + '\'' +
                ", companyClassi='" + companyClassi + '\'' +
                '}';
    }
}

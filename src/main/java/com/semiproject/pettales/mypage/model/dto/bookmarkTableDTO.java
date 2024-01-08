package com.semiproject.pettales.mypage.model.dto;

public class bookmarkTableDTO {
    private int bookmarkCode;
    private int companyCode;
    private int userCode;
    private boolean bookmarked;

    public bookmarkTableDTO() {
    }

    public bookmarkTableDTO(int bookmarkCode, int companyCode, int userCode, boolean bookmarked) {
        this.bookmarkCode = bookmarkCode;
        this.companyCode = companyCode;
        this.userCode = userCode;
        this.bookmarked = bookmarked;
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

    @Override
    public String toString() {
        return "bookmarkTableDTO{" +
                "bookmarkCode=" + bookmarkCode +
                ", companyCode=" + companyCode +
                ", userCode=" + userCode +
                ", bookmarked=" + bookmarked +
                '}';
    }
}

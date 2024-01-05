package com.semiproject.pettales.plan.dto;

public class BookmarkMappingDTO {
    private int planDetailCode;
    private int bookmarkCode;
    private int userCode;

    public BookmarkMappingDTO() {
    }

    public BookmarkMappingDTO(int planDetailCode, int bookmarkCode, int userCode) {
        this.planDetailCode = planDetailCode;
        this.bookmarkCode = bookmarkCode;
        this.userCode = userCode;
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

    @Override
    public String toString() {
        return "BookmarkMappingDTO{" +
                "planDetailCode=" + planDetailCode +
                ", bookmarkCode=" + bookmarkCode +
                ", userCode=" + userCode +
                '}';
    }
}

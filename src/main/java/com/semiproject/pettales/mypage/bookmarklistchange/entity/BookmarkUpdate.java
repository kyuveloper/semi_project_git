package com.semiproject.pettales.mypage.bookmarklistchange.entity;

import com.semiproject.pettales.mypage.userupdate.entity.UserUpdate;
import jakarta.persistence.*;

@Entity
@Table(name = "BOOKMARK_TABLE")
public class BookmarkUpdate {
        @Id
        @Column(name = "BOOKMARK_CODE")
        private Integer bookmarkCode;

        @ManyToOne
        @JoinColumn(name = "COMPANY_CODE")
        private com.semiproject.pettales.mypage.bookmarklistchange.entity.CompanyTable CompanyTable;

        @ManyToOne
        @JoinColumn(name = "USER_CODE")
        private UserUpdate userUpdate;

        @Column(name = "BOOKMARKED")
        private Boolean bookmarked;






    public BookmarkUpdate() {
    }

    public BookmarkUpdate(Integer bookmarkCode, com.semiproject.pettales.mypage.bookmarklistchange.entity.CompanyTable companyTable, UserUpdate userUpdate, Boolean bookmarked) {
        this.bookmarkCode = bookmarkCode;
        this.CompanyTable = companyTable;
        this.userUpdate = userUpdate;
        this.bookmarked = bookmarked;
    }

    public Integer getBookmarkCode() {
        return bookmarkCode;
    }

    public void setBookmarkCode(Integer bookmarkCode) {
        this.bookmarkCode = bookmarkCode;
    }

    public com.semiproject.pettales.mypage.bookmarklistchange.entity.CompanyTable getCompanyTable() {
        return CompanyTable;
    }

    public void setCompanyTable(com.semiproject.pettales.mypage.bookmarklistchange.entity.CompanyTable companyTable) {
        CompanyTable = companyTable;
    }

    public UserUpdate getUserUpdate() {
        return userUpdate;
    }

    public void setUserUpdate(UserUpdate userUpdate) {
        this.userUpdate = userUpdate;
    }

    public Boolean getBookmarked() {
        return bookmarked;
    }

    public void setBookmarked(Boolean bookmarked) {
        this.bookmarked = bookmarked;
    }

    @Override
    public String toString() {
        return "BookmarkUpdate{" +
                "bookmarkCode=" + bookmarkCode +
                ", CompanyTable=" + CompanyTable +
                ", UserUpdate=" + userUpdate +
                ", bookmarked=" + bookmarked +
                '}';
    }
}

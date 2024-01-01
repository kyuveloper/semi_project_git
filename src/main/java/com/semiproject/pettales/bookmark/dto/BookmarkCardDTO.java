package com.semiproject.pettales.bookmark.dto;

import com.semiproject.pettales.adminpage.model.dto.UserTableDTO;
import com.semiproject.pettales.company.dto.CompanyDTO;

public class BookmarkCardDTO {
    // 유저 정보
    private UserTableDTO user;
    // 회사
    private CompanyDTO company;
    // 북마크
    private BookmarkDTO bookmarkDTO;

    public BookmarkCardDTO() {
    }

    public BookmarkCardDTO(UserTableDTO user, CompanyDTO company, BookmarkDTO bookmarkDTO) {
        this.user = user;
        this.company = company;
        this.bookmarkDTO = bookmarkDTO;
    }

    public UserTableDTO getUser() {
        return user;
    }

    public void setUser(UserTableDTO user) {
        this.user = user;
    }

    public CompanyDTO getCompany() {
        return company;
    }

    public void setCompany(CompanyDTO company) {
        this.company = company;
    }

    public BookmarkDTO getBookmarkDTO() {
        return bookmarkDTO;
    }

    public void setBookmarkDTO(BookmarkDTO bookmarkDTO) {
        this.bookmarkDTO = bookmarkDTO;
    }

    @Override
    public String toString() {
        return "BookmarkCardDTO{" +
                "user=" + user +
                ", company=" + company +
                ", bookmarkDTO=" + bookmarkDTO +
                '}';
    }
}

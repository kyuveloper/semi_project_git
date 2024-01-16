package com.semiproject.pettales.company.dto;

import com.semiproject.pettales.bookmark.dto.BookmarkDTO;
import com.semiproject.pettales.user.model.dto.LoginUserDTO;

import java.util.List;

public class CompanyCardDTO {
    private LoginUserDTO user;
    private CompanyDTO companyDTO;
    private BookmarkDTO bookmarkDTO;

    public CompanyCardDTO() {
    }

    public CompanyCardDTO(LoginUserDTO user, CompanyDTO companyDTO, BookmarkDTO bookmarkDTO) {
        this.user = user;
        this.companyDTO = companyDTO;
        this.bookmarkDTO = bookmarkDTO;
    }

    public LoginUserDTO getUser() {
        return user;
    }

    public void setUser(LoginUserDTO user) {
        this.user = user;
    }

    public CompanyDTO getCompanyDTO() {
        return companyDTO;
    }

    public void setCompanyDTO(CompanyDTO companyDTO) {
        this.companyDTO = companyDTO;
    }

    public BookmarkDTO getBookmarkDTO() {
        return bookmarkDTO;
    }

    public void setBookmarkDTO(BookmarkDTO bookmarkDTO) {
        this.bookmarkDTO = bookmarkDTO;
    }

    @Override
    public String toString() {
        return "CompanyCardDTO{" +
                "user=" + user +
                ", companyDTO=" + companyDTO +
                ", bookmarkDTO=" + bookmarkDTO +
                '}';
    }
}

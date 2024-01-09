package com.semiproject.pettales.mypage.mypage.entity;

import com.semiproject.pettales.mypage.bookmarklistchange.entity.BookmarkUpdate;
import com.semiproject.pettales.mypage.doglistchange.entity.PetUpdate;
import com.semiproject.pettales.mypage.userupdate.entity.UserUpdate;

import java.util.List;

public class Mypage {
    private UserUpdate userUpdate;
    private List<BookmarkUpdate> bookmarkUpdates;
    private List<PetUpdate> petUpdates;

    public Mypage() {
    }

    public Mypage(UserUpdate userUpdate, List<BookmarkUpdate> bookmarkUpdates, List<PetUpdate> petUpdates) {
        this.userUpdate = userUpdate;
        this.bookmarkUpdates = bookmarkUpdates;
        this.petUpdates = petUpdates;
    }

    public UserUpdate getUserUpdate() {
        return userUpdate;
    }

    public void setUserUpdate(UserUpdate userUpdate) {
        this.userUpdate = userUpdate;
    }

    public List<BookmarkUpdate> getBookmarkUpdates() {
        return bookmarkUpdates;
    }

    public void setBookmarkUpdates(List<BookmarkUpdate> bookmarkUpdates) {
        this.bookmarkUpdates = bookmarkUpdates;
    }

    public List<PetUpdate> getPetUpdates() {
        return petUpdates;
    }

    public void setPetUpdates(List<PetUpdate> petUpdates) {
        this.petUpdates = petUpdates;
    }


    @Override
    public String toString() {
        return "Mypage{" +
                "userUpdate=" + userUpdate +
                ", bookmarkUpdates=" + bookmarkUpdates +
                ", petUpdates=" + petUpdates +
                '}';
    }
}


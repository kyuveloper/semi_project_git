package com.semiproject.pettales.mypage.bookmarklistchange.repository;

import com.semiproject.pettales.mypage.bookmarklistchange.entity.BookmarkUpdate;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookmarkUpdateRepository extends JpaRepository<BookmarkUpdate, Integer> {
    List<BookmarkUpdate> findByUserUpdate_UserCode(int userCode);
}
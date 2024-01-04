package com.semiproject.pettales.AAmypage.bookmarklistchange.repository;

import com.semiproject.pettales.AAmypage.bookmarklistchange.entity.BookmarkUpdate;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookmarkUpdateRepository extends JpaRepository<BookmarkUpdate, Integer> {
    List<BookmarkUpdate> findByUserUpdate_UserCode(int userCode);
}
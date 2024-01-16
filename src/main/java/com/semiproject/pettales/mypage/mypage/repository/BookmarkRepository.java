package com.semiproject.pettales.mypage.mypage.repository;

import com.semiproject.pettales.mypage.bookmarklistchange.entity.BookmarkUpdate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface BookmarkRepository extends JpaRepository<BookmarkUpdate, Integer> {
    List<BookmarkUpdate> findByUserUpdate_UserCode(int userId);
}

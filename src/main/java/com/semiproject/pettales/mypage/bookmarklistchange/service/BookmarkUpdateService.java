package com.semiproject.pettales.mypage.bookmarklistchange.service;


import com.semiproject.pettales.mypage.bookmarklistchange.entity.BookmarkUpdate;
import com.semiproject.pettales.mypage.bookmarklistchange.repository.BookmarkUpdateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookmarkUpdateService {

    @Autowired
    private BookmarkUpdateRepository bookmarkUpdateRepository;

    // 사용자에 따른 북마크 목록 조회
    public List<BookmarkUpdate> getBookmarksByUserId(int userCode) {
        return bookmarkUpdateRepository.findByUserUpdate_UserCode(userCode);
    }

    // 북마크 추가
    public void addBookmark(BookmarkUpdate bookmark) {
        bookmarkUpdateRepository.save(bookmark);
    }

    // 북마크 삭제
    public void removeBookmark(Integer id) {
        bookmarkUpdateRepository.deleteById(id);
    }
}
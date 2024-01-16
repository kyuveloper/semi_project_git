package com.semiproject.pettales.mypage.bookmarklistchange.controller;

import com.semiproject.pettales.mypage.bookmarklistchange.entity.BookmarkUpdate;
import com.semiproject.pettales.mypage.bookmarklistchange.service.BookmarkUpdateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class BookmarkUpdateController {

    @Autowired
    private BookmarkUpdateService bookmarkUpdateService;

    // 북마크 목록 조회
    @GetMapping("/mypage/bookmark")
    public ResponseEntity<List<BookmarkUpdate>> getBookmarksByUserId(@PathVariable int userCode) {
        List<BookmarkUpdate> bookmarks = bookmarkUpdateService.getBookmarksByUserId(userCode);
        return new ResponseEntity<>(bookmarks, HttpStatus.OK);
    }


    // 북마크 삭제
    @DeleteMapping("/mypage/bookmark/{id}")
    public ResponseEntity<Void> removeBookmark(@PathVariable Integer id) {
        bookmarkUpdateService.removeBookmark(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
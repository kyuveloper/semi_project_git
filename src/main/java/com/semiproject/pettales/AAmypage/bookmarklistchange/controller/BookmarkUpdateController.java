package com.semiproject.pettales.AAmypage.bookmarklistchange.controller;

import com.semiproject.pettales.AAmypage.bookmarklistchange.entity.BookmarkUpdate;
import com.semiproject.pettales.AAmypage.bookmarklistchange.service.BookmarkUpdateService;
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
    @GetMapping("/mypage/bookmark/{userCode}")
    public ResponseEntity<List<BookmarkUpdate>> getBookmarksByUserId(@PathVariable int userCode) {
        List<BookmarkUpdate> bookmarks = bookmarkUpdateService.getBookmarksByUserId(userCode);
        return new ResponseEntity<>(bookmarks, HttpStatus.OK);
    }

    // 북마크 추가
    @PostMapping("/mypage/bookmark/{userCode}")
    public ResponseEntity<BookmarkUpdate> addBookmark(@RequestBody BookmarkUpdate bookmark) {
        bookmarkUpdateService.addBookmark(bookmark);
        return new ResponseEntity<>(bookmark, HttpStatus.CREATED);
    }

    // 북마크 삭제
    @DeleteMapping("/mypage/bookmark/{id}")
    public ResponseEntity<Void> removeBookmark(@PathVariable Integer id) {
        bookmarkUpdateService.removeBookmark(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
package com.semiproject.pettales.bookmark.controller;

import com.semiproject.pettales.auth.model.AuthDetails;
import com.semiproject.pettales.bookmark.service.BookmarkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/bookmark")
public class BookmarkRestController {
    @Autowired
    private BookmarkService bookmarkService;

    @PostMapping("/insert")
    public int insertBookmark(
            @RequestParam("companyCode") int companyCode){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        AuthDetails auth = (AuthDetails)authentication.getPrincipal();
//        System.out.println(auth.getLoginUserDTO().getUserCode());
        int userCode = auth.getLoginUserDTO().getUserCode();

        return bookmarkService.insertBookmarkByComCode(companyCode,userCode);
    }

    @PutMapping("/delete")
    public int deleteBookmark(
            @RequestParam("bookmarkCode")int bookmarkCode){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        AuthDetails auth = (AuthDetails)authentication.getPrincipal();
        int userCode = auth.getLoginUserDTO().getUserCode();

        return bookmarkService.deleteBookmark(bookmarkCode, userCode);
    }


}

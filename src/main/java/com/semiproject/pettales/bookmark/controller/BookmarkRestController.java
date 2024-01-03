package com.semiproject.pettales.bookmark.controller;

import com.semiproject.pettales.auth.model.AuthDetails;
import com.semiproject.pettales.bookmark.service.BookmarkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/bookmark")
public class BookmarkRestController {
    @Autowired
    private BookmarkService bookmarkService;

    @PostMapping("/toggle")
    public Map<String, Object> bookmark(
            @RequestParam("companyCode")int companyCode){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        AuthDetails auth = (AuthDetails)authentication.getPrincipal();
        Integer userCode = auth.getLoginUserDTO().getUserCode();
        Map<String, Object> result = new HashMap<>();
        bookmarkService.bookmarkToggle(companyCode, userCode);

        if (userCode == null) {
            result.put("code", "0");
            result.put("result", "error");
            result.put("errorMessage", "유저 정보를 찾을 수 없습니다.");
        } else {
            result.put("code", "1");
            result.put("result", "성공");
        }
        System.out.println(companyCode);
        return result;
    }

    @PostMapping("/delete")
    public Map<String, Object> deleteBookmarkByBookCode(
            @RequestParam("bookmarkCode")int bookmarkCode){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        AuthDetails auth = (AuthDetails)authentication.getPrincipal();
        Integer userCode = auth.getLoginUserDTO().getUserCode();
        Map<String, Object> result = new HashMap<>();
        bookmarkService.deleteBookmarkByBookCode(userCode, bookmarkCode);
        if(userCode == null){
            result.put("code", 0);
            result.put("result", "error");
            result.put("errorMessage", "유저 정보를 찾을 수 없습니다."); // 적절한 에러 메시지로 변경
        } else{
            result.put("code", "1");
            result.put("result", "성공");
        }
        return result;
    }

}

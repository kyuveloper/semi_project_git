package com.semiproject.pettales.mypage.mypage.controller;

import com.semiproject.pettales.mypage.bookmarklistchange.entity.BookmarkUpdate;
import com.semiproject.pettales.mypage.doglistchange.entity.PetUpdate;
import com.semiproject.pettales.mypage.mypage.entity.Mypage;
import com.semiproject.pettales.mypage.mypage.service.MypageService;
import com.semiproject.pettales.mypage.userupdate.entity.UserUpdate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;



@RestController
@RequestMapping("/user")
public class MypageController {

    @Autowired
    private MypageService mypageService;

    @GetMapping("/mypage")
    public ModelAndView getMyPage() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        // 인증된 사용자가 없는 경우
        if (authentication == null || authentication.getPrincipal().equals("anonymousUser")) {
            ModelAndView mav = new ModelAndView("redirect:/login");
            mav.addObject("errorMessage", "로그인이 필요합니다.");
            return mav;
        }

        String currentPrincipalName = authentication.getName();

        // 현재 사용자 정보를 가져오는 로직...
        UserUpdate userUpdate = mypageService.getUserByEmail(currentPrincipalName);
        List<BookmarkUpdate> bookmarkUpdates = mypageService.getBookmarksByUserId(userUpdate.getUserCode());
        List<PetUpdate> petUpdates = mypageService.getPetsByUserId(userUpdate.getUserCode());

        Mypage mypage = new Mypage();
        mypage.setUserUpdate(userUpdate);
        mypage.setBookmarkUpdates(bookmarkUpdates);
        mypage.setPetUpdates(petUpdates);

        ModelAndView mav = new ModelAndView("user/mypage");
        mav.addObject("mypage", mypage);

        return mav;
    }

}

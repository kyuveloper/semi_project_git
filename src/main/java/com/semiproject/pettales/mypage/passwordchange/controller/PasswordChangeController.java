package com.semiproject.pettales.mypage.passwordchange.controller;

import com.semiproject.pettales.auth.model.AuthDetails;
import com.semiproject.pettales.mypage.userupdate.entity.UserUpdate; // userupdate엔티티 임포트함
import com.semiproject.pettales.mypage.userupdate.service.UserUpdateService;
import org.springframework.security.core.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import jakarta.servlet.http.HttpSession;
@Controller
@RequestMapping("/user")
public class PasswordChangeController {

    @Autowired
    private UserUpdateService userUpdateService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    // 비밀번호 변경 페이지로 이동
    @GetMapping("/mypage/changepass")
    public String changePassword() {
        return "mypage/changepass";
    }

    // 비밀번호 변경 처리
    @PostMapping("/mypage/changepass")
    public String updatePassword(HttpSession session, @RequestParam("oldPassword") String oldPassword, @RequestParam("newPassword") String newPassword, RedirectAttributes redirectAttributes) {
        // 세션에서 사용자 인증 정보를 가져옴
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        AuthDetails auth = (AuthDetails)authentication.getPrincipal();
        int userCode = auth.getLoginUserDTO().getUserCode();

        // 사용자 정보를 가져옴
        UserUpdate userUpdate = userUpdateService.getUserUpdate(userCode);

        if (userUpdate != null) {
            // 현재 비밀번호와 이전 비밀번호가 일치하는지 확인
            if (passwordEncoder.matches(oldPassword, userUpdate.getUserPassword())) {
                // 새 비밀번호를 암호화하여 설정
                userUpdate.setUserPassword(passwordEncoder.encode(newPassword));
                // 사용자 정보 업데이트
                userUpdateService.saveUserUpdate(userUpdate);
                redirectAttributes.addFlashAttribute("success", "비밀번호가 성공적으로 변경되었습니다.");
            } else {
                // 현재 비밀번호와 이전 비밀번호가 일치하지 않는 경우
                redirectAttributes.addFlashAttribute("error", "현재 비밀번호와 일치하지 않습니다.");
            }
        } else {
            // 사용자 정보를 찾을 수 없는 경우
            redirectAttributes.addFlashAttribute("error", "사용자를 찾을 수 없습니다.");
        }

        return "redirect:/user/mypage";
    }
}
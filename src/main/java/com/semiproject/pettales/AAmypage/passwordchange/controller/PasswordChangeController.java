package com.semiproject.pettales.AAmypage.passwordchange.controller;

import com.semiproject.pettales.AAmypage.userupdate.entity.UserUpdate; // userupdate엔티티 임포트함
import com.semiproject.pettales.AAmypage.userupdate.service.UserUpdateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import javax.servlet.http.HttpSession;
import java.util.Date;

@Controller
@RequestMapping("/user")
public class PasswordChangeController {

    @Autowired
    private UserUpdateService userUpdateService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    // 사용자 비밀번호 변경 페이지를 반환하는 메서드입니다.
    @GetMapping("/mypage/changepass")
    public String changePassword() {
        return "mypage/changepass";
    }

    // 사용자 비밀번호를 변경하는 메서드입니다.
    @PostMapping("/mypage/changepass")
    public String updatePassword(HttpSession session, @RequestParam("oldPassword") String oldPassword, @RequestParam("newPassword") String newPassword, RedirectAttributes redirectAttributes) {
        int userCode = (int) session.getAttribute("USER_CODE");

        // 세션에서 사용자 코드를 가져와서 해당 사용자의 정보를 찾습니다.
        UserUpdate userUpdate = userUpdateService.findById(userCode).orElse(null);

        // 사용자의 현재 비밀번호와 입력한 이전 비밀번호가 일치하는지 확인합니다.
        if (userUpdate != null && passwordEncoder.matches(oldPassword, userUpdate.getUserPassword())) {
            // 새 비밀번호를 암호화하여 설정하고, 업데이트 날짜를 현재 날짜로 설정합니다.
            userUpdate.setUserPassword(passwordEncoder.encode(newPassword));
            userUpdate.setUpdateDate(new Date());

            // 사용자 정보를 업데이트합니다.
            userUpdateService.save(userUpdate);
            redirectAttributes.addFlashAttribute("success", "비밀번호가 성공적으로 변경되었습니다.");
        } else {
            // 현재 비밀번호와 입력한 이전 비밀번호가 일치하지 않으면 오류 메시지를 반환합니다.
            redirectAttributes.addFlashAttribute("error", "비밀번호 확인이 일치하지 않습니다.");
        }

        return "redirect:/user/mypage";
    }
}

//auth.requestMatchers("/admin/**").hasAnyAuthority(UserAuth.ADMIN.getAuth());
//auth.requestMatchers("/user/**").hasAnyAuthority(UserAuth.USER.getAuth(), UserAuth.ADMIN.getAuth());

/*
컨트롤러(Controller) 클래스
사용자의 HTTP 요청을 받아 적절한 서비스 메소드를 호출하고,
그 결과를 사용자에게 반환합니다.
 */

package com.semiproject.pettales.AAadminpage.userstatuspage.controller;

import com.semiproject.pettales.AAadminpage.userstatuspage.service.AdminUserTableStatusService;
import com.semiproject.pettales.AAadminpage.model.dto.UserTableDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminUserTableStatusController {

    private AdminUserTableStatusService adminUserTableStatusService;

    @Autowired
    public AdminUserTableStatusController(AdminUserTableStatusService adminUserTableStatusService) {
        this.adminUserTableStatusService = adminUserTableStatusService;
    }

    // 사용자 목록을 페이지별로 표시하는 메소드
    @GetMapping("/userstatus")
    public ModelAndView listUsers(@RequestParam(value = "page", defaultValue = "1") int page, ModelAndView mv) {
        int totalUserCount = adminUserTableStatusService.getUserCount();
        List<UserTableDTO> users = adminUserTableStatusService.getUsersPerPage(page, 20);
        mv.addObject("users", users);
        mv.addObject("totalUserCount", totalUserCount);
        mv.addObject("currentPage", page);
        mv.setViewName("/admin/userstatus");
        mv.addObject("usersCountOnPage", users.size()); // 현재 페이지에 표시된 사용자 수 추가
        return mv;
    }

    // 사용자 정보 수정 페이지를 표시하는 메소드
    @GetMapping("/userstatus/edit/{userCode}")
    public ModelAndView showEditUserPage(@PathVariable int userCode) {
        UserTableDTO userDto = adminUserTableStatusService.getUserInfo(userCode);
        ModelAndView mv = new ModelAndView();
        mv.addObject("user", userDto);
        mv.setViewName("/admin/userstatus/edit");

        return mv;
    }

    // 사용자 정보를 수정하는 메소드
    @PostMapping ("/userstatus/edit/{userCode}")
    public ModelAndView updateUser(@PathVariable int userCode, @ModelAttribute UserTableDTO userDto, HttpServletRequest request) {
        ModelAndView mv = new ModelAndView(); // 새로운 ModelAndView 객체 생성
        userDto.setUserCode(userCode);
        adminUserTableStatusService.updateUserInfo(userDto);

        HttpSession session = (HttpSession) request.getSession();
        session.setAttribute("message", "수정되었습니다."); // 성공 메시지를 세션에 추가

        mv.setViewName("redirect:/admin/userstatus");
        return mv;
    }


    // 사용자 삭제 메소드
    @PostMapping("/userstatus/delete/{userCode}")
    public ModelAndView deleteUse(@PathVariable int userCode, RedirectAttributes redirectAttributes) {
        ModelAndView mv = new ModelAndView();
        UserTableDTO userTarget = adminUserTableStatusService.getUserInfo(userCode);
        if (userTarget != null) {
            adminUserTableStatusService.deleteUser(userCode);
            redirectAttributes.addFlashAttribute("successMessage", "삭제되었습니다.");
            mv.setViewName("redirect:/admin/userstatus");
        } else {
            mv.addObject("error", "해당 사용자를 찾을 수 없습니다.");
            mv.setViewName("/admin/userstatus");
        }
        return mv;
    }

    // 키워드로 사용자를 검색하는 메소드
    @GetMapping("/userstatus/search")
    public ModelAndView searchUsers(@RequestParam String keyword, ModelAndView mv) {
        List<UserTableDTO> users = adminUserTableStatusService.searchUsers(keyword);
        mv.addObject("users", users);
        mv.setViewName("/admin/userstatus/search");
        return mv;
    }

    // 사용자 등록 페이지를 표시하는 메소드
    @GetMapping("/userstatus/add")
    public String showAddUserForm() {
        return "/admin/userstatus/add";
    }

    // POST 요청으로 사용자 데이터를 등록하는 메소드
    @PostMapping("/userstatus/add")
    public ModelAndView addUser(@ModelAttribute UserTableDTO userDto, RedirectAttributes redirectAttributes) {
        ModelAndView mv = new ModelAndView();

//        // Google Cloud Storage에 이미지를 업로드하고 URL를 가져옵니다.
//        String imageUrl = uploadImageToGoogleCloud(userDto.getImage());
//        userDto.setUserImageUrl(imageUrl);

        adminUserTableStatusService.addUser(userDto);
        redirectAttributes.addFlashAttribute("successMessage", "새 사용자가 등록되었습니다.");
        mv.setViewName("redirect:/admin/userstatus");
        return mv;
    }

//    private String uploadImageToGoogleCloud(MultipartFile imageFile) {
//        Storage storage = StorageOptions.getDefaultInstance().getService();
//
//        String bucketName = "YOUR_BUCKET_NAME";  // 여기에는 실제 버킷 이름을 입력해야 합니다.
//        String blobName = UUID.randomUUID().toString();  // 각 이미지에 고유한 이름을 부여합니다.
//
//        BlobId blobId = BlobId.of(bucketName, blobName);
//        BlobInfo blobInfo = BlobInfo.newBuilder(blobId).setContentType(imageFile.getContentType()).build();
//
//        try {
//            storage.create(blobInfo, imageFile.getBytes());
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        // 이미지 URL을 반환합니다.
//        return String.format("https://storage.googleapis.com/%s/%s", bucketName, blobName);
//    }


}

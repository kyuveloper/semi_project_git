//auth.requestMatchers("/admin/**").hasAnyAuthority(UserAuth.ADMIN.getAuth());
//auth.requestMatchers("/user/**").hasAnyAuthority(UserAuth.USER.getAuth(), UserAuth.ADMIN.getAuth());

/*
컨트롤러(Controller) 클래스
사용자의 HTTP 요청을 받아 적절한 서비스 메소드를 호출하고,
그 결과를 사용자에게 반환합니다.
 */

package com.semiproject.pettales.adminpage.userstatuspage.controller;

import com.semiproject.pettales.adminpage.userstatuspage.service.AdminUserTableStatusService;
import com.semiproject.pettales.adminpage.model.dto.UserTableDTO;
import com.semiproject.pettales.adminpage.userstatuspage.service.ImageService;
import com.semiproject.pettales.mypage.userupdate.entity.UserUpdate;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminUserTableStatusController {

    private final AdminUserTableStatusService adminUserTableStatusService;
    private final ImageService imageService;  // 이미지 서비스를 추가
    private String uploadDir; // 이미지를 저장할 디렉토리 경로

    @Autowired
    public AdminUserTableStatusController(AdminUserTableStatusService adminUserTableStatusService,
                                          ImageService imageService) {
        this.adminUserTableStatusService = adminUserTableStatusService;
        this.imageService = new ImageService("src/main/resources/static/images/user");  // 이미지 서비스 초기화

        // 이미지를 저장할 경로를 설정합니다. 예를 들어, src/main/resources/static/images 폴더를 사용할 수 있습니다.
        this.uploadDir = "src/main/resources/static/images/user";
    }


    // 사용자 정보를 수정하는 메소드
    @PostMapping ("/userstatus/edit/{userCode}")
    public ModelAndView updateUser(@PathVariable int userCode,
                                   @ModelAttribute UserUpdate userUpdate,
                                   @RequestParam("image") MultipartFile file,
                                   HttpServletRequest request,
                                   RedirectAttributes redirectAttributes) throws IOException {
        ModelAndView mv = new ModelAndView(); // 새로운 ModelAndView 객체 생성

        if (file != null && !file.isEmpty()) {

            String validationError = validateImage(file);
            if (validationError != null) {
                redirectAttributes.addFlashAttribute("error", validationError);
                String referer = request.getHeader("Referer");
                mv.setViewName("redirect:" + referer);
                return mv;
            }

            // 이미지 파일을 저장하고, 파일 정보를 userUpdate 객체에 설정
            saveImageAndUpdateUser(file, userUpdate);
        }

        // 사용자 정보를 업데이트
        adminUserTableStatusService.saveUserUpdate(userUpdate);

        redirectAttributes.addFlashAttribute("message", "수정되었습니다.");

        mv.setViewName("redirect:/admin/userstatus");
        return mv;
    }

    // 이미지 파일에 대한 유효성 검사를 수행하는 메소드
    private String validateImage(MultipartFile file) throws IOException {
        // 파일 확장자 검사
        String filename = file.getOriginalFilename();
        String extension = FilenameUtils.getExtension(filename).toLowerCase();
        // 파일 확장자가 jpg 또는 png가 아니면 오류 메시지를 반환합니다.
        if (!extension.equals("jpg") && !extension.equals("png")) {
            return "프로필 이미지는 jpg 또는 png 파일만 가능합니다.";
        }
        // 파일 크기가 5MB를 초과하면 오류 메시지를 반환합니다.
        if (file.getSize() > 5 * 1024 * 1024) { // 5MB 제한
            return "프로필 이미지는 5MB 이내의 파일만 가능합니다.";
        }
        // 이미지의 가로 또는 세로가 500px을 초과하면 오류 메시지를 반환합니다.
        BufferedImage image = ImageIO.read(file.getInputStream());
        if (image.getWidth() > 500 || image.getHeight() > 500) {
            return "프로필 이미지는 500x500 픽셀 이내의 이미지만 가능합니다.";
        }
        return null;
    }

    // 이미지 파일을 저장하고, 파일 정보를 userUpdate 객체에 설정하는 메소드
    private void saveImageAndUpdateUser(MultipartFile file, UserUpdate userUpdate) throws IOException {
        // 이미지 서비스를 통해 이미지를 저장하고, 파일 이름을 가져옵니다.
        String filename = imageService.saveImage(file);

        // 파일 경로를 UserUpdate 객체에 설정합니다.
        String imagePath = "/images/" + filename; // 정적 리소스 경로를 설정합니다.
        userUpdate.setImagePath(imagePath);

        // 파일 이름을 UserUpdate 객체의 userImg 필드에 설정합니다.
        userUpdate.setUserImg(filename);

        // 업데이트 날짜를 현재 날짜로 설정합니다.
        userUpdate.setUpdateDate(new Date());
    }


    // 사용자 목록을 페이지별로 표시하는 메소드
    @GetMapping("/userstatus")
    public ModelAndView listUsers(@RequestParam(value = "page", defaultValue = "1") int page, ModelAndView mv) {
        int totalUserCount = adminUserTableStatusService.getUserCount();
        List<UserTableDTO> users = adminUserTableStatusService.getUsersPerPage(page, 20);
        mv.addObject("users", users);
        mv.addObject("totalUserCount", totalUserCount);
        mv.addObject("currentPage", page);
        mv.setViewName("admin/userstatus");
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
            mv.setViewName("redirect:admin/userstatus");
        }
        return mv;
    }

    // 키워드로 사용자를 검색하는 메소드
    @GetMapping("/userstatus/search")
    public ModelAndView searchUsers(@RequestParam String keyword, ModelAndView mv) {
        List<UserTableDTO> users = adminUserTableStatusService.searchUsers(keyword);
        mv.addObject("users", users);
        mv.setViewName("admin/userstatus/search");
        return mv;
    }

    // 사용자 등록 페이지를 표시하는 메소드
    @GetMapping("/userstatus/add")
    public String showAddUserForm() {
        return "admin/userstatus/add";
    }

    // POST 요청으로 사용자 데이터를 등록하는 메소드
    @PostMapping("/userstatus/add")
    public ModelAndView addUser(@ModelAttribute UserTableDTO userDto, RedirectAttributes redirectAttributes) {
        ModelAndView mv = new ModelAndView();
        adminUserTableStatusService.addUser(userDto);
        redirectAttributes.addFlashAttribute("successMessage", "새 사용자가 등록되었습니다.");
        mv.setViewName("redirect:/admin/userstatus");
        return mv;
    }




}

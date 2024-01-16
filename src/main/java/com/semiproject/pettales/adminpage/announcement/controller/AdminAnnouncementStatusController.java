/*
컨트롤러(Controller) 클래스
사용자의 HTTP 요청을 받아 적절한 서비스 메소드를 호출하고,
그 결과를 사용자에게 반환합니다.
*/

package com.semiproject.pettales.adminpage.announcement.controller;

import com.semiproject.pettales.adminpage.announcement.service.AdminAnnouncementStatusService;
import com.semiproject.pettales.adminpage.model.dto.AnnouncementDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/admins")
public class AdminAnnouncementStatusController {

    private final AdminAnnouncementStatusService adminAnnouncementStatusService;

    @Autowired
    public AdminAnnouncementStatusController(AdminAnnouncementStatusService adminAnnouncementStatusService) {
        this.adminAnnouncementStatusService = adminAnnouncementStatusService; // 생성자를 통한 주입
    }

    // 공지사항 목록을 페이지별로 표시하는 메소드
    @GetMapping("/announcements")
    public ModelAndView listAnnouncements(@RequestParam(value = "page", defaultValue = "1") int page) {
        ModelAndView mv = new ModelAndView();
        int totalAnnouncementCount = adminAnnouncementStatusService.getAnnouncementCount();
        List<AnnouncementDTO> announcements = adminAnnouncementStatusService.getAnnouncementsPerPage(page, 20);
        mv.addObject("announcements", announcements);
        mv.addObject("totalAnnouncementCount", totalAnnouncementCount);
        mv.addObject("currentPage", page);
        mv.setViewName("/admins/announcements");
        mv.addObject("usersCountOnPage", announcements.size()); // 현재 페이지에 표시된 수 추가
        mv.addObject("announcementsCountOnPage", announcements.size()); // 현재 페이지에 표시된 공지사항 수 추가
        return mv;
    }

    // 공지사항 수정 페이지를 표시하는 메소드
    @GetMapping("/announcements/edit/{companyCode}")
    public ModelAndView showEditCompanyPage(@PathVariable int annoCode) {
        AnnouncementDTO announceDto = adminAnnouncementStatusService.getAnnouncementInfo(annoCode);
        ModelAndView mv = new ModelAndView();
        mv.addObject("company", announceDto);
        mv.setViewName("/admins/announcements/edit");
        return mv;
    }

    // 공지사항을 수정하는 메소드
    @PostMapping("/announcements/edit/{companyCode}")
    public ModelAndView updateCompany(@PathVariable int annoCode, @ModelAttribute AnnouncementDTO announceDto, HttpServletRequest request) {
        ModelAndView mv = new ModelAndView();
        adminAnnouncementStatusService.updateAnnouncementInfo(annoCode, announceDto);
        mv.setViewName("redirect:/admins/announcements");
        return mv;
    }

    // 공지사항 삭제 메소드
    @PostMapping("/announcements/delete/{companyCode}")
    public ModelAndView deleteCompany(@PathVariable int companyCode, RedirectAttributes redirectAttributes) {
        ModelAndView mv = new ModelAndView();
        adminAnnouncementStatusService.deleteAnnouncement(companyCode);
        redirectAttributes.addFlashAttribute("successMessage", "공지사항이 삭제되었습니다.");
        mv.setViewName("redirect:/admins/announcements");
        return mv;
    }

    // 키워드로 회사를 검색하는 메소드
    @GetMapping("/announcements/search")
    public ModelAndView searchCompanies(@RequestParam String keyword) {
        ModelAndView mv = new ModelAndView();
        List<AnnouncementDTO> announcements = adminAnnouncementStatusService.searchAnnouncements(keyword);
        mv.addObject("announcements", announcements);
        mv.setViewName("/admins/announcements/search");
        return mv;
    }

    // 공지사항 등록 페이지를 표시하는 메소드
    @GetMapping("/announcements/add")
    public String showAddCompanyForm() {
        return "/admins/announcements/add";
    }


    // POST 요청으로 공지사항 데이터를 등록하는 메소드
    @PostMapping("/announcements/add")
    public ModelAndView addCompany(@ModelAttribute AnnouncementDTO announceDto, RedirectAttributes redirectAttributes) {
        ModelAndView mv = new ModelAndView();
        adminAnnouncementStatusService.addAnnouncement(announceDto);
        redirectAttributes.addFlashAttribute("successMessage", "공지사항이 등록되었습니다.");
        mv.setViewName("redirect:/admins/announcements");
        return mv;
    }


}
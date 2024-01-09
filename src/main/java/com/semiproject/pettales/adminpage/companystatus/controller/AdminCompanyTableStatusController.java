/*
컨트롤러(Controller) 클래스
사용자의 HTTP 요청을 받아 적절한 서비스 메소드를 호출하고,
그 결과를 사용자에게 반환합니다.
 */

package com.semiproject.pettales.adminpage.companystatus.controller;

import com.semiproject.pettales.adminpage.companystatus.service.AdminCompanyTableStatusService;
import com.semiproject.pettales.adminpage.model.dto.CompanyTableDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/admins")
public class AdminCompanyTableStatusController {

    private final AdminCompanyTableStatusService adminCompanyTableStatusService;

    @Autowired
    public AdminCompanyTableStatusController(AdminCompanyTableStatusService adminCompanyTableStatusService) {
        this.adminCompanyTableStatusService = adminCompanyTableStatusService;
    }

    // 회사 목록을 페이지별로 표시하는 메소드
    @GetMapping("/companystatus")
    public ModelAndView listCompanies(@RequestParam(value = "page", defaultValue = "1") int page) {
        ModelAndView mv = new ModelAndView();
        List<CompanyTableDTO> companies = adminCompanyTableStatusService.getCompaniesPerPage(page, 10);
        int totalCompanyCount = adminCompanyTableStatusService.getCompanyCount();
        mv.addObject("companies", companies);
        mv.addObject("totalCompanyCount", totalCompanyCount);
        mv.addObject("currentPage", page);
        mv.addObject("companiesCountOnPage", companies.size());
        mv.setViewName("/admins/companystatus");
        return mv;
    }

    // 회사 정보 수정 페이지를 표시하는 메소드
    @GetMapping("/companystatus/edit/{companyCode}")
    public ModelAndView showEditCompanyPage(@PathVariable int companyCode) {
        CompanyTableDTO companyDto = adminCompanyTableStatusService.getCompanyInfo(companyCode);
        ModelAndView mv = new ModelAndView();
        mv.addObject("company", companyDto);
        mv.setViewName("/admins/companystatus/edit");
        return mv;
    }

    // 회사 정보를 수정하는 메소드
    @PostMapping("/companystatus/edit/{companyCode}")
    public ModelAndView updateCompany(@PathVariable int companyCode, @ModelAttribute CompanyTableDTO companyDto, HttpServletRequest request) {
        ModelAndView mv = new ModelAndView();
        adminCompanyTableStatusService.updateCompanyInfo(companyCode, companyDto);
        mv.setViewName("redirect:/admins/companystatus");
        return mv;
    }

    // 회사 삭제 메소드
    @PostMapping("/companystatus/delete/{companyCode}")
    public ModelAndView deleteCompany(@PathVariable int companyCode, RedirectAttributes redirectAttributes) {
        ModelAndView mv = new ModelAndView();
        adminCompanyTableStatusService.deleteCompany(companyCode);
        redirectAttributes.addFlashAttribute("successMessage", "회사가 삭제되었습니다.");
        mv.setViewName("redirect:/admins/companystatus");
        return mv;
    }

    // 키워드로 회사를 검색하는 메소드
    @GetMapping("/companystatus/search")
    public ModelAndView searchCompanies(@RequestParam String keyword) {
        ModelAndView mv = new ModelAndView();
        List<CompanyTableDTO> companies = adminCompanyTableStatusService.searchCompanies(keyword);
        mv.addObject("companies", companies);
        mv.setViewName("/admins/companystatus/search");
        return mv;
    }

    // 회사 등록 페이지를 표시하는 메소드
    @GetMapping("/companystatus/add")
    public String showAddCompanyForm() {
        return "/admins/companystatus/add";
    }

    // POST 요청으로 회사 데이터를 등록하는 메소드
    @PostMapping("/companystatus/add")
    public ModelAndView addCompany(@ModelAttribute CompanyTableDTO companyDto, RedirectAttributes redirectAttributes) {
        ModelAndView mv = new ModelAndView();
        adminCompanyTableStatusService.addCompany(companyDto);
        redirectAttributes.addFlashAttribute("successMessage", "새 회사가 등록되었습니다.");
        mv.setViewName("redirect:/admins/companystatus");
        return mv;
    }

}
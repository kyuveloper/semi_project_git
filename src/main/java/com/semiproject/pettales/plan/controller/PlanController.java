package com.semiproject.pettales.plan.controller;

import com.semiproject.pettales.auth.model.AuthDetails;
import com.semiproject.pettales.bookmark.dto.BookmarkDTO;
import com.semiproject.pettales.bookmark.service.BookmarkService;
import com.semiproject.pettales.company.dto.CompanyDTO;
import com.semiproject.pettales.company.dto.CompanyPaging;
import com.semiproject.pettales.company.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/plan")
public class PlanController {
    @Autowired
    private CompanyService companyService;

    @Autowired
    private BookmarkService bookmarkService;

    @GetMapping("/make_plan")
    public String makePlanView(Model model){
//        List<CompanyDTO> companyListByCtprvn = companyService.selectAllCompanyByCtprvn(page, companyCtprvn, companyClassi);
//        CompanyPaging paging = companyService.pagingParamByCtprvn(page, companyCtprvn, companyClassi);
//
//        model.addAttribute("companyCtprvn", companyCtprvn);
//        model.addAttribute("companyClassi", companyClassi);
//        model.addAttribute("paging", paging);
//
//        model.addAttribute("companyList", companyListByCtprvn);

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        AuthDetails auth = (AuthDetails)authentication.getPrincipal();
        int userCode = auth.getLoginUserDTO().getUserCode();

        List<BookmarkDTO> bookmarkList =  bookmarkService.selectBookmarkByUserCode(userCode);
        model.addAttribute("bookmark",bookmarkList);
        return "plan/planView";
    }


}
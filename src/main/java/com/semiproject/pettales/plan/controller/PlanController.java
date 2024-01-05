package com.semiproject.pettales.plan.controller;

import com.semiproject.pettales.auth.model.AuthDetails;
import com.semiproject.pettales.bookmark.dto.BookmarkDTO;
import com.semiproject.pettales.bookmark.service.BookmarkService;
import com.semiproject.pettales.company.service.CompanyService;
import com.semiproject.pettales.plan.dto.PlanDTO;
import com.semiproject.pettales.plan.service.PlanService;
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

    @Autowired
    private PlanService planService;

    @GetMapping("/make_plan")
    public String makePlanView(Model model){

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        AuthDetails auth = (AuthDetails)authentication.getPrincipal();
        int userCode = auth.getLoginUserDTO().getUserCode();

        List<String> regions = companyService.getAllRegion();
        List<String> categories = companyService.getAllCategory();

        // 기본값 설정
        String defaultRegion = "서울특별시";
        String defaultCategory = "미용";

        model.addAttribute("regions", regions);
        model.addAttribute("categories", categories);
        model.addAttribute("defaultRegion", defaultRegion);
        model.addAttribute("defaultCategory", defaultCategory);

        return "plan/planView";
    }

    @GetMapping("/plan_date")
    public String map(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        AuthDetails auth = (AuthDetails)authentication.getPrincipal();
        int userCode = auth.getLoginUserDTO().getUserCode();

        List<BookmarkDTO> userBookmarkList = bookmarkService.selectBookmarkByUserCode(userCode);
        model.addAttribute("bookmark", userBookmarkList);
        return "plan/planDate";
    }

    @GetMapping("/plan_select")
    public String planSelect(Model model){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        AuthDetails auth = (AuthDetails)authentication.getPrincipal();
        int userCode = auth.getLoginUserDTO().getUserCode();

        List<PlanDTO> planList = planService.selectPlanByUserCode(userCode);
        model.addAttribute("plans", planList);
        return "plan/planSelect";
    }

    @GetMapping("/plan_detail")
    public String planDetail(
            Model model,
            @RequestParam("planCode")int planCode){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        AuthDetails auth = (AuthDetails)authentication.getPrincipal();
        int userCode = auth.getLoginUserDTO().getUserCode();

        List<BookmarkDTO> userBookmarkList = bookmarkService.selectBookmarkByUserCode(userCode);
        PlanDTO planInfo = planService.selectPlanByPlanCode(planCode, userCode);
        model.addAttribute("bookmark", userBookmarkList);
        model.addAttribute("planInfo", planInfo);
        return "plan/planDetail";
    }

}
package com.semiproject.pettales.plan.controller;

import com.semiproject.pettales.auth.model.AuthDetails;
import com.semiproject.pettales.bookmark.dto.BookmarkDTO;
import com.semiproject.pettales.bookmark.service.BookmarkService;
import com.semiproject.pettales.company.service.CompanyService;
import com.semiproject.pettales.plan.dto.DetailPlanDTO;
import com.semiproject.pettales.plan.dto.PlanDTO;
import com.semiproject.pettales.plan.service.PlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.Date;
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

    @GetMapping("/comDetail")
    public String comDetail() {
        return "/plan/comDetail";
    }

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

        return "/plan/planView";
    }

    @GetMapping("/plan_date")
    public String map(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        AuthDetails auth = (AuthDetails)authentication.getPrincipal();
        int userCode = auth.getLoginUserDTO().getUserCode();

        List<String> regions = companyService.getAllRegion();
        List<String> categories = companyService.getAllCategory();

        model.addAttribute("regions", regions);
        model.addAttribute("categories", categories);

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

        // 서비스를 통해 시작일과 종료일을 가져온다. (planService에서 해당 메서드를 정의해야 함)
        LocalDate startDate = planService.getStartDateByPlanCodeAndUserCode(planCode, userCode);
        LocalDate endDate = planService.getEndDateByPlanCodeAndUserCode(planCode, userCode);

        PlanDTO planInfo = planService.selectPlanByPlanCode(planCode, userCode);

        List<BookmarkDTO> userBookmarkList = bookmarkService.selectBookmarkByRegion(userCode, planInfo.getPlanRegion());

        model.addAttribute("bookmark", userBookmarkList);
        model.addAttribute("planInfo", planInfo);

        // 가져온 날짜들을 모델에 담아서 Thymeleaf 템플릿으로 전달한다.
        model.addAttribute("startDate", startDate);
        model.addAttribute("endDate", endDate);
        return "plan/planDetail";
    }

    @GetMapping("/plan_detail_date")
    public String planDetailDate(Model model,
                                 @RequestParam("planCode")int planCode,
                                 @RequestParam("travelDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date travelDate){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        AuthDetails auth = (AuthDetails)authentication.getPrincipal();
        int userCode = auth.getLoginUserDTO().getUserCode();

        PlanDTO plan = planService.selectRegionByPlan(planCode, userCode, travelDate);
        List<DetailPlanDTO> detailPlanDTO = planService.selectPlanBookmark(travelDate, planCode, userCode);
        List<BookmarkDTO> userBookmarkList = bookmarkService.selectBookmarkByRegion(userCode, plan.getPlanRegion());

        DetailPlanDTO planDetail = planService.selectPlanDetailByPlanCodeAndTravelDate(planCode, travelDate, userCode);
        int planDetailCode = planDetail.getPlanDetailCode();

        model.addAttribute("detailPlan", detailPlanDTO);
        model.addAttribute("bookmark", userBookmarkList);
        model.addAttribute("planDetailCode", planDetailCode);

        return "plan/planDetailDate";
    }

}
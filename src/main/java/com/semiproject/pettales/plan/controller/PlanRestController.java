package com.semiproject.pettales.plan.controller;


import com.semiproject.pettales.auth.model.AuthDetails;
import com.semiproject.pettales.company.dto.CompanyCardDTO;
import com.semiproject.pettales.company.dto.CompanyPaging;
import com.semiproject.pettales.company.service.CompanyService;
import com.semiproject.pettales.plan.dto.BookmarkMappingDTO;
import com.semiproject.pettales.plan.dto.DetailPlanDTO;
import com.semiproject.pettales.plan.dto.PlanDTO;
import com.semiproject.pettales.plan.service.PlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class PlanRestController {

    @Autowired
    private CompanyService companyService;

    @Autowired
    private PlanService planService;

    @GetMapping("/plan_make")
    public ResponseEntity<Map<String, Object>> date(
            @RequestParam(value="page", required=false, defaultValue="1") int page,
            @RequestParam(value = "companyCtprvn", required = false) String companyCtprvn,
            @RequestParam(value = "companyClassi", required = false) String companyClassi){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        AuthDetails auth = (AuthDetails)authentication.getPrincipal();
        int userCode = auth.getLoginUserDTO().getUserCode();

        List<CompanyCardDTO> companyDTOs = companyService.selectCompanyCardByCtprvn(page, companyCtprvn, companyClassi, userCode);
        CompanyPaging paging = companyService.pagingParamByCtprvn(page, companyCtprvn, companyClassi);

        Map<String, Object> responseData = new HashMap<>();
        responseData.put("company", companyDTOs);
        responseData.put("paging", paging);

        //System.out.println("Received request - Page: " + page + ", CompanyCtprvn: " + companyCtprvn + ", CompanyClassi: " + companyClassi);

        return ResponseEntity.ok(responseData);
    }

    @GetMapping("/all_company")
    public Map<String, Object> allCompany(
            @RequestParam(value="page", required=false, defaultValue="1") int page){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        AuthDetails auth = (AuthDetails)authentication.getPrincipal();
        int userCode = auth.getLoginUserDTO().getUserCode();

        List<CompanyCardDTO> companyList = companyService.selectAllCompanyCard(page, userCode);
        CompanyPaging paging = companyService.pagingParam(page);
        Map<String, Object> result = new HashMap<>();
        result.put("company", companyList);
        result.put("paging", paging);
        return result;
    }

    @PostMapping("/add_plan")
    public int addPlan(@RequestBody PlanDTO planDTO) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        AuthDetails auth = (AuthDetails) authentication.getPrincipal();
        int userCode = auth.getLoginUserDTO().getUserCode();

        planDTO.setUserCode(userCode);
        int result = planService.insertPlan(planDTO);

        if(result < 0){
            System.out.println("실패");
        }else{
            System.out.println("성공");
        }
        return result;
    }

    @PostMapping("/insert_detail")
    public ResponseEntity<Map<String, Object>> insertDetailPlan(@RequestBody DetailPlanDTO detailPlanDTO) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        AuthDetails auth = (AuthDetails) authentication.getPrincipal();
        int userCode = auth.getLoginUserDTO().getUserCode();

        detailPlanDTO.setUserCode(userCode);
        int result = planService.insertDetailPlan(detailPlanDTO);

        System.out.println("Received date: " + detailPlanDTO.getTravelDate());
        System.out.println("Received planCode: " + detailPlanDTO.getPlanCode());

        Map<String, Object> response = new HashMap<>();
        if (result < 0) {
            System.out.println("실패");
            response.put("result", "failure");
        } else {
            System.out.println("성공");
            response.put("result", "success");
            response.put("planDetailCode", detailPlanDTO.getPlanDetailCode()); // 이 부분을 추가
        }
        System.out.println(detailPlanDTO.getPlanDetailCode());

        return ResponseEntity.ok(response);
    }

    @PostMapping("/insert_mapping")
    public int insertBookmarkMapping(@RequestBody BookmarkMappingDTO bookmarkMappingDTO){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        AuthDetails auth = (AuthDetails) authentication.getPrincipal();
        int userCode = auth.getLoginUserDTO().getUserCode();

        bookmarkMappingDTO.setUserCode(userCode);
        int result = planService.insertBookmarkMapping(bookmarkMappingDTO);

        if(result < 0){
            System.out.println("실패");
        }else{
            System.out.println("성공");
        }
        return result;
    }

    @PostMapping("/hide_plan")
    public Map<String, Object> hidePlan(
            @RequestParam("planCode")int planCode){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        AuthDetails auth = (AuthDetails) authentication.getPrincipal();
        Integer userCode = auth.getLoginUserDTO().getUserCode();

        planService.hidePlanByPlanCode(planCode, userCode);
        Map<String, Object> result = new HashMap<>();

        if (userCode == null) {
            result.put("code", "0");
            result.put("result", "error");
            result.put("errorMessage", "유저 정보를 찾을 수 없습니다.");
        } else {
            result.put("code", "1");
            result.put("result", "성공");
        }
        return result;
    }

//    @GetMapping("/detail_plan_view")
//    public Map<String, Object> detailPlanView(
//            @RequestParam("travleDate") Date travelDate,
//            @RequestParam("planDetailCode") int planDetailCode){
//
//        DetailPlanDTO detailPlan = planService.selectPlanBookmark(travelDate, planDetailCode);
//        Map<String, Object> result = new HashMap<>();
//        result.put("detailPlan",detailPlan);
//        return result;
//    }

//    @ModelAttribute("bookmark")
//    public List<BookmarkDTO> userLikeList(){
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        AuthDetails auth = (AuthDetails)authentication.getPrincipal();
//        int userCode = auth.getLoginUserDTO().getUserCode();
//
//        return companyService.addLikeList
//    }

}
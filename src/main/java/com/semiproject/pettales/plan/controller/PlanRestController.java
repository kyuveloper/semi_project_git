package com.semiproject.pettales.plan.controller;


import com.semiproject.pettales.auth.model.AuthDetails;
import com.semiproject.pettales.company.dto.CompanyCardDTO;
import com.semiproject.pettales.company.dto.CompanyPaging;
import com.semiproject.pettales.company.service.CompanyService;
import com.semiproject.pettales.plan.dto.BookmarkMappingDTO;
import com.semiproject.pettales.plan.dto.DetailPlanDTO;
import com.semiproject.pettales.plan.dto.PlanDTO;
import com.semiproject.pettales.plan.service.PlanService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

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

//    @PostMapping("/add_plan")
//    public int addPlan(@RequestBody PlanDTO planDTO) {
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        AuthDetails auth = (AuthDetails) authentication.getPrincipal();
//        int userCode = auth.getLoginUserDTO().getUserCode();
//
//        planDTO.setUserCode(userCode);
//        int result = planService.insertPlan(planDTO);
//
//        if(result < 0){
//            System.out.println("실패");
//        }else{
//            System.out.println("성공");
//        }
//        return result;
//    }

    @PostMapping("/add_plan")
    @Transactional
    public ResponseEntity<Map<String, Object>> addPlan(@RequestBody PlanDTO planDTO) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        AuthDetails auth = (AuthDetails) authentication.getPrincipal();
        int userCode = auth.getLoginUserDTO().getUserCode();

        planDTO.setUserCode(userCode);

        // PLAN_TABLE에 데이터 삽입
        int planResult = planService.insertPlan(planDTO);

        if (planResult < 0) {
            System.out.println("PLAN_TABLE 삽입 실패");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }

        System.out.println("생성된 planCode: " + planDTO.getPlanCode());
        // PLAN_TABLE에 데이터 삽입 후에 DETAIL_PLAN_TABLE에 데이터 삽입
        List<Date> dateRange = getDatesBetween(planDTO.getStartDate(), planDTO.getEndDate());

        for (Date currentDate : dateRange) {
            DetailPlanDTO detailPlanDTO = new DetailPlanDTO();
            detailPlanDTO.setPlanCode(planDTO.getPlanCode());
            detailPlanDTO.setUserCode(userCode);
            detailPlanDTO.setTravelDate(currentDate);
            System.out.println("반복문 돌아갈 때 planCode: " + planDTO.getPlanCode());
            System.out.println(currentDate);
            System.out.println(planDTO.getStartDate());
            System.out.println(planDTO.getEndDate());

            int detailPlanResult = planService.insertDetailPlan(detailPlanDTO);

            if (detailPlanResult < 0) {
                System.out.println("DETAIL_PLAN_TABLE 삽입 실패");
                // 실패 시 PLAN_TABLE 작업 롤백
                throw new RuntimeException("DETAIL_PLAN_TABLE 삽입 실패");
            }
        }

        // 성공 시 응답 반환
        System.out.println("성공");
        Map<String, Object> response = new HashMap<>();
        response.put("result", "success");
        response.put("planCode", planDTO.getPlanCode());
        return ResponseEntity.ok(response);
    }

    public static List<Date> getDatesBetween(Date startDate, Date endDate) {
        LocalDate localStartDate = startDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDate localEndDate = endDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

        return LongStream.range(0, localEndDate.toEpochDay() - localStartDate.toEpochDay() + 1)
                .mapToObj(localStartDate::plusDays)
                .map(date -> Date.from(date.atStartOfDay(ZoneId.systemDefault()).toInstant()))
                .collect(Collectors.toList());
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
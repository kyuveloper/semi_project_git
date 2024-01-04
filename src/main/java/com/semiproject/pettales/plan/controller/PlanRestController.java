package com.semiproject.pettales.plan.controller;


import com.semiproject.pettales.auth.model.AuthDetails;
import com.semiproject.pettales.bookmark.dto.BookmarkDTO;
import com.semiproject.pettales.bookmark.service.BookmarkService;
import com.semiproject.pettales.company.dto.CompanyCardDTO;
import com.semiproject.pettales.company.dto.CompanyDTO;
import com.semiproject.pettales.company.dto.CompanyPaging;
import com.semiproject.pettales.company.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class PlanRestController {

    @Autowired
    private CompanyService companyService;

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

//    @ModelAttribute("bookmark")
//    public List<BookmarkDTO> userLikeList(){
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        AuthDetails auth = (AuthDetails)authentication.getPrincipal();
//        int userCode = auth.getLoginUserDTO().getUserCode();
//
//        return companyService.addLikeList
//    }

}
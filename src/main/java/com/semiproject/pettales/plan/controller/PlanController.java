package com.semiproject.pettales.plan.controller;

import com.semiproject.pettales.company.dto.CompanyDTO;
import com.semiproject.pettales.company.dto.CompanyPaging;
import com.semiproject.pettales.company.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @GetMapping("/make_plan")
    public String makePlanView(Model model,
                               @RequestParam(value="page", required=false, defaultValue="1") int page,
                               @RequestParam(value = "companyCtprvn", required = false) String companyCtprvn,
                               @RequestParam(value = "companyClassi", required = false) String companyClassi){
        List<CompanyDTO> companyListByCtprvn = companyService.selectAllCompanyByCtprvn(page, companyCtprvn, companyClassi);
        CompanyPaging paging = companyService.pagingParamByCtprvn(page, companyCtprvn, companyClassi);

        model.addAttribute("companyCtprvn", companyCtprvn);
        model.addAttribute("companyClassi", companyClassi);
        model.addAttribute("paging", paging);

        model.addAttribute("companyList", companyListByCtprvn);

        System.out.println("page: " + page);
        System.out.println("companyCtprvn: " + companyCtprvn);

        return "plan/planView";
    }

}
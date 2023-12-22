package com.semiproject.pettales.plan.controller;

import com.semiproject.pettales.company.dto.CompanyDTO;
import com.semiproject.pettales.company.paging.CompanyPaging;
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
                               @RequestParam(value = "companyCtprvn", required = false) String companyCtprvn){
        List<CompanyDTO> companyList = companyService.selectAllCompany(page);
        //List<CompanyDTO> companyListByCtprvn = companyService.selectAllCompanyByCtprvn(page, companyCtprvn);
        CompanyPaging paging = companyService.pagingParam(page);
        //CompanyPaging paging = companyService.pagingParamByCtprvn(page, companyCtprvn);

        model.addAttribute("paging", paging);
        //model.addAttribute("paging2", paging2);
        model.addAttribute("companyList", companyList);
        //model.addAttribute("CompanyByCtprvn", companyListByCtprvn);

        System.out.println("page: " + page);
        System.out.println("companyCtprvn: " + companyCtprvn);

        return "plan/planview";
    }

}
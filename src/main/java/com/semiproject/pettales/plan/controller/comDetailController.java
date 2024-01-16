package com.semiproject.pettales.plan.controller;

import com.semiproject.pettales.company.dto.CompanyDetailDTO;
import com.semiproject.pettales.company.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class comDetailController {

    @Autowired
    private CompanyService companyService;

    @GetMapping("/comDetail")
    public ResponseEntity<List<CompanyDetailDTO>> selectCompanyDetailInfo(@RequestParam int companyCode) {
        System.out.println(companyCode);
        List<CompanyDetailDTO> comDetailInfo = companyService.comDetailInfo(companyCode);
        System.out.println(comDetailInfo);
        return ResponseEntity.ok(comDetailInfo);
    }

//    @GetMapping("comDetail")
//    public ResponseEntity<List<CompanyDetailDTO>> companyDetailInfo(@RequestParam int companyCode) {
//        List<CompanyDetailDTO> comDetailInfo = companyService.comDetailInfo(companyCode);
//        return ResponseEntity.ok(comDetailInfo);
//    }
}

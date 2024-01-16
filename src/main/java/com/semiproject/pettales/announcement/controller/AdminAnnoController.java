package com.semiproject.pettales.announcement.controller;

import com.semiproject.pettales.announcement.dto.AnnoDTO;
import com.semiproject.pettales.announcement.service.AnnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("admin/anno")
public class AdminAnnoController {

    @Autowired
    private AnnoService annoService;

    @GetMapping("annoPage")
    public String insert() {
        return "announcement/insertAnno";
    }

    @PostMapping("anno")
    public String insertAnno(AnnoDTO annoDTO) {
        annoService.insertAnno(annoDTO);

        return "index";
    }

    @GetMapping("annoEdit")
    public String annoEdit() {
        return "announcement/editAnno";
    }

    @PostMapping("updateAnno")
    public String annoEdit(AnnoDTO annoDTO) {
        annoService.updateAnno(annoDTO);

        return "index";
    }
}

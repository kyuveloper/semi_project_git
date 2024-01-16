package com.semiproject.pettales.announcement.controller;

import com.semiproject.pettales.announcement.dto.AnnoDTO;
import com.semiproject.pettales.announcement.service.AnnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("anno")
public class AnnoController {

    @Autowired
    private AnnoService annoService;

    @GetMapping("allList")
    public ModelAndView selectAllAnno(ModelAndView mv) {
        List<AnnoDTO> annos = annoService.selectAllAnno();

        mv.addObject("annos", annos);
        mv.setViewName("announcement/annoList");

        return mv;
    }
}

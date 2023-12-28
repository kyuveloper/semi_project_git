package com.semiproject.pettales.map.controller;

import com.semiproject.pettales.map.dto.MapDTO;
import com.semiproject.pettales.map.service.MapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("locations")
public class MapController {

    @Autowired
    private MapService mapService;

    @GetMapping
    public ModelAndView comLocation(ModelAndView mv) {
        List<MapDTO> locations = mapService.comLocation();

        mv.addObject("locations", locations);
        mv.setViewName("map/mapLocation");

        return mv;
    }
}
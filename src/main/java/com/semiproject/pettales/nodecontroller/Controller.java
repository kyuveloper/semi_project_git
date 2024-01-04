package com.semiproject.pettales.nodecontroller;

import org.springframework.web.bind.annotation.GetMapping;

@org.springframework.stereotype.Controller
public class Controller {

    @GetMapping("/map")
    public String map() {
        return "map/map";
    }

    @GetMapping("/anno")
    public String anno() {
        return "announcement/announcement";
    }

    @GetMapping("/insertAnno")
    public String insertAnno() {
        return "announcement/insertAnno";
    }
}

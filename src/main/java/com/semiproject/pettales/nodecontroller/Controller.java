package com.semiproject.pettales.nodecontroller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@org.springframework.stereotype.Controller
public class Controller {

    @GetMapping("/map")
    public String map() {
        return "map/map";
    }

    @GetMapping("/admin/anno")
    public String anno() {
        return "announcement/announcement";
    }

    @GetMapping("/insertAnno")
    public String insertAnno() {
        return "announcement/insertAnno";
    }
}

package com.semiproject.pettales.nodecontroller;

import com.semiproject.pettales.auth.model.AuthDetails;
import com.semiproject.pettales.bookmark.dto.BookmarkDTO;
import com.semiproject.pettales.bookmark.service.BookmarkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@org.springframework.stereotype.Controller
public class NodeController {
    @Autowired
    BookmarkService bookmarkService;

    @GetMapping("/map")
    public String map(Model model) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        AuthDetails auth = (AuthDetails)authentication.getPrincipal();
        int userCode = auth.getLoginUserDTO().getUserCode();

        List<BookmarkDTO> userBookmarkList = bookmarkService.selectBookmarkByUserCode(userCode);
        model.addAttribute("bookmark", userBookmarkList);
        return "map/map";
    }

    @GetMapping("/admin/anno")
    public String anno() {
        return "annoList";
    }

    @GetMapping("/insertAnno")
    public String insertAnno() {
        return "announcement/insertAnno";
    }
}

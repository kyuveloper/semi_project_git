package com.semiproject.pettales.map.controller;

import com.semiproject.pettales.auth.model.AuthDetails;
import com.semiproject.pettales.map.dto.ComMarkDTO;
import com.semiproject.pettales.map.service.ComMarkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class ComMarkController {

    @Autowired
    private ComMarkService comMarkService;

    @GetMapping("/map")
    public ResponseEntity<List<ComMarkDTO>> selectComMarkByUserCode() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        AuthDetails auth = (AuthDetails)authentication.getPrincipal();
        int userCode = auth.getLoginUserDTO().getUserCode();

        List<ComMarkDTO> selectComMarkByUserCode = comMarkService.selectComMarkByUserCode(userCode);

        return ResponseEntity.ok(selectComMarkByUserCode);
    }
}

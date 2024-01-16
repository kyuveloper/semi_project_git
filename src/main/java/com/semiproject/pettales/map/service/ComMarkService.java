package com.semiproject.pettales.map.service;

import com.semiproject.pettales.map.dao.ComMarkDAO;
import com.semiproject.pettales.map.dto.ComMarkDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComMarkService {
    @Autowired
    private ComMarkDAO comMarkDAO;

    public List<ComMarkDTO> selectComMarkByUserCode(int userCode) {
        return comMarkDAO.selectComMarkByUserCode(userCode);
    }
}

package com.semiproject.pettales.announcement.service;

import com.semiproject.pettales.announcement.dao.AnnoDAO;
import com.semiproject.pettales.announcement.dto.AnnoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AnnoService {
    @Autowired
    private AnnoDAO annoDAO;

    public int insertAnno(AnnoDTO annoDTO) {
        int result = annoDAO.insertAnno(annoDTO);
        if (result <= 0) {
            System.out.println("Insert Error");
        } else {
            System.out.println("Insert Success");
        }
        return result;
    }
}

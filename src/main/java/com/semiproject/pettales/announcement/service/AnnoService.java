package com.semiproject.pettales.announcement.service;

import com.semiproject.pettales.announcement.dao.AnnoDAO;
import com.semiproject.pettales.announcement.dto.AnnoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnnoService {

    @Autowired
    private AnnoDAO annoDAO;

    public List<AnnoDTO> selectAllAnno() {
        List<AnnoDTO> anno = annoDAO.selectAllAnno();

        return anno;
    }

    public int insertAnno(AnnoDTO annoDTO) {
        int result = annoDAO.insertAnno(annoDTO);
        if (result <= 0) {
            System.out.println("Insert Error");
        } else {
            System.out.println("Insert Success");
        }
        return result;
    }

    public int updateAnno(AnnoDTO annoDTO) {
        int result = annoDAO.updateAnno(annoDTO);
        if (result <= 0) {
            System.out.println("Update Error");
        } else {
            System.out.println("Update Success");
        }
        return result;
    }
}

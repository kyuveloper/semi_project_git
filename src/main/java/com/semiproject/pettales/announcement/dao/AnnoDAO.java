package com.semiproject.pettales.announcement.dao;

import com.semiproject.pettales.announcement.dto.AnnoDTO;
import com.semiproject.pettales.company.dto.CompanyDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AnnoDAO {
    int insertAnno(AnnoDTO annoDTO);

    int updateAnno(AnnoDTO annoDTO);
}

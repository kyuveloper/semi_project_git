package com.semiproject.pettales.announcement.dao;

import com.semiproject.pettales.announcement.dto.AnnoDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AnnoDAO {

    List<AnnoDTO> selectAllAnno();

    int insertAnno(AnnoDTO annoDTO);

    int updateAnno(AnnoDTO annoDTO);
}

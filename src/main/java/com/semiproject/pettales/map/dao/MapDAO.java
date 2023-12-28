package com.semiproject.pettales.map.dao;

import com.semiproject.pettales.map.dto.MapDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MapDAO {
    List<MapDTO> comLocation();
}

